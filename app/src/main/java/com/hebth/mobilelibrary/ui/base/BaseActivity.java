package com.hebth.mobilelibrary.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

/**
 * Created by hebth on 2017-06-08.
 * Activity的基础类，抽象一些共有的方法，提取共有的变量
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        beforeSetContentView();

        setContentView(getLayoutRes());

        x.view().inject(this);

        initView();

        initListener();
    }

    public void beforeSetContentView() {
    }

    public abstract int getLayoutRes();

    public abstract void initView();

    public abstract void initListener();


}
