package com.hebth.mobilelibrary.ui.detail.model;

import com.hebth.mobilelibrary.ui.base.BaseModel;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的Model接口
 */

public interface IDetailModel extends BaseModel {

    void loadData(String bookId, OnDetailListener listener);

}
