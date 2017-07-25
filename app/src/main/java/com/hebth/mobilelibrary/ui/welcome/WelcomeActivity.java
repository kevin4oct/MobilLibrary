package com.hebth.mobilelibrary.ui.welcome;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;


public class WelcomeActivity extends BaseActivity {


    public static final String[] WRITE_EXTERNAL_STORAGE_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    public int getLayoutRes() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }


}
