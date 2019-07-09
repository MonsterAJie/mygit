package com.land.rest.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.land.rest.enums.ResultCode;
import com.land.rest.pojo.ResultResponse;

/**
 * 
 * @ClassName:  GlobalHandlerException   
 * @Description:TODO(自定义全局异常处理器)   
 * @author: AJie
 * @date:   2019年6月6日 
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@RestControllerAdvice
public class GlobalHandlerException {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

    private final static String NO_URL_FOUND = "404";

    /**
     * 
     * @Title: handleHOPException   
     * @Description: TODO(自定义异常处理)   
     * @param: @param e
     * @param: @return      
     * @return: ResultResponse      
     * @throws
     */
    @ExceptionHandler(BusinessException.class)
    public ResultResponse handleHOPException(BusinessException e){
    	ResultResponse result = new ResultResponse();
    	logger.error(new Date() + ": " + e.getMessage(), e);
    	return result;
    }

    /**
     * 
     * @Title: handlerNoFoundException   
     * @Description: TODO()   
     * @param: @param e
     * @param: @return      
     * @return: ResultResponse      
     * @throws
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultResponse handlerNoFoundException(Exception e) {
    	ResultResponse result = new ResultResponse();
    	logger.error(new Date() + ": " + e.getMessage(), e);
    	return result;
    }

    /**
     * 
     * @Title: handleException   
     * @Description: TODO()   
     * @param: @param e
     * @param: @return      
     * @return: ResultResponse      
     * @throws
     */
    @ExceptionHandler(Exception.class)
    public ResultResponse handleException(Exception e){
    	ResultResponse result = new ResultResponse();
    	logger.error(new Date() + ": " + e.getMessage(), e);
    	result.setCode("false");
    	result.setData(ResultCode.UNKNOW_ERROR);
        return result;
    }
}
