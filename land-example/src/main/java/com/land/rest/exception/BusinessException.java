package com.land.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.land.rest.enums.ResultCode;
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
	
    private String returnMsg;
    /**
     * returnCode 表示HOP内部错误码
     */
    private String returnCode = "999999";
    private String errorMsg;

    /**
     * errorCode 表示后台系统返回错误码
     */
    private String errorCode = "999999";
    //...省略N个重载的构造函数
    public BusinessException(String returnMsg, String returnCode, String errorMsg, String errorCode) {
        super(returnMsg);
        this.returnMsg = returnMsg;
        this.returnCode = returnCode;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BusinessException(String returnMsg, String returnCode, String errorMsg, String errorCode, Throwable e) {
        super(returnMsg, e);
        this.returnMsg = returnMsg;
        this.returnCode = returnCode;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BusinessException(ResultCode resultCode, Throwable e) {
        super(resultCode.getMessage(), e);
        this.errorMsg = resultCode.getMessage();
        this.errorCode = resultCode.getCode();
    }

    public BusinessException(ResultCode resultCode) {
        this.errorMsg = resultCode.getMessage();
        this.errorCode = resultCode.getCode();
    }
}
