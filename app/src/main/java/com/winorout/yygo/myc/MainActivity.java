package com.winorout.yygo.myc;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.winorout.yygo.myc.base.BaseActivity;
import com.winorout.yygo.myc.model.bean.UserBean;
import com.winorout.yygo.myc.utils.LogUtils;
import com.winorout.yygo.myc.utils.SPUtils;
import com.winorout.yygo.myc.view.fragment.HomeFragment;
import com.winorout.yygo.myc.view.fragment.MyFragment;
import com.winorout.yygo.myc.view.iface.ILoginView;

/**
 * 主入口
 */
public class MainActivity extends BaseActivity implements ILoginView, BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar mBottomNavigationBar;

    private HomeFragment homeFragment;
    private MyFragment myFragment;

    private FragmentManager fragmentManager;

    private SPUtils spUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        retrofitTest = new RetrofitTest();
//        retrofitTest.test(MainActivity.this, "user", "abc123456");
        // 初始化数据

        initToolbar("每易充");
        init();

        if (BuildConfig.LOG_DEBUG) {
            Toast.makeText(this, "我是Debug模式", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "我是开发者模式", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar(String title) {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 置空title
        toolbar.setTitle("");

        TextView textView = (TextView) findViewById(R.id.toolbar_title);
        textView.setText(title);

        setSupportActionBar(toolbar);

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

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_selected, getString(R.string.item_home)).setInactiveIconResource(R.mipmap.main_normal).setActiveColorResource(R.color.colorRed_t).setInActiveColorResource(R.color.colorBlack))
                .addItem(new BottomNavigationItem(R.mipmap.main_selected, getString(R.string.item_scan)).setInactiveIconResource(R.mipmap.main_normal).setActiveColorResource(R.color.colorRed_t).setInActiveColorResource(R.color.colorBlack))
                .addItem(new BottomNavigationItem(R.mipmap.profile_selected, getString(R.string.item_profile)).setInactiveIconResource(R.mipmap.profile_normal).setActiveColorResource(R.color.colorRed_t).setInActiveColorResource(R.color.colorBlack))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);

        // fragment 相关代码
        fragmentManager = getSupportFragmentManager();
        setDefaultFragment();

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
    public void onTabSelected(int position) { //未选中 -> 选中
        setFragment(position);
    }

    @Override
    public void onTabUnselected(int position) { //选中 -> 未选中
    }

    @Override
    public void onTabReselected(int position) { //选中 -> 选中
    }


    /**
     * 默认fragment
     */
    private void setDefaultFragment() {
        spUtils.put(this, "buttomposition", 0);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        HomeFragment mhomeFragment = homeFragment.newInstance(getString(R.string.item_home));
        transaction.replace(R.id.sub_content, mhomeFragment).commit();
    }

    /**
     * 不同fragment之间的切换，未选中 -> 选中
     *
     * @param position
     */
    private void setFragment(int position) {
        //开启事务
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                spUtils.put(this, "buttompos", 0);
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance(getString(R.string.item_home));
                }
                transaction.replace(R.id.sub_content, homeFragment);
                initToolbar("每易充");
                break;
            case 1:
                // 点击扫一扫，底部按钮不变化
                Object pos = SPUtils.get(this, "buttompos", 0);
                mBottomNavigationBar.selectTab((Integer) pos);
                break;
            case 2:
                spUtils.put(this, "buttompos", 2);
                if (myFragment == null) {
                    myFragment = MyFragment.newInstance(getString(R.string.item_profile));
                }
                transaction.replace(R.id.sub_content, myFragment);
                initToolbar("我的");
                break;
        }
        transaction.commit();
    }
}
