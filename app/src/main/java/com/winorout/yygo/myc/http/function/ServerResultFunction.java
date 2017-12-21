package com.winorout.yygo.myc.http.function;

import com.google.gson.Gson;
import com.winorout.yygo.myc.http.exception.ServerException;
import com.winorout.yygo.myc.http.retrofit.HttpResponse;
import com.winorout.yygo.myc.utils.LogUtils;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * @Description: 服务器端返回结果处理
 * @Author: zyzhang
 * @Date: 17/11/4 上午9:42
 */
public class ServerResultFunction implements Function<HttpResponse, Object> {
    @Override
    public Object apply(@NonNull HttpResponse response) throws Exception {
        //打印服务器回传结果
        LogUtils.e(response.toString());
        if (!response.isSuccess()) {
            throw new ServerException(response.getCode(), response.getMsg());
        }
        return new Gson().toJson(response.getResult());
    }
}
