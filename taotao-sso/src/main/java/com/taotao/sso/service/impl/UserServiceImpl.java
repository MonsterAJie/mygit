package com.taotao.sso.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.dao.JedisClient;
import com.taotao.sso.service.UserService;

/**
 * 用户管理Service
 * <p>Title: UserServiceImpl</p>

 */
@Service
public class UserServiceImpl implements UserService {
	/**
	 * log打印
	 */
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	/**
	 * rabbitmq
	 */
	private static final String EXCHANGE_NAME = "topic_logs";
	
    @Autowired
    @Qualifier("rabbitTemplateEmail")
    public RabbitTemplate rabbitTemplateEmail;
	
	@Autowired
	private TbUserMapper userMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;
	
	@Override
	public TaotaoResult checkData(String content, Integer type) {
		//创建查询条件
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		//对数据进行校验：1、2、3分别代表username、phone、email
		//用户名校验
		if (1 == type) {
			criteria.andUsernameEqualTo(content);
		//电话校验
		} else if ( 2 == type) {
			criteria.andPhoneEqualTo(content);
		//email校验
		} else {
			criteria.andEmailEqualTo(content);
		}
		//执行查询
		List<TbUser> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return TaotaoResult.ok(true);
		}
		return TaotaoResult.ok(false);
	}

	@Override
	public TaotaoResult createUser(TbUser user) {
		user.setUpdated(new Date());
		user.setCreated(new Date());
		user.setStatus(String.valueOf(0));
		//md5加密
		Base64 base64 = new Base64();
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		logger.debug("保存用户数据--------带激活信息----------");
		user.setActcode(md5Pass);
		logger.debug("保存用户数据--------带激活信息----------");
		userMapper.insert(user);
		logger.debug("发送用户邮箱激活信息-----调用rabbitmq---------");
		//将用户信息放到消息队列
		logger.debug("用户激活连接信息获取--------base64编码格式----------");
		String actinfo = base64.encodeToString(user.getId().toString().getBytes());
		rabbitTemplateEmail.convertAndSend(actinfo);
		//发送邮件
		return TaotaoResult.ok("请到邮箱查收激活信息！");
	}

	/**
	 * 用户登录
	 * <p>Title: userLogin</p>
	 * <p>Description: </p>
	 * @param username
	 * @param password
	 * @return
	 * @see com.taotao.sso.service.UserService#userLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public TaotaoResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = userMapper.selectByExample(example);
		//如果没有此用户名
		if (null == list || list.size() == 0) {
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		TbUser user = list.get(0);
		//比对密码
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		if (!user.getStatus().equals("1")) {
			return TaotaoResult.build(400, "账号未激活，请进入注册邮箱激活");
		}
		//生成token
		String token = UUID.randomUUID().toString();
		//保存用户之前，把用户对象中的密码清空。
		user.setPassword(null);
		//把用户信息写入redis
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//设置session的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		
		//添加写cookie的逻辑，cookie的有效期是关闭浏览器就失效。
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		
		//返回token
		return TaotaoResult.ok(token);
	}

	@Override
	public TaotaoResult getUserByToken(String token) {
		
		//根据token从redis中查询用户信息
		String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
		//判断是否为空
		if (StringUtils.isBlank(json)) {
			return TaotaoResult.build(400, "此session已经过期，请重新登录");
		}
		//更新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		//返回用户信息
		return TaotaoResult.ok(JsonUtils.jsonToPojo(json, TbUser.class));
	}

	@Override
	public TaotaoResult userLogout(String token, HttpServletRequest request, HttpServletResponse response) {
		jedisClient.del(REDIS_USER_SESSION_KEY + ":" + token);
		CookieUtils.deleteCookie(request, response, "TT_TOKEN");
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult userActivity(String id, String actcode) {
		Base64 base = new Base64();
		String ids = new String(base.decode(id));
		String actcodes = new String(base.decode(actcode));
		TbUser users = userMapper.selectByPrimaryKey(Long.valueOf(ids));
		if (users.getActcode().equals(actcodes)) {
			//激活标志置为1
			users.setStatus("1");
		}
		userMapper.updateByPrimaryKey(users);
		return TaotaoResult.ok();
	}
	
	public static void main(String[] args) {
//		rabbitTemplateLogInfo.convertAndSend("11111");
	}


}
