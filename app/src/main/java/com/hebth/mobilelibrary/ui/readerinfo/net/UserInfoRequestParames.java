package com.hebth.mobilelibrary.ui.readerinfo.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-26.
 * 读者信息的网络请求参数
 */
@HttpRequest(host = AppConstant.HOST,path = AppConstant.USERINFO)
public class UserInfoRequestParames extends RequestParams {

    public String UserName;

}
