package com.winorout.yygo.myc;

import android.os.Bundle;

import com.winorout.yygo.myc.base.BaseActivity;
import com.winorout.yygo.myc.test.RetrofitTest;

public class MainActivity extends BaseActivity {

    RetrofitTest retrofitTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitTest = new RetrofitTest();
        retrofitTest.test(MainActivity.this, "zyzhang", "123456");
    }
}
