package com.hebth.mobilelibrary.ui.main.fragments.ebook.net;

import com.google.gson.Gson;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * Created by hebth on 2017-06-12.
 * read界面的轮播图解析器
 */

public class ReadCarouselParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {
    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result, resultClass);
    }
}
