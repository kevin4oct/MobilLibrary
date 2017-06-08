package com.hebth.mobilelibrary.ui.base;

import android.content.Context;

/**
 * Created by hebth on 2017-06-08.
 * presenter的基类
 */

public abstract class BasePresenter<M, V> {
    public Context mContext;
    public M mModel;
    public V mView;

    public void setVM(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }


}
