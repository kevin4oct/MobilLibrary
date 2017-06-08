package com.hebth.mobilelibrary;

import android.app.Application;

import org.xutils.x;

/**
 * Created by hebth on 2017-06-07.
 * 全局的Application
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(true);
    }


}
