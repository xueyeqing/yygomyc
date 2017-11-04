package com.winorout.yygo.myc.http.Api;

import com.winorout.yygo.myc.http.retrofit.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/4 上午10:45
 */
public interface IUserApi {
    @GET("user/login")
    Observable<HttpResponse> login(@QueryMap Map<String, Object> request);
}
