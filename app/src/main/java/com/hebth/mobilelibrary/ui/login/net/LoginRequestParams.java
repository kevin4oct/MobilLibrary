package com.hebth.mobilelibrary.ui.login.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-27.
 * 登录界面的网络参数
 */
@HttpRequest(host = AppConstant.HOST, path = AppConstant.LOGIN)
public class LoginRequestParams extends RequestParams {

    public String cardNum;

    public String password;
}
