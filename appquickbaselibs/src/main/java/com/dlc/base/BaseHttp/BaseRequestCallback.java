package com.dlc.base.BaseHttp;


import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @date 2017/5/8
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  网络请求回调，已经实现类在dialogrequstcallback，也可以自行实现
 */

public  abstract  class BaseRequestCallback<T> {

    public Type mType;//范型

    public BaseRequestCallback() {
        mType = getSuperclassTypeParameter(getClass());
    }


    static Type getSuperclassTypeParameter(Class<?> subclass)
    {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    /**
     * 请求失败
     * @param e
     */
    public abstract void requestFail(ApiExcetion e);

    /**
     * 请求成功
     * @param result
     */
   public abstract void requestSuccess(T result);

    /**
     * 请求完成
     */
    public abstract void requestComplete();
    /**
     * 请求之前
     */
    public abstract void requestBefore();

}
