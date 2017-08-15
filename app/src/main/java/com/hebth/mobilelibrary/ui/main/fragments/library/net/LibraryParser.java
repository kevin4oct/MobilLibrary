package com.hebth.mobilelibrary.ui.main.fragments.library.net;

import com.google.gson.Gson;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * Created by hebth on 2017-07-26.
 * 图书馆指南的解析接口
 */

public class LibraryParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result, resultClass);
    }
}
