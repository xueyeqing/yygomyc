package com.winorout.yygo.myc.http.observer;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.winorout.yygo.myc.http.function.HttpResultFunction;
import com.winorout.yygo.myc.http.function.ServerResultFunction;
import com.winorout.yygo.myc.http.retrofit.HttpResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Description: 适用Retrofit网络请求Observable(被监听者)
 * @Author: zyzhang
 * @Date: 17/11/4 上午9:24
 */
public class HttpRxObservable {

    /**
     * 获取被监听者
     * 备注:网络请求Observable构建
     *
     * @param apiObservable 无管理生命周期, 容易导致内存溢出
     */
    public static Observable getObservable(Observable<HttpResponse> apiObservable) {
        Observable observable = apiObservable
                .map(new ServerResultFunction())
                .onErrorResumeNext(new HttpResultFunction<>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /**
     * 获取被监听者
     * 备注:网络请求Observable构建
     *
     * @param apiObservable 传入LifecycleProvider自动管理生命周期, 避免内存溢出
     *                      备注:需要继承RxActivity.../RxFragment...
     */
    public static Observable getObservable(Observable<HttpResponse> apiObservable, LifecycleProvider lifecycle) {
        Observable observable;

        if (lifecycle != null) {
            //随生命周期自动管理.eg:onCreate(start)->onStop(end)
            observable = apiObservable
                    .map(new ServerResultFunction())
                    .compose(lifecycle.bindToLifecycle())//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }

    /**
     * @param apiObservable
     * @param lifecycle
     * @param event         传入LifecycleProvider<ActivityEvent>手动管理生命周期,避免内存溢出
     *                      备注:需要继承RxActivity,RxAppCompatActivity,RxFragmentActivity
     */
    public static Observable getObservable(Observable<HttpResponse> apiObservable, LifecycleProvider<ActivityEvent> lifecycle, ActivityEvent event) {
        Observable observable;
        if (lifecycle != null) {
            //手动管理移除监听生命周期.eg:ActivityEvent.STOP
            observable = apiObservable
                    .map(new ServerResultFunction())
                    .compose(lifecycle.bindUntilEvent(event))//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }

    /**
     * @param apiObservable
     * @param lifecycle
     * @param event         传入LifecycleProvider<FragmentEvent>手动管理生命周期,避免内存溢出
     *                      备注:需要继承RxFragment,RxDialogFragment
     */
    public static Observable getObservable(Observable<HttpResponse> apiObservable, LifecycleProvider<FragmentEvent> lifecycle, FragmentEvent event) {
        Observable observable;
        if (lifecycle != null) {
            //手动管理移除监听生命周期.eg:FragmentEvent.STOP
            observable = apiObservable
                    .map(new ServerResultFunction())
                    .compose(lifecycle.bindUntilEvent(event))//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }
}
