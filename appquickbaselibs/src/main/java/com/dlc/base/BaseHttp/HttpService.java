package com.dlc.base.BaseHttp;



import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @date 2017/5/8
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  refrofit service
 */

public interface HttpService {

    @GET()
    Observable<ResponseBody> get(
            @Url String url,
            @QueryMap Map<String, Object> maps);


    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> post(
            @Url String url,
            @FieldMap Map<String, Object> maps);


    /**
     * 多文件上传
     * @param parts //文件body
     * @return
     */
    @Multipart
    @POST()
    Observable<ResponseBody> upLoadFiles(
            @Url String url,
            @Part List<MultipartBody.Part> parts);


////
//    /**
//     * 多文件上传
//     * @param params
//     * @return
//     */
//    @Multipart
//    @POST()
//    Observable<ResponseBody> uploadTest(
//            @Part("url") String url,
//            @PartMap Map<String, RequestBody> params);
//
//
//    /**
//     * 单文件上传
//     * @return
//     */
//    @Multipart
//    @POST()
//    Observable<ResponseBody> uploadSingle(@Part("description") RequestBody description,
//                                          @Part MultipartBody.Part file);
//
//
//    /**
//     * 下载
//     * @param fileUrl
//     * @return
//     */
//    @Streaming
//    @GET
//    @Headers("download:true")
//    Observable<ResponseBody> download(@Url String fileUrl);
}