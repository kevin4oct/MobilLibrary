package com.hebth.mobilelibrary.ui.ebookdetail.model;

import com.hebth.mobilelibrary.ui.ebookdetail.bean.BookDetailBean;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的回调接口
 */

public interface OnDetailListener {

    void success(BookDetailBean bean);

    void failed(String info);

}
