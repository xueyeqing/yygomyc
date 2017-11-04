package com.winorout.yygo.myc.http.function;

import com.winorout.yygo.myc.http.exception.ExceptionEngine;
import com.winorout.yygo.myc.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * @Description: 处理请求结果
 * @Author: zyzhang
 * @Date: 17/11/4 上午10:01
 */
public class HttpResultFunction<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        //打印具体错误
        LogUtils.e("HttpResultFunction:" + throwable);
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
