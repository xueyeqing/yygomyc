package com.winorout.yygo.myc;

import android.os.Bundle;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.winorout.yygo.myc.base.BaseActivity;
import com.winorout.yygo.myc.model.bean.UserBean;
import com.winorout.yygo.myc.test.RetrofitTest;
import com.winorout.yygo.myc.view.iface.ILoginView;

public class MainActivity extends BaseActivity implements ILoginView, BottomNavigationBar.OnTabSelectedListener {

    //    RetrofitTest retrofitTest;
    private BottomNavigationBar mBottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        retrofitTest = new RetrofitTest();
//        retrofitTest.test(MainActivity.this, "user", "abc123456");

        init();
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected void init() {

        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_selected, getString(R.string.item_home)).setInactiveIconResource(R.mipmap.main_normal).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorBlack))
                .addItem(new BottomNavigationItem(R.mipmap.main_selected, getString(R.string.item_scan)).setInactiveIconResource(R.mipmap.main_normal).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorBlack))
                .addItem(new BottomNavigationItem(R.mipmap.profile_selected, getString(R.string.item_profile)).setInactiveIconResource(R.mipmap.profile_normal).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorBlack))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);

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

    /**
     * Tab的切换
     *
     * @param position
     */
    @Override
    public void onTabSelected(int position) {
        Toast.makeText(this, "position=" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
