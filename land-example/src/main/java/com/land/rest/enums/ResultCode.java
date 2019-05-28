package com.land.rest.enums;

public enum ResultCode {
    //检查输入项不能为空错误码
    IS_NOT_BLANK_ERROR("999001", "请检查输入项，不能为空"),
    SUCCESS("000000", "success"),
    UNKNOW_ERROR("999999","系统未知异常");
    
    private String code;
	
    private String message;
    
    //省略其他错误码定义
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
