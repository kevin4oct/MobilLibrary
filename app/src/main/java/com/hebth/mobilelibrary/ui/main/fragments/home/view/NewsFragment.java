package com.hebth.mobilelibrary.ui.main.fragments.home.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.NewsBean;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.main.fragments.home.adapter.NewsAdapter;

import java.util.ArrayList;

/**
 * Created by hebth on 2017-06-13.
 */

public class NewsFragment extends BaseFragment {

    private RecyclerView mRecycler;
    private NewsAdapter adapter;


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView() {
        mRecycler = (RecyclerView) mView.findViewById(R.id.recycler_news);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(layout);
        ArrayList<NewsBean> mList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            NewsBean e = new NewsBean();
            e.setTitle("这是第"+i+"条新闻");
            e.setTime("2017.06.0"+i);
            mList.add(e);
        }
        adapter = new NewsAdapter(getContext(), mList);
        mRecycler.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }


}
