package com.land.rest.utils;

import java.text.DecimalFormat;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.land.rest.constant.Constant;
import com.land.rest.dao.JedisClient;
import com.land.rest.model.Company;
import com.land.rest.model.Department;
import com.land.rest.pojo.EmpInfo;
import com.land.rest.service.EmployeeService;

/**
 * 
 * @ClassName:  IDUtils   
 * @Description:TODO(id处理类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:27:59   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@Component
public class IDUtils {

	@Resource
	private static JedisClient jedisClient;
	
	public static IDUtils idUtils;
	
	@PostConstruct
    public void init() {
    	idUtils = this;
    } 
    /**
     * @param id 整形id
     * @return	  长度10字符串id
     */
    public static String getID(long id){
        DecimalFormat idFormat = new DecimalFormat("0000000000");
        return idFormat.format(id);
    }
    
	public static void setComId(Company o) {
		if (null == o) {
			return;
		}
		long l = jedisClient.incr(Constant.REDIS_COM_ID_KEY);
		o.setCoId((int) l);
	}
	
	public static void setDeptId(Department o) {
		if (null == o) {
			return;
		}
		long l = jedisClient.incr(Constant.REDIS_DEPT_ID_KEY);
		o.setDeptId((int) l);
	}
    
	public static void setEmpId(EmpInfo o) {
		if (null == o) {
			return;
		}
		long l = jedisClient.incr(Constant.REDIS_EMP_ID_KEY);
		o.getEmp().setEmpId((int) l);
		o.getEmpinfo().setEmpId((int) l);
	}
	
}
