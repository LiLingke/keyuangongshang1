package com.dlc.base.BaseHttp;

import com.dlc.base.BaseUtils.ApiExceptinUtils;

import rx.Subscriber;

/**
 * @date 2017/5/9
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  rx观察者，网络回调处理
 */

public  class BaseSubsciber<T> extends Subscriber<T> {

    private BaseRequestCallback<T> callback;//请求回调

    public BaseSubsciber(BaseRequestCallback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(callback != null){
            callback.requestBefore();
        }
    }

    @Override
    public void onCompleted() {
        if(callback != null){
            callback.requestComplete();
        }
    }

    @Override
    public void onError(Throwable e) {
        if(callback != null){
            callback.requestFail(ApiExceptinUtils.handleThrow(e));
        }
    }

    @Override
    public void onNext(T t) {
        if(callback != null){
            callback.requestSuccess(t);
        }
    }
}
