package com.hebth.mobilelibrary.ui.main.fragments.ebook.net;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by hebth on 2017-06-09.
 * readFragment的网络参数
 * http://101.201.116.210:7726/bookTypeAndSearch/queryBookList?rankType=1&pageSize=12&pageNum=1&pageType=3&keyword=&classificationType=&classificationNumber=&classificationId=&bookType=L15_1&press=&upYearEndVal=&desc=0&upYearStartVal=&yearEnd=&yearStart=
 */
@HttpRequest(host = "http://101.201.116.210:7726",path = "bookTypeAndSearch/queryBookList")
public class ReadRequest extends RequestParams {
}
