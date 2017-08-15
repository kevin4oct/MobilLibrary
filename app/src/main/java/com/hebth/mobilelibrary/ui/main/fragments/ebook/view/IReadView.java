package com.hebth.mobilelibrary.ui.main.fragments.ebook.view;

import com.hebth.mobilelibrary.ui.base.BaseView;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ReadRvAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ReadCarouselVpAdapter;

/**
 * Created by hebth on 2017-06-09.
 * ReadFragment的view接口
 */

public interface IReadView extends BaseView{

    String getPageNum();

    String getKeyWord();

    ReadCarouselVpAdapter getVpAdapter();

    ReadRvAdapter getRvAdapter();
}
