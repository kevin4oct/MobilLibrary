package com.hebth.mobilelibrary.ui.recommend.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-25.
 * 新书推荐网络请求接口参数
 */
@HttpRequest(host = AppConstant.HOST, path = AppConstant.RECOMMEND_PATH)
public class RecommendRequestParams extends RequestParams {

    public String pageCount;

    public String page;
}
