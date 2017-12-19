package com.winorout.yygo.myc.view.iface;

import com.winorout.yygo.myc.base.IBaseView;
import com.winorout.yygo.myc.model.bean.UserBean;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:54
 */
public interface ILoginView extends IBaseView {

    //显示结果
    void showResult(UserBean bean);
}
