package com.dlc.keyuan.datamodel.bean;

import java.io.Serializable;


/**
 * @date 2017/5/12
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description
 */

public class NetBase implements Serializable{
    String msg;
    int code;
    String token;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
