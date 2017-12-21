package com.winorout.yygo.myc.http.retrofit;

import io.reactivex.disposables.Disposable;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/12/21 下午12:10
 */
public interface RxActionManager<T> {
    /**
     * 添加
     *
     * @param tag
     * @param disposable
     */
    void add(T tag, Disposable disposable);

    /**
     * 移除
     *
     * @param tag
     */
    void remove(T tag);

    /**
     * 取消
     *
     * @param tag
     */
    void cancel(T tag);

}
