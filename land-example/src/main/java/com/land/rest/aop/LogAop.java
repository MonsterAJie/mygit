package com.land.rest.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName:  LogAop   
 * @Description:TODO(切面类，用于打印日志)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:11:13   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@Component
public class LogAop {
	
	private final Logger logger = LoggerFactory.getLogger(LogAop.class);
 
	/**
	 * 
	 * @Title: before   
	 * @Description: TODO(被切方法前执行)   
	 * @param: @param joinPoint      
	 * @return: void      
	 * @throws
	 */
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		try {
			logger.info("=====Entering   " + methodName + "()=====");
			logger.info("请求方法:"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()"));
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==Entering   " + methodName + "()异常==");
			logger.error("异常信息:{}", e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title: after   
	 * @Description: TODO(被切方法后执行)   
	 * @param: @param joinPoint      
	 * @return: void      
	 * @throws
	 */
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		try {
			logger.info("=====leaving   " + methodName + "()=====");
			// contentToTxt("=====leaving   " + methodName + "()=====");
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==leaving   " + methodName + "()异常==");
			logger.error("异常信息:{}", e.getMessage());
		}
	}
 
	/**
	 * 
	 * @Title: afterThrowing   
	 * @Description: TODO(被切方法出现异常执行)   
	 * @param: @param joinPoint
	 * @param: @param e      
	 * @return: void      
	 * @throws
	 */
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		String params = "";
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			for (Object obj : args) {
				if (null != obj) {
					Field[] fields = obj.getClass().getDeclaredFields();
					if (null != fields && fields.length > 0) {
						params += obj.getClass().getSimpleName() + "[";
						for (Field field : fields) {
							String name = field.getName();
							Object value = getFieldValueByName(name, obj);
							if (null != value && (!"".equals(value))) {
								params += name + ":" + value + ";";
							}
						}
						params += "],";
					} else {
						params += obj.getClass().getSimpleName() + ":"
								+ obj.toString() + ";";
					}
				}
			}
		}
		String methodName = joinPoint.getSignature().getName();
		try {
			/* ========控制台输出========= */
			logger.info("=====Entering   " + methodName + "()异常=====");
			logger.info("异常代码:" + e.getClass().getName());
			logger.info("异常信息:" + e.getMessage());
			logger.info("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()"));
			logger.info("请求参数:" + params);
			// ==========数据库日志=========
			logger.info("=====leaving   " + methodName + "()异常=====");
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("==" + methodName + "()异常通知异常==");
			logger.error("异常信息:{}", ex.getMessage());
			logger.error("==" + methodName + "()异常结束==");
		}
		// ==========记录本地异常日志==========
		logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget()
				.getClass().getName() + "."
				+ joinPoint.getSignature().getName(), e.getClass().getName(),
				e.getMessage(), params);
 
	}
 
	/**
	 * 
	 * @Title: getFieldValueByName   
	 * @Description: TODO(通过属性名得到值)   
	 * @param: @param fieldName 字段名
	 * @param: @param o 待提取值得类
	 * @return: Object 根据属性名得到的值
	 * @throws
	 */
	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			if (o.getClass().getName().startsWith("com.land")) {
				Method method = o.getClass().getMethod(getter, new Class[] {});
				Object value = method.invoke(o, new Object[] {});
				return value;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
 
}