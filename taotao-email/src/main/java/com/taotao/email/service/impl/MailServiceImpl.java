package com.taotao.email.service.impl;

import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.email.service.MailService;
import com.taotao.email.utils.EmailUtils;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
@Service
public class MailServiceImpl implements MailService {
	/**
	 * log打印
	 */
	private Logger logger = Logger.getLogger(MailServiceImpl.class);
	
	@Autowired
	private TbUserMapper userMapper;
	
	private String emailmodel = "email.model";//模板名称.后缀
	private String subject = "账号激活";
	
	@Override
	public TaotaoResult createMail(Long id) {
		//查询用户信息
		TbUser user = userMapper.selectByPrimaryKey(id);
		//发送邮箱
		logger.debug("------------------初始化邮箱内容！-------------");
		StringBuffer sbf = new StringBuffer();
		Base64 base = new Base64();
		String idBase = base.encodeToString(user.getId().toString().getBytes());
		String actBase = base.encodeToString(user.getActcode().getBytes());
		sbf.append("您好：<p class=\"body\" style=\"margin: 1em 0px; color: rgb(51, 51, 51); font-size: 10px;\">您的账号已注册成功，请点击链接完成激活：<br><br><br>");
		sbf.append("<a href=\"http://localhost:8084/user/activity/" + idBase + "/" + actBase  + "\" target=\"_blank\">激活链接</a></p>");
		String content = sbf.toString();//正文
		EmailUtils eu = EmailUtils.getInstance();
//		eu.configurationFile();//测试配置文件
		logger.debug("------------------初始化收件人信息！-------------");
		String[] to = user.getEmail().split("/");
		String[] fileList = {};
		String[] copyto = {};
		boolean flag = eu.sendEmailCase(emailmodel, copyto, subject, content, fileList, to);
		if (flag == true) {
			return TaotaoResult.ok();
		} else {
			TaotaoResult taotaoResult = new TaotaoResult();
			taotaoResult.setStatus(400);
			taotaoResult.setMsg("邮箱发送失败！");
			return taotaoResult;
		}
	}
}
