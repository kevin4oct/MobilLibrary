package com.hebth.mobilelibrary.ui.main.fragments.ebook.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ReadCarouselVpAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ReadRvAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.presenter.ReadPresenter;
import com.hebth.mobilelibrary.utils.ToastUtils;

/**
 * Created by hebth on 2017-06-09.
 * read的fragment，展示电子资源的首页面内容，点击进入相应功能
 * <p>
 * 轮播图
 * http://101.201.116.210:7726/imageManage/getImagePathForMobile/1902ce11663d4399856887e1d11918c0
 * 书城（图书列表）---------------------------------
 * http://101.201.116.210:7726/bookTypeAndSearch/queryBookList?rankType=1&pageSize=12&pageNum=1&pageType=3&keyword=&classificationType=&classificationNumber=&classificationId=&bookType=L15_1&press=&upYearEndVal=&desc=0&upYearStartVal=&yearEnd=&yearStart=
 * 图书详情---------------------------------
 * http://101.201.116.210:7726/mobile/bookDetailById?bookId=fe0e12821e5a11e7bd1f00163e160aa8
 * 资源前缀---------------------------------
 * http://101.201.114.210/591/ebooks/    +   参数string
 */
public class ReadFragment extends BaseFragment implements IReadView, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    public static final String TAG = ReadFragment.class.getSimpleName();

    private SwipeRefreshLayout mSrl;
    //    private WrapContentHeightViewpager carousel_vp;
    private RecyclerView mRecycler;
    private ReadRvAdapter rvAdapter;
    private ReadCarouselVpAdapter vpAdapter;
    private ReadPresenter mPresenter = new ReadPresenter(this);
    //搜索区域
//    private EditText searchValue_et;
//    private Button searchBtn;
//    private Button unSearchBtn;

    private boolean isLoading = true;//是否可加载的标记
    private int pageNum = 1;//页数
    private GridLayoutManager layoutManager;

    public String keyWrods;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_read;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
//        searchBtn = (Button) mView.findViewById(R.id.btn_search_read);
//        unSearchBtn = (Button) mView.findViewById(R.id.btn_unsearch_read);
//        searchValue_et = (EditText) mView.findViewById(R.id.et_searchvalue_read);
        //下拉刷新
        mSrl = (SwipeRefreshLayout) mView.findViewById(R.id.srl_read);
        //轮播图
//        carousel_vp = (WrapContentHeightViewpager) mView.findViewById(R.id.vp_read);
        vpAdapter = new ReadCarouselVpAdapter(getContext(), null);
//        carousel_vp.setAdapter(vpAdapter);
        //列表
        mRecycler = ((RecyclerView) mView.findViewById(R.id.recycler_read));
        layoutManager = new GridLayoutManager(getContext(), 3);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);
        mRecycler.setLayoutManager(layoutManager);
        rvAdapter = new ReadRvAdapter(getContext(), mRecycler, null);
        mRecycler.setAdapter(rvAdapter);
        mRecycler.setNestedScrollingEnabled(true);
        mPresenter.refreshData();
    }

    @Override
    public void onResume() {
        super.onResume();
//        mHandler.sendEmptyMessageDelayed(NEXTIMAGE, CAROUSELDELAYTIME);
    }

    @Override
    public void onPause() {
        super.onPause();
//        mHandler.removeMessages(NEXTIMAGE);
    }

    @Override
    public void initListener() {
//        searchBtn.setOnClickListener(this);
//        unSearchBtn.setOnClickListener(this);
        mSrl.setOnRefreshListener(this);
        mRecycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int visible = layoutManager.getChildCount();
                int total = layoutManager.getItemCount();
                int past = layoutManager.findFirstCompletelyVisibleItemPosition();
                if (isLoading && newState == 0 && (visible + past) >= total) {
                    isLoading = false;
                    pageNum++;
                    mPresenter.loadData();
                }
            }
        });
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {
        mSrl.setRefreshing(false);
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
    public String getKeyWord() {
        return keyWrods;
    }

    @Override
    public ReadCarouselVpAdapter getVpAdapter() {
        return vpAdapter;
    }

    @Override
    public ReadRvAdapter getRvAdapter() {
        return rvAdapter;
    }

    @Override
    public void onRefresh() {
        pageNum = 1;
        mPresenter.refreshData();
    }


    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_search_read:
//                String searchValue = searchValue_et.getText().toString().trim();
//                if (!CommenUtils.isEmpty(searchValue)) {
//                    ToastUtils.showText(getContext(), "请输入检索内容..");
//                    return;
//                }
//                keyWrods = searchValue;
//                pageNum = 1;
//                mPresenter.refreshData();
//                break;
//
//            case R.id.btn_unsearch_read://退出检索
//                searchValue_et.setText("");
//                keyWrods = "";
//                pageNum = 1;
//                mPresenter.refreshData();
//                break;
//        }
    }
}
