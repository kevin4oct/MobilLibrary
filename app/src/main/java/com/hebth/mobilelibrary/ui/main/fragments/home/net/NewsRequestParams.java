package com.hebth.mobilelibrary.ui.main.fragments.home.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-24.
 * 本馆新闻的网络参数
 */
@HttpRequest(host = AppConstant.HOST,path = AppConstant.NEWS_PATH)
public class NewsRequestParams extends RequestParams {

    public String type;
    public String pageCount;
    public String page;

}
