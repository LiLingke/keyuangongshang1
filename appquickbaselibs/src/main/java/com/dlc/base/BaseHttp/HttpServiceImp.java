package com.dlc.base.BaseHttp;

import android.os.Handler;
import android.os.Looper;

import com.dlc.base.BaseApp.BaseApplication;
import com.dlc.base.BaseUtils.ApiExceptinUtils;
import com.dlc.base.BaseUtils.NetUtils;
import com.dlc.base.BaseUtils.ToastUtil;
import com.dlc.base.R;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * @date 2017/5/8
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  service实现类，提供get post uploadfile
 */

public class HttpServiceImp {

    enum  HTTP_MOTHOD {
        HTTP_GET,//Get请求
        HTTP_POST,//Post请求
        HTTP_UP_LOAD_FILES//多文件请求
    }

    public <T> void httpGet(String addUrl, Map<String, Object> maps, final BaseRequestCallback<T> callBack){
          http(addUrl,maps,null,null,callBack, HTTP_MOTHOD.HTTP_GET);
    }

    public <T> void httpPost(String addUrl, Map<String, Object> maps, final BaseRequestCallback<T> callBack){
        http(addUrl,maps,null,null,callBack, HTTP_MOTHOD.HTTP_POST);
    }

    private  <T> void http(String addUrl, Map<String, Object> maps, List<MultipartBody.Part> parts, List<File> fileList, final BaseRequestCallback<T> callBack, HTTP_MOTHOD httpMothod){
        if(!checkNetWork()){
            return;
        }
        Observable<ResponseBody> resultObservable = null;
        if(httpMothod == HTTP_MOTHOD.HTTP_GET){
            resultObservable =  RetrofitUtil.getInstance().getApiServer().get(addUrl,maps);
        } else if(httpMothod == HTTP_MOTHOD.HTTP_POST) {
            resultObservable =  RetrofitUtil.getInstance().getApiServer().post(addUrl,maps);
        } else if(httpMothod == HTTP_MOTHOD.HTTP_UP_LOAD_FILES){
            resultObservable =  RetrofitUtil.getInstance().getApiServer().upLoadFiles(addUrl,createMultiPartBody(maps));
        }
                resultObservable
                .subscribeOn(Schedulers.io())
                 .map(new Func1<ResponseBody, T>() {
                            @Override
                            public T call(ResponseBody responseBody) {
                                //处理 responsebody转化成解析对象
                                String jstr = null;
                                T httpdata = null;
                                try {
                                    jstr = new String(responseBody.bytes());
                                    httpdata = new Gson().fromJson(jstr, callBack.mType);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return httpdata;
                            }
                        })
                        .doOnError(new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) { //错误处理
                                if(callBack != null){
                                    callBack.requestFail(ApiExceptinUtils.handleThrow(throwable));
                                }
                            }
                        })
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubsciber<T>(callBack));//解析之后处理回调

    }


    /**
     * 上传多图片
     * @param maps
     * @return
     */
    private List<MultipartBody.Part> createMultiPartBody(Map<String, Object> maps){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);//表单类型
        if(maps != null){
            for(Map.Entry<String,Object> entry:maps.entrySet()){
                if(entry.getValue() instanceof File){
                    File file = (File) entry.getValue();
                    RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    builder.addFormDataPart("mark", file.getName(), imageBody);
                } else {
                     builder.addFormDataPart(entry.getKey(), (String) entry.getValue());
                }
            }
        }

        List<MultipartBody.Part> partList = builder.build().parts();
        return partList;
    }

    /**
     * 检查是否有网络
     */
    private boolean checkNetWork(){
        boolean isHsNet = NetUtils.isConnected(BaseApplication.mInstance);

        if(!isHsNet){
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    ToastUtil.showOne(BaseApplication.getCurrentActivity(),BaseApplication.getCurrentActivity().getString(R.string.net_error));
                }
            });

        }

        return isHsNet;
    }
}
