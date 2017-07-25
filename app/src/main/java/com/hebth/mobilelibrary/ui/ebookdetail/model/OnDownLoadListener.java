package com.hebth.mobilelibrary.ui.ebookdetail.model;

/**
 * Created by hebth on 2017-06-15.
 * 电子书下载的回调接口
 */

public interface OnDownLoadListener {

    void success(long taskId,String filePath);

    void failed(String info);
}
