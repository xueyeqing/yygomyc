package com.winorout.yygo.myc.base;

import android.os.Bundle;

import com.winorout.yygo.myc.listener.LifeCycleListener;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:44
 */
public class BasePresenter<V, T> implements LifeCycleListener {

    protected Reference<V> mViewRef;
    protected V mView;
    protected Reference<T> mActivityRef;
    protected T mActivity;


    public BasePresenter(V view, T activity) {
//        attachView(view);
//        attachActivity(activity);
//        setListener(activity);
    }

    /**
     * 关联
     *
     * @param view
     */
    private void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
        mView = mViewRef.get();
    }

    /**
     * 关联
     *
     * @param activity
     */
    private void attachActivity(T activity) {
        mActivityRef = new WeakReference<T>(activity);
        mActivity = mActivityRef.get();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
