package com.hebth.mobilelibrary.ui.main.fragments.ebook.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.ReadCarouselBean;
import com.hebth.mobilelibrary.beans.ReadFragmentBean;
import com.hebth.mobilelibrary.myview.FullyGridLayoutManager;
import com.hebth.mobilelibrary.myview.MyProgressDialog;
import com.hebth.mobilelibrary.myview.WrapContentHeightViewpager;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ReadRvAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ReadVpAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.presenter.ReadPresenter;
import com.hebth.mobilelibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-09.
 * read的fragment，展示电子资源的首页面内容，点击进入相应功能
 */
public class ReadFragment extends BaseFragment implements IReadView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSrl;
    private WrapContentHeightViewpager carousel_vp;
    private RecyclerView mRecycler;
    private ReadRvAdapter rvAdapter;
    private ReadVpAdapter vpAdapter;
    private ReadPresenter mPresenter = new ReadPresenter(this);
    private MyProgressDialog dialog;

    private boolean isLoading = true;//是否可加载的标记
    private int pageNum = 1;//页数
    private FullyGridLayoutManager layoutManager;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_read;
    }

    @Override
    public void initView() {

        //下拉刷新
        mSrl = (SwipeRefreshLayout) mView.findViewById(R.id.srl_read);

        //轮播图
        carousel_vp = (WrapContentHeightViewpager) mView.findViewById(R.id.vp_read);
        List<ReadCarouselBean.DataBean> list = new ArrayList();
        vpAdapter = new ReadVpAdapter(getContext(), list);
        carousel_vp.setAdapter(vpAdapter);

        //列表
        mRecycler = ((RecyclerView) mView.findViewById(R.id.recycler_read));
        layoutManager = new FullyGridLayoutManager(getContext(), 3);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);
        mRecycler.setLayoutManager(layoutManager);
        rvAdapter = new ReadRvAdapter(getContext(), mRecycler, new ArrayList<ReadFragmentBean.DataBean.ListBean>());
        mRecycler.setAdapter(rvAdapter);
        mRecycler.setNestedScrollingEnabled(true);
        mPresenter.refreshData();

    }

    @Override
    public void initListener() {
        mSrl.setOnRefreshListener(this);
        mRecycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int scrollStateIdle = RecyclerView.SCROLL_STATE_IDLE;
                int visible = layoutManager.getChildCount();
                int total = layoutManager.getItemCount();
                int past = layoutManager.findFirstCompletelyVisibleItemPosition();
                Log.e(TAG, "isLoading-->" + isLoading + ",newState-->" + newState + ",visible-->" + visible + ",past-->" + past + ",total-->" + total);
                if (isLoading && newState == 0 && (visible + past) >= total) {
                    isLoading = false;
                    pageNum++;
                    Log.e(TAG, "加载页面：pageNum-->>>" + pageNum);
                    mPresenter.loadData();
                }
            }
        });
    }

    @Override
    public void showLoading(String title) {
        dialog = MyProgressDialog.show(getContext(), title, false, null);
    }

    @Override
    public void stopLoading() {
        mSrl.setRefreshing(false);
        if (dialog != null) {
            dialog.dismiss();
        }
        isLoading = true;
    }

    @Override
    public void showErrorTip(String msg) {
        ToastUtils.showText(getContext(), msg);
    }

    @Override
    public String getPageNum() {
        return String.valueOf(pageNum);
    }

    @Override
    public ReadVpAdapter getVpAdapter() {
        return vpAdapter;
    }

    @Override
    public ReadRvAdapter getRvAdapter() {
        return rvAdapter;
    }

    @Override
    public void onRefresh() {
        pageNum = 1;
        Log.e(TAG, "pageNum: " + pageNum);
        mPresenter.refreshData();
    }

}
