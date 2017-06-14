package com.hebth.mobilelibrary.ui.detail.net;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的网络参数
 */
@HttpRequest(host = "http://101.201.116.210:7726",path = "mobile/bookDetailById")
public class DetailRequest extends RequestParams {
}
