package com.land.rest.pojo;

/**
 * 
 * @ClassName:  ResultResponse   
 * @Description:TODO(数据结果集包装类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:25:39   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class ResultResponse {

    private static final String CODE_SUCCESS = "success";

    private static final String CODE_FAIL = "fail";

    private String code;
    
    private Object data;

    public ResultResponse() {

    }

    public ResultResponse(String code) {
        this.code = code;
    }

    public ResultResponse(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static ResultResponse success() {
    	ResultResponse result = new ResultResponse();
    	result.setCode(CODE_SUCCESS);
        return result;
    }

    public static ResultResponse success(Object data) {
        return new ResultResponse(CODE_SUCCESS, data);
    }

    public static ResultResponse fail(String data) {
        return new ResultResponse(CODE_FAIL, data);
    }

    public void widthCode(String errorCode) {
    	this.code = errorCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
