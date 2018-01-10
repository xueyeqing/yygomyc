package com.winorout.yygo.myc;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

import com.winorout.yygo.myc.bdlocation.LocationService;

/**
 * @Description: 入口
 * @Author: zyzhang
 * @Date: 17/12/21 下午4:15
 */
public class MyApplication extends Application {

    private static MyApplication instance;
    public LocationService locationService;
    public Vibrator mVibrator;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        mVibrator = (Vibrator) getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
//        SDKInitializer.initialize(getApplicationContext());
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
