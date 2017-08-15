package com.hebth.mobilelibrary.ui.borrowing.net;

import com.google.gson.Gson;
import com.hebth.mobilelibrary.beans.BorrowingBean;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hebth on 2017-07-27.
 * 正在借阅的解析接口
 */

public class BorrowingParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public List<BorrowingBean> parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result, resultType);
    }
}
