package com.hebth.mobilelibrary.ui.base;

/**
 * Created by hebth on 2017-06-08.
 */

public interface BaseView {

    void showLoading(String title);

    void stopLoading();

    void showErrorTip(String msg);

}
