package com.hebth.mobilelibrary.ui.borrowing.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-27.
 * 续借的网络参数
 */
@HttpRequest(host = AppConstant.HOST, path = AppConstant.REBORROW)
public class ReBorrowRequestParams extends RequestParams {
    public String BarCode;
}
