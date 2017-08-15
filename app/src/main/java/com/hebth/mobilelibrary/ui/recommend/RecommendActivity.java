package com.hebth.mobilelibrary.ui.recommend;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.BookBean;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.recommend.net.RecommendRequestParams;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class RecommendActivity extends BaseActivity {

    public static final int REFRESH = 0x234;
    public static final int LOAD = 0x235;

    @ViewInject(R.id.srl_recommend)
    private SwipeRefreshLayout mRefresh;
    @ViewInject(R.id.recycler_recommend)
    private RecyclerView mRecycler;
    @ViewInject(R.id.loadhint_recommend)
    private LinearLayout loadHint_ll;

    private int pageCount = 20;//每次加载的条目数
    private int page = 0;//当前页数
    private boolean isLoad = true;

    private List<BookBean> mList;
    private RecommendRecyclerAdapter adapter;
    private LinearLayoutManager layoutManager;

    public static Intent getRecommendIntent(Context context) {
        Intent intent = new Intent(context, RecommendActivity.class);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_recommend;
    }

    @Override
    public void initView() {
        //
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_recommend);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("新书推荐");
        mToolBar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        mList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        adapter = new RecommendRecyclerAdapter();
        mRecycler.setAdapter(adapter);

        getDateFormNet(LOAD);
    }

    @Override
    public void initListener() {
        //刷新的监听
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                getDateFormNet(REFRESH);
            }
        });
        //recyclerView滑动监听
        mRecycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int visible = layoutManager.getChildCount();
                int total = layoutManager.getItemCount();
                int past = layoutManager.findFirstCompletelyVisibleItemPosition();
                if (isLoad && newState == 0 && (visible + past) >= total) {
                    page++;
                    Log.e(TAG, "加载页面：page-->>>" + page);
                    getDateFormNet(LOAD);
                }
            }
        });
    }

    /**
     * 从网络获取数据
     */
    private void getDateFormNet(final int type) {

        isLoad = false;
        setLoadHintShowAndHide();
        RecommendRequestParams recommendRequestParams = new RecommendRequestParams();

        recommendRequestParams.pageCount = "" + pageCount;
        recommendRequestParams.page = "" + page;

        x.http().post(recommendRequestParams, new Callback.CommonCallback<List<BookBean>>() {

            @Override
            public void onSuccess(List<BookBean> result) {
                if (result == null || result.size() == 0) {
                    ToastUtils.showText(RecommendActivity.this, "已无更多结果..");
                } else {
                    switch (type) {
                        case LOAD://上拉加载

                            break;
                        case REFRESH://下拉刷新
                            mList.clear();
                            break;
                    }
                    mList.addAll(result);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.e(ex.getMessage());
                ToastUtils.showText(RecommendActivity.this, "未查询到结果..");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                isLoad = true;
                mRefresh.setRefreshing(false);
                setLoadHintShowAndHide();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * recyclerview的适配器
     */
    private class RecommendRecyclerAdapter extends RecyclerView.Adapter<RecommendActivity.RecommendRecyclerViewholder> {

        private LayoutInflater inflater = LayoutInflater.from(RecommendActivity.this);

        @Override
        public RecommendActivity.RecommendRecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_recycler_opaclist, parent, false);
            RecommendRecyclerViewholder viewholder = new RecommendRecyclerViewholder(view);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(RecommendActivity.RecommendRecyclerViewholder holder, int position) {
            BookBean bookBean = mList.get(position);
            if (bookBean != null) {
                //书名
                String bookName = bookBean.getBookName();
                if (bookName == null || "".equals(bookName)) {
                    holder.bookname.setText("...");
                } else {
                    holder.bookname.setText(bookName);
                }

                //作者
                String firstAuthor = bookBean.getFirstAuthor();
                if (firstAuthor == null || "".equals(firstAuthor)) {
                    holder.author.setText("...");
                } else {
                    holder.author.setText("作者：" + firstAuthor);
                }

                //出版社
                String publishName = bookBean.getPublishName();
                if (publishName == null || "".equals(publishName)) {
                    holder.publish.setText("...");
                } else {
                    holder.publish.setText("出版社：" + publishName);
                }

                //索书号
                String chineseSort = bookBean.getChineseSort();
                if (chineseSort == null || "".equals(chineseSort)) {
                    holder.chinesesort.setText("...");
                } else {
                    holder.chinesesort.setText("索书号：" + chineseSort);
                }
            }
        }

        @Override
        public int getItemCount() {
            return mList != null ? mList.size() : 0;
        }
    }

    /**
     * opac recyclerview 的viewholder
     */
    private class RecommendRecyclerViewholder extends RecyclerView.ViewHolder {

        public TextView bookname;
        public TextView author;
        public TextView publish;
        public TextView chinesesort;

        public RecommendRecyclerViewholder(View itemView) {
            super(itemView);
            bookname = (TextView) itemView.findViewById(R.id.bookname_item_booklist);
            author = (TextView) itemView.findViewById(R.id.author_item_booklist);
            publish = (TextView) itemView.findViewById(R.id.publish_item_booklist);
            chinesesort = (TextView) itemView.findViewById(R.id.chinesesort_item_booklist);
        }
    }

    /**
     * 设置加载提示的显示和隐藏
     */
    private void setLoadHintShowAndHide() {
        if (loadHint_ll.getVisibility() == View.GONE) {
            loadHint_ll.setVisibility(View.VISIBLE);
        } else {
            loadHint_ll.setVisibility(View.GONE);
        }

    }
}
