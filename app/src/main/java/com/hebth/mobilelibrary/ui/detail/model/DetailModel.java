package com.hebth.mobilelibrary.ui.detail.model;

import android.util.Log;

import com.hebth.mobilelibrary.ui.detail.bean.BookDetailBean;
import com.hebth.mobilelibrary.ui.detail.net.DetailRequest;

import org.xutils.common.Callback;
import org.xutils.x;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的Model类
 */

public class DetailModel implements IDetailModel {
    public static final String TAG = DetailModel.class.getSimpleName();

    @Override
    public void loadData(String bookId, final OnDetailListener listener) {

        DetailRequest request = new DetailRequest();
        request.addQueryStringParameter("bookId", bookId);

        x.http().get(request, new Callback.CommonCallback<BookDetailBean>() {
            @Override
            public void onSuccess(BookDetailBean result) {
                if (result != null) {
                    listener.success(result);
                } else {
                    listener.failed("网络请求失败，请重试..");
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
