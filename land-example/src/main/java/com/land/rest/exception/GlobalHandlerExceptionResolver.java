package com.land.rest.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName:  GlobalHandlerExceptionResolver   
 * @Description:TODO(全局异常处理器)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:23:24   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
	
	private Logger logger = LoggerFactory.getLogger(GlobalHandlerExceptionResolver.class);

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info(ex.getMessage());
		//返回一个错误界面 或  null
	    return new ModelAndView(); 
	}
}
