package com.winorout.yygo.myc.http.Api;

import com.winorout.yygo.myc.http.retrofit.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/4 上午10:45
 */
public interface IUserApi {

    @FormUrlEncoded
    @POST("users/login")
    Observable<HttpResponse> login(@FieldMap Map<String, Object> params);

    // 参数较多
//    @GET("users/login")
//    Observable<HttpResponse> login(@QueryMap Map<String, Object> request);
}
