package com.hebth.mobilelibrary.ui.main.fragments.ebook.model;

import com.hebth.mobilelibrary.beans.ReadCarouselBean;

/**
 * Created by hebth on 2017-06-09.
 * ReadFragment 的回调接口
 */

public interface OnReadCarouselListener {

    void success(ReadCarouselBean bean);

    void failed(String info);
}
