package com.hebth.mobilelibrary.ui.detail.model;

/**
 * Created by hebth on 2017-06-16.
 * 获取电子书阅读进度的回调接口
 */

public interface OnRecordListener {

    void success(String bookRecord);

    void failed(String info);
}
