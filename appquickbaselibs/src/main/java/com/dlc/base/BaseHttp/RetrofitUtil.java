package com.dlc.base.BaseHttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date 2017/5/8
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  请求网络工具类，okhttp+ refrofit 相对于上层用户，只提供各种请求方式，不用写依赖注释
 */

public class RetrofitUtil {

    public static  String BASE_URL = NetConstant.BASE_URL;//请求baseurl

    private static final int DEFAULT_TIMEOUT = 30;

    private Retrofit retrofit;

    private HttpService httpService;

    //构造方法私有
    private RetrofitUtil() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        httpService = retrofit.create(HttpService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final RetrofitUtil INSTANCE = new RetrofitUtil();
    }

    //获取单例
    public static RetrofitUtil getInstance(){
        return SingletonHolder.INSTANCE;
    }


    public HttpService  getApiServer(){
        return httpService;
    }


    public static void initRetrofit(String baseUrl){
        BASE_URL = baseUrl;
    }



}