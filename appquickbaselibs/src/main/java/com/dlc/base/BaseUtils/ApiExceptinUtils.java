package com.dlc.base.BaseUtils;


import android.text.TextUtils;

import com.dlc.base.BaseHttp.ApiExcetion;
import com.google.gson.JsonSyntaxException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;


/**
 * @date 2017/5/6
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  baseactivty 提供一些常用接口给子类实现，建议上层再继承这个写一个抽象类
 */

public class ApiExceptinUtils {

    public final static String NET_ERROR_404 = "404";
    public final static String NET_ERROR_500 = "500";
    public static ApiExcetion handleThrow(Throwable throwable){
        return new ApiExcetion(handMsg(throwable));
    }

    public static String handMsg(Throwable e){
         String msg = e.getMessage();

        if(TextUtils.isEmpty(msg))
            msg = "null msg";
        //默认提示错误
         String errorMsg = "请求网络失败";

        if(msg.contains(NET_ERROR_404)){//服务器接口出错
            errorMsg = "服务器接口出错404";
        } else if(msg.contains(NET_ERROR_500)){//服务器哦接口出错
                errorMsg = "服务器接口出错500";
        } else if(e instanceof ConnectException){//连接失败
              errorMsg = "网络连接失败，请检查网络连接";
        } else if(e instanceof SocketTimeoutException){//连接超时
              errorMsg = "网络连接超时，请重新请求";
        } else if(e instanceof TimeoutException){//连接超时
              errorMsg = "网络连接超时，请重新请求";
        } else if(e instanceof JsonSyntaxException){
            errorMsg = "JSON解析出错：msg";
        } else {
            errorMsg += msg;
        }

        return errorMsg;
    }
}
