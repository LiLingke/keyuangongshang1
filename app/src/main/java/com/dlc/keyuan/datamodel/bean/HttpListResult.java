package com.dlc.keyuan.datamodel.bean;

/**
 * @date 2017/5/12
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description
 */

public class HttpListResult<T> extends NetBase {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
