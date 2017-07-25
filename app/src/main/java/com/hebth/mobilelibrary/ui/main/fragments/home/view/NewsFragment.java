package com.hebth.mobilelibrary.ui.main.fragments.home.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.base.AppConstant;
import com.hebth.mobilelibrary.beans.NewsBean;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.main.fragments.home.adapter.NewsAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.home.net.NewsRequestParams;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

/**
 * Created by hebth on 2017-06-13.
 * 首页的本馆新闻
 */

public class NewsFragment extends BaseFragment {

    private static final int LOAD = 0x100;
    private static final int REFRESH = 0x101;
    private RecyclerView mRecycler;
    private NewsAdapter adapter;
    private SwipeRefreshLayout mFresh;

    private int page = 0;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView() {
        mRecycler = (RecyclerView) mView.findViewById(R.id.recycler_news);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(layout);
        adapter = new NewsAdapter(getContext(), mRecycler, null);
        mRecycler.setAdapter(adapter);
        mFresh = (SwipeRefreshLayout) mView.findViewById(R.id.srl_home_news);
        //从网络获取数据
        getDateFormNet(REFRESH);
    }

    @Override
    public void initListener() {
        mFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                getDateFormNet(REFRESH);
            }
        });
    }

    /**
     * 从网络获取数据
     */
    public void getDateFormNet(final int fun) {
        NewsRequestParams entity = new NewsRequestParams();
        entity.type = "" + 1;
        entity.pageCount = "" + AppConstant.pageCoount_news;
        entity.page = "" + page;

        x.http().post(entity, new Callback.CommonCallback<List<NewsBean>>() {

            @Override
            public void onSuccess(List<NewsBean> result) {
                switch (fun) {
                    case LOAD:
                        adapter.loadDate(result);
                        break;
                    case REFRESH:
                        adapter.refreshDate(result);
                        break;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.e(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                mFresh.setRefreshing(false);
            }
        });
    }

}
