package com.hebth.mobilelibrary.ui.history.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-27.
 * 历史借阅的网络参数
 */
@HttpRequest(host = AppConstant.HOST, path = AppConstant.HISTORY)
public class HistoryRequestParams extends RequestParams {

    public String username;

}
