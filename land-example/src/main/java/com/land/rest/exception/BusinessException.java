package com.land.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.land.rest.pojo.ResultResponse;

/**
 * 
 * @ClassName:  BusinessException   
 * @Description:TODO(抛异常专用类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:23:06   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = -8384360434572237992L;

	private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);

    protected String errorCode;
    
    protected String[] errorMessageArguments;
    
    protected ResultResponse resultResponse;

    protected BusinessException() {
        this("");
    }

    public BusinessException(String message) {
        super(message);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public static BusinessException withErrorCode(String errorCode) {
        BusinessException businessException = new BusinessException();
        businessException.errorCode = errorCode;
        return businessException;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String[] getErrorMessageArguments() {
        return this.errorMessageArguments;
    }

    public BusinessException withErrorMessageArguments(String... errorMessageArguments) {
        if(errorMessageArguments != null) {
            this.errorMessageArguments = errorMessageArguments;
        }

        return this;
    }

    public ResultResponse response() {
        if (this.resultResponse != null) {
            return this.resultResponse;
        } else {
//        	ResultResponse result = new ResultResponse();
        	this.resultResponse.widthCode(this.getErrorCode());
//            this.resultResponse = result.widthCode(this.getErrorCode());
            if (this.getErrorMessageArguments() != null && this.getErrorMessageArguments().length > 0) {
                try {
//                    this.resultResponse.setMsg(MessageFormat.format(this.resultResponse.getData() ,this.getErrorMessageArguments()));
                } catch (Exception var2) {
                    LOGGER.error(var2.getMessage());
                }
            }
            return this.resultResponse;
        }
    }
}
