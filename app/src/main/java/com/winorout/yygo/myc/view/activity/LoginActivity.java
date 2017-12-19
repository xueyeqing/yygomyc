package com.winorout.yygo.myc.view.activity;

import android.os.Bundle;

import com.winorout.yygo.myc.base.BaseActivity;
import com.winorout.yygo.myc.model.bean.UserBean;
import com.winorout.yygo.myc.presenter.LoginPresenter;
import com.winorout.yygo.myc.view.iface.ILoginView;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:53
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    private LoginPresenter mLoginPresenter = new LoginPresenter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLoginPresenter.login("admin", "1234567");
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
