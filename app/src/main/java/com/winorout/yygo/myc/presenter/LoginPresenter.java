package com.winorout.yygo.myc.presenter;

import com.winorout.yygo.myc.base.BasePresenter;
import com.winorout.yygo.myc.http.Api.ApiUtils;
import com.winorout.yygo.myc.http.exception.ApiException;
import com.winorout.yygo.myc.http.observer.HttpRxObservable;
import com.winorout.yygo.myc.http.observer.HttpRxObserver;
import com.winorout.yygo.myc.http.retrofit.HttpRequest;
import com.winorout.yygo.myc.utils.LogUtils;
import com.winorout.yygo.myc.view.activity.LoginActivity;
import com.winorout.yygo.myc.view.iface.ILoginView;

import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:53
 */
public class LoginPresenter extends BasePresenter<ILoginView, LoginActivity> {

    public LoginPresenter(ILoginView view, LoginActivity activity) {
        super(view, activity);
    }

    public void login(String name, String password) {

        //构建请求数据
        Map<String, Object> request = HttpRequest.getRequest();
        request.put("name", name);
        request.put("password", password);

        HttpRxObserver httpRxObserver = new HttpRxObserver() {
            @Override
            protected void onStart(Disposable d) {
                LogUtils.d("onstart");
            }

            @Override
            protected void onError(ApiException e) {
                LogUtils.d("onError" + e);
            }

            @Override
            protected void onSuccess(Object response) {
                LogUtils.d("onsuccess" + response);
            }
        };

        /**
         * 切入后台移除RxJava监听
         * ActivityEvent.PAUSE(FragmentEvent.PAUSE)
         * 手动管理移除RxJava监听,如果不设置此参数默认自动管理移除RxJava监听（onCrete创建,onDestroy移除）
         */
        HttpRxObservable.getObservable(ApiUtils.getUserApi().login(request)).subscribe(httpRxObserver);
    }
}
