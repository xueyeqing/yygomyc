package com.winorout.yygo.myc.http.Api;

import com.winorout.yygo.myc.http.retrofit.RetrofitUtils;

/**
 * @Description: 接口工具类
 * @Author: zyzhang
 * @Date: 17/11/4 上午10:43
 */
public class ApiUtils {

    public static IUserApi userApi;

    public static IUserApi getUserApi() {
        if (userApi == null) {
            userApi = RetrofitUtils.get().retrofit().create(IUserApi.class);
        }
        return userApi;
    }
}
