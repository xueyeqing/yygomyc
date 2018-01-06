package com.winorout.yygo.myc.base;

import android.os.Bundle;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @Description: 所有的Activity都继承自此AppCompatActivity
 * @Author: zyzhang
 * @Date: 17/11/4 上午11:08
 * 1.规范团队开发
 * 2.统一处理AppCompatActivity所需配置,初始化
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 获取显示view的xml文件ID
     */
    protected abstract int getContentViewId();

    /**
     * 初始化应用程序，设置一些初始化数据,获取数据等操作
     */
    protected abstract void init();

    /**
     * 获取上一个界面传送过来的数据
     */
    protected abstract void initBundleData();

}
