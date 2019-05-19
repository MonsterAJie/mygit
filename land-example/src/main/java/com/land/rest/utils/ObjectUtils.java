package com.land.rest.utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName:  ObjectUtils   
 * @Description:TODO(类信息转换工具)   
 * @author: AJie
 * @date:   2018年11月11日 下午11:11:15   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class ObjectUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

	public static Object ref (Object dist, Object o) {
		if (null == dist || null == o) {
			return new Object();
		}
		Field[ ] fields = dist.getClass().getDeclaredFields();
		Object code = null;
		try {
			code = o.getClass().newInstance();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		for (Field field : fields) {
			if (compare(code, field.getName())) {
				Field fd = null;
				try {
					fd = code.getClass().getDeclaredField(field.getName());
				} catch (Exception e) {
					logger.debug(e.getMessage());
				}
				fd.setAccessible(true);
				field.setAccessible(true);
				try {
					fd.set(code, field.get(dist));
				} catch (Exception e) {
					logger.debug(e.getMessage());
				}
			}
		}
		return code;
	}
	
	private static boolean compare(Object code, String str) {
		try {
			code.getClass().getDeclaredField(str);
		} catch (NoSuchFieldException e) {
			logger.debug("无字段" + str + "信息！");
			return false;
		} catch (SecurityException e) {
			logger.debug("字段" + str + "异常！");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
//		EmpInfo empBaseInfo = new EmpInfo();
//		Employee empTemp = new Employee();
//		EmployeeInfo empInfoTemp = new EmployeeInfo();
//		Employee emp = new Employee();
//		EmployeeInfo empInfo = new EmployeeInfo();
	}
	
}
