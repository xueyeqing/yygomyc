package com.winorout.yygo.myc.base;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/12/17 上午11:35
 */
public interface IBaseView {

    //显示loading
    void showLoading();

    //关闭loading
    void closeLoading();

    //显示吐司
    void showToast(String msg);
}
