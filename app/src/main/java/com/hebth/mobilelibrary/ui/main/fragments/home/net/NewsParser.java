package com.hebth.mobilelibrary.ui.main.fragments.home.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hebth.mobilelibrary.beans.NewsBean;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hebth on 2017-07-24.
 * homeFragment本馆新闻的解析接口
 */

public class NewsParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public List<NewsBean> parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        Gson gson = new Gson();
        Type type = new TypeToken<List<NewsBean>>() {
        }.getType();
        return gson.fromJson(result, type);
    }
}
