package com.hebth.mobilelibrary.ui.opac.net;

import com.hebth.mobilelibrary.base.AppConstant;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-07-25.
 * opac网络请求接口参数
 */
@HttpRequest(host = AppConstant.HOST, path = AppConstant.OPAC_PATH)
public class OPACRequestParams extends RequestParams {

    public String category;

    public String cateValue;

    public String author;

    public String publisher;

    public String pageCount;

    public String page;
}
