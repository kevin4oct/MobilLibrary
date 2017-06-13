package com.hebth.mobilelibrary.ui.main.fragments.ebook.model;

import android.util.Log;

import com.hebth.mobilelibrary.beans.ReadCarouselBean;
import com.hebth.mobilelibrary.beans.ReadFragmentBean;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.net.ReadCarouselRequest;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.net.ReadRequest;

import org.xutils.common.Callback;
import org.xutils.x;

/**
 * Created by hebth on 2017-06-09.
 * ReadFragment的Model类，用于网络请求
 */

public class Readmodel implements IReadModel {

    public static final String TAG = Readmodel.class.getSimpleName();

    /**
     * 获取轮播图的图片URL
     *
     * @param listener
     */
    @Override
    public void getCarouselData(final OnReadCarouselListener listener) {
        ReadCarouselRequest request = new ReadCarouselRequest();

        x.http().get(request, new Callback.CommonCallback<ReadCarouselBean>() {
            @Override
            public void onSuccess(ReadCarouselBean result) {
                if (result != null) {
                    listener.success(result);
                } else {
                    listener.failed("网络异常，请重新加载..");
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 获取RecyclerView的内容
     *
     * @param pageNum
     * @param listener
     */
    @Override
    public void getContainerData(String pageNum, final OnReadContainerListener listener) {

        ReadRequest request = new ReadRequest();
        request.addQueryStringParameter("rankType", "1");
        request.addQueryStringParameter("pageSize", "15");
        request.addQueryStringParameter("pageNum", pageNum);
        request.addQueryStringParameter("pageType", "3");
        request.addQueryStringParameter("keyword", "");
        request.addQueryStringParameter("classificationType", "");
        request.addQueryStringParameter("classificationNumber", "");
        request.addQueryStringParameter("classificationId", "");
        request.addQueryStringParameter("bookType", "L15_1");
        request.addQueryStringParameter("press", "");
        request.addQueryStringParameter("upYearEndVal", "");
        request.addQueryStringParameter("desc", "0");
        request.addQueryStringParameter("upYearStartVal", "");
        request.addQueryStringParameter("yearEnd", "");
        request.addQueryStringParameter("yearStart", "");

        x.http().get(request, new Callback.CommonCallback<ReadFragmentBean>() {
            @Override
            public void onSuccess(ReadFragmentBean result) {
                if (result != null) {
                    listener.success(result);
                } else {
                    listener.failed("服务器无响应..");
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
