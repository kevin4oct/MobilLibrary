package com.hebth.mobilelibrary.ui.borrowing.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-27.
 * 正在借阅的网络参数
 */
@HttpRequest(host = AppConstant.HOST,path=AppConstant.CURRENTBORROW)
public class BorrowingRequestParams extends RequestParams {

    public String username;
}
