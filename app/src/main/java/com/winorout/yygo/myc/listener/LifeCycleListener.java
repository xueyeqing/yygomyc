package com.winorout.yygo.myc.listener;

import android.os.Bundle;

/**
 * @Description: 生命周期监听
 * @Author: zyzhang
 * @Date: 17/12/17 上午11:25
 */
public interface LifeCycleListener {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
