package com.hebth.mobilelibrary.ui.main.fragments.ebook.presenter;

import android.util.Log;

import com.hebth.mobilelibrary.beans.ReadCarouselBean;
import com.hebth.mobilelibrary.beans.ReadFragmentBean;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.model.IReadModel;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.model.OnReadCarouselListener;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.model.OnReadContainerListener;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.model.Readmodel;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.view.IReadView;

/**
 * Created by hebth on 2017-06-09.
 * ReadFragment的主导器
 */
public class ReadPresenter {

    public static final String TAG = ReadPresenter.class.getSimpleName();

    private IReadModel mModel;

    private IReadView mView;

    public ReadPresenter(IReadView mView) {

        this.mModel = new Readmodel();

        this.mView = mView;
    }

    /**
     * 加载数据
     */
    public void loadData() {

        mView.showLoading("努力加载中..");

        mModel.getContainerData(mView.getPageNum(),mView.getKeyWord(), new OnReadContainerListener() {
            @Override
            public void success(ReadFragmentBean bean) {

                Log.e(TAG, "success: " + bean.toString());

                mView.stopLoading();
                //加载
                mView.getRvAdapter().loadData(bean.getData().getList());
            }

            @Override
            public void failed(String info) {

                mView.stopLoading();

                mView.showErrorTip("加载失败.请重试..");
            }
        });
    }

    /**
     * 刷新数据
     */
    public void refreshData() {

        mView.showLoading("正在刷新..");

        //加载ViewPager的内容
        mModel.getCarouselData(new OnReadCarouselListener() {
            @Override
            public void success(ReadCarouselBean bean) {

                mView.getVpAdapter().refreshData(bean);
            }

            @Override
            public void failed(String info) {

                mView.stopLoading();

                mView.showErrorTip("刷新失败，请重试");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                refreshData();

            }
        });

        //加载RecyclerView 的内容
        mModel.getContainerData("1",mView.getKeyWord(), new OnReadContainerListener() {

            @Override
            public void success(ReadFragmentBean bean) {

                mView.stopLoading();
                //刷新
                mView.getRvAdapter().refreshData(bean.getData().getList());

            }

            @Override
            public void failed(String info) {

                mView.stopLoading();

                mView.showErrorTip("刷新失败，请重试");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshData();
            }
        });
    }
}
