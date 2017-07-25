package com.hebth.mobilelibrary.ui.opac.net;

import com.google.gson.Gson;
import com.hebth.mobilelibrary.beans.OPACBean;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hebth on 2017-07-25.
 * opac解析
 */

public class OPACParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public List<OPACBean> parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result, resultType);
    }
}
