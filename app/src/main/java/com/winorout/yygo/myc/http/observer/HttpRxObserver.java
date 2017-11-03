package com.winorout.yygo.myc.http.observer;

import com.winorout.yygo.myc.http.exception.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:48
 */
public abstract class HttpRxObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    protected abstract void onStart(Disposable d);

    /**
     * 错误/异常回调
     *
     * @author ZhongDaFeng
     */
    protected abstract void onError(ApiException e);

    /**
     * 成功回调
     *
     * @author ZhongDaFeng
     */
    protected abstract void onSuccess(T response);

}
