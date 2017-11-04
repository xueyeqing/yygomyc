package com.winorout.yygo.myc.test;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.RxActivity;
import com.winorout.yygo.myc.http.Api.ApiUtils;
import com.winorout.yygo.myc.http.exception.ApiException;
import com.winorout.yygo.myc.http.observer.HttpRxObservable;
import com.winorout.yygo.myc.http.observer.HttpRxObserver;
import com.winorout.yygo.myc.http.retrofit.HttpRequest;
import com.winorout.yygo.myc.utils.LogUtils;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/4 上午10:29
 */
public class RetrofitTest {

    public final String TAG = RetrofitTest.class.getSimpleName();//每个网络请求唯一TAG，用于取消网络请求使用

    /**
     * 模拟在activity中调用
     *
     * @author ZhongDaFeng
     */
    public void test(RxActivity activity, String account, String psw) {
        //设置唯一TAG
        HttpRxObserver httpRxObserver = new HttpRxObserver(TAG + "login") {
            @Override
            protected void onStart(Disposable d) {
                /**
                 * 开启loading等
                 */
            }

            @Override
            protected void onError(ApiException e) {
                /**
                 * 错误信息
                 */
                LogUtils.w("onError code:" + e.getCode() + " msg:" + e.getMsg());
            }

            @Override
            protected void onSuccess(Object response) {
                /**
                 * 成功处理
                 */
                LogUtils.w("onSuccess response:" + response.toString());
            }
        };

        // 启动
        new RetrofitTest().login(activity, account, psw).subscribe(httpRxObserver);

    }

    /**
     * 登录demo
     *
     * @author ZhongDaFeng
     */
    public Observable login(RxActivity activity, String phone, String psw) {
        //构建请求数据
        Map<String, Object> request = HttpRequest.getRequest();
        request.put("phone", phone);
        request.put("psw", psw);
        /**
         * 获取请求Observable
         * 1.RxActivity,RxFragment...所在页面继承RxLifecycle支持的组件
         * 2.ActivityEvent指定监听函数解绑的生命周期（手动管理,未设置则自动管理）
         * 以上两点作用防止RxJava监听没解除导致内存泄漏,ActivityEvent若未指定则按照activity/fragment的生命周期
         */
        // return HttpRxObservable.getObservable(ApiUtils.getPhoneApi().phoneQuery(request), activity);
        return HttpRxObservable.getObservable(ApiUtils.getUserApi().login(request), activity, ActivityEvent.PAUSE);
    }

}
