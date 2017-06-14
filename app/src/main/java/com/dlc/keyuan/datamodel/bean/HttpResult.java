package com.dlc.keyuan.datamodel.bean;

import java.util.List;

/**
 * @date 2017/5/12
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description
 */

public class HttpResult<T> extends NetBase {
    List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
