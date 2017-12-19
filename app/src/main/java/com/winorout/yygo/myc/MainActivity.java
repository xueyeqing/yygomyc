package com.winorout.yygo.myc;

import android.os.Bundle;

import com.winorout.yygo.myc.base.BaseActivity;
import com.winorout.yygo.myc.model.bean.UserBean;
import com.winorout.yygo.myc.test.RetrofitTest;
import com.winorout.yygo.myc.view.iface.ILoginView;

public class MainActivity extends BaseActivity implements ILoginView {

    RetrofitTest retrofitTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitTest = new RetrofitTest();
        retrofitTest.test(MainActivity.this, "admin", "anhui11chuxing");
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initBundleData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showResult(UserBean bean) {

    }
}
