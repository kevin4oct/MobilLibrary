package com.hebth.mobilelibrary.ui.opac.view.activity;

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
import com.hebth.mobilelibrary.net.BookRequestParams;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class OPACListActivity extends BaseActivity {

    public static final int REFRESH = 0x123;
    public static final int LOAD = 0x124;

    @ViewInject(R.id.srl_opaclist)
    private SwipeRefreshLayout mRefresh;
    @ViewInject(R.id.recycler_opaclist)
    private RecyclerView mRecycler;
    @ViewInject(R.id.loadhint_opaclist)
    private LinearLayout loadHint_ll;

    private String category, categoryValue;
    private int pageCount = 20;//每页显示的条数
    private int page = 0;//当前的页数
    private boolean isLoad = true;//是否可以加载的标记

    private List<BookBean> mList;
    private OPACRecyclerAdapter adapter;
    private LinearLayoutManager layoutManager;

    public static Intent getOPACListIntent(Context context, String category, String categoryValue) {
        Intent intent = new Intent(context, OPACListActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("categoryValue", categoryValue);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_opaclist;
    }

    @Override
    public void initView() {
        this.category = getIntent().getStringExtra("category");
        this.categoryValue = getIntent().getStringExtra("categoryValue");
        //
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_opaclist);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("检索 \"" + categoryValue + "\" 的结果");
        mToolBar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        mList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        adapter = new OPACRecyclerAdapter();
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
        BookRequestParams bookRequestParams = new BookRequestParams();
        bookRequestParams.category = this.category;
        bookRequestParams.cateValue = this.categoryValue;
        Logger.e("检索类别：" + bookRequestParams.category + "检索内容：" + bookRequestParams.cateValue);
        bookRequestParams.author = "";
        bookRequestParams.publisher = "";
        bookRequestParams.pageCount = "" + pageCount;
        bookRequestParams.page = "" + page;

        x.http().post(bookRequestParams, new Callback.CommonCallback<List<BookBean>>() {

            @Override
            public void onSuccess(List<BookBean> result) {
                if (result == null || result.size() == 0) {
                    ToastUtils.showText(OPACListActivity.this, "未查询到结果..");
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
                ToastUtils.showText(OPACListActivity.this, "未查询到结果..");
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
    private class OPACRecyclerAdapter extends RecyclerView.Adapter<OPACRecyclerViewholder> {

        private LayoutInflater inflater = LayoutInflater.from(OPACListActivity.this);

        @Override
        public OPACRecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_recycler_opaclist, parent, false);
            OPACRecyclerViewholder viewholder = new OPACRecyclerViewholder(view);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(OPACRecyclerViewholder holder, int position) {
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
    private class OPACRecyclerViewholder extends RecyclerView.ViewHolder {

        public TextView bookname;
        public TextView author;
        public TextView publish;
        public TextView chinesesort;

        public OPACRecyclerViewholder(View itemView) {
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
