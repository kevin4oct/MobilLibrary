package com.hebth.mobilelibrary.ui.main.fragments.ebook.model;

import com.hebth.mobilelibrary.ui.base.BaseModel;

/**
 * Created by hebth on 2017-06-09.
 * ReadFragment的model接口
 */

public interface IReadModel extends BaseModel{

    void getCarouselData(OnReadCarouselListener listener);

    void getContainerData(String pageNum, OnReadContainerListener listener);
}
