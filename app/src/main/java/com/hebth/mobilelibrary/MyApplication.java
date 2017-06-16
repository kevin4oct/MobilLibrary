package com.hebth.mobilelibrary;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by hebth on 2017-06-07.
 * 全局的Application
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }

    public static Context getContext() {
        return context;
    }
}
