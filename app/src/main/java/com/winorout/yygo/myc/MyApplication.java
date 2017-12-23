package com.winorout.yygo.myc;

import android.app.Application;

/**
 * @Description: 入口
 * @Author: zyzhang
 * @Date: 17/12/21 下午4:15
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 获取全局Context对象
     *
     * @return
     */
    public static MyApplication getInstance() {
        return instance;
    }
}
