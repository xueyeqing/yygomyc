package com.winorout.yygo.myc.utils;

import android.util.Log;

import com.winorout.yygo.myc.BuildConfig;

/**
 * @Description: Log工具类
 * @Author: zyzhang
 * @Date: 17/11/3 下午5:37
 */
public class LogUtils {

    /**
     * 是否开发模式
     */
    private static final boolean isDebug = BuildConfig.LOG_DEBUG;

    private static final String TAG = "每易充-myc";

    private LogUtils() {
    }

    public static void d(String content) {
        if (!isDebug)
            return;
        Log.d(TAG, content);
    }

    public static void e(String content) {
        if (!isDebug)
            return;
        Log.e(TAG, content);
    }

    public static void i(String content) {
        if (!isDebug)
            return;
        Log.i(TAG, content);
    }

    public static void v(String content) {
        if (!isDebug)
            return;
        Log.v(TAG, content);
    }

    public static void w(String content) {
        if (!isDebug)
            return;
        Log.w(TAG, content);
    }
}
