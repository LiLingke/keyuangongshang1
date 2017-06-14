package com.dlc.base.BaseHttp;

/**
 * @date 2017/5/8
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  管理网络请求异常
 */

public class ApiExcetion extends Exception {

    private String errorMsg = "";//错误信息
    private String code;//错误码
    public ApiExcetion(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ApiExcetion(Throwable throwable) {
        super(throwable);
    }

    public ApiExcetion(String errorMsg, String code) {
        this.errorMsg = errorMsg;
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
