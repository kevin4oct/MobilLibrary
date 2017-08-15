package com.hebth.mobilelibrary.ui.readerinfo.net;

import com.google.gson.Gson;
import com.hebth.mobilelibrary.beans.UserBean;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hebth on 2017-07-26.
 * 读者信息的解析接口
 */

public class UserInfoParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public List<UserBean> parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result, resultType);
    }
}
