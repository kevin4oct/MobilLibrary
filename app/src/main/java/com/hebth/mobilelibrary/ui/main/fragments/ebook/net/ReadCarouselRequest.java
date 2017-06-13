package com.hebth.mobilelibrary.ui.main.fragments.ebook.net;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-06-12.
 * ReadFragment 的轮播图网络请求参数
 */
@HttpRequest(host = "http://101.201.116.210:7726",path = "imageManage/getImagePathForMobile/1902ce11663d4399856887e1d11918c0")
public class ReadCarouselRequest extends RequestParams {
}
