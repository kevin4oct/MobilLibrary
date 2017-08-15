package com.hebth.mobilelibrary.ui.history;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.HistoryBean;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.history.net.HistoryRequestParams;
import com.hebth.mobilelibrary.utils.CommenUtils;
import com.hebth.mobilelibrary.utils.SharedPreferenceUtil;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends BaseActivity {

    @ViewInject(R.id.srl_history)
    private SwipeRefreshLayout mRefresh;
    @ViewInject(R.id.recycler_history)
    private RecyclerView mRecycler;

    private List<HistoryBean> mList;
    private HistoryAdapter adapter;
    private Callback.Cancelable post;

    public static Intent getHistoryIntent(Context context) {
        return new Intent(context, HistoryActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_history;
    }

    @Override
    public void initView() {
        mList = new ArrayList<>();
        //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_history);
        toolbar.setTitle("历史借阅");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        LinearLayoutManager layout = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layout);
        adapter = new HistoryAdapter();
        mRecycler.setAdapter(adapter);
        //
        showDialog("加载中..");
        getDateFormNet();
    }

    @Override
    public void initListener() {
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDateFormNet();
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
     * 从网路获取数据
     */
    public void getDateFormNet() {

        HistoryRequestParams params = new HistoryRequestParams();
        params.username = SharedPreferenceUtil.getUsername();
        post = x.http().post(params, new Callback.CommonCallback<List<HistoryBean>>() {
            @Override
            public void onSuccess(List<HistoryBean> result) {
                if (result != null) {
                    mList.clear();
                    mList.addAll(result);
                    adapter.notifyDataSetChanged();
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
                mRefresh.setRefreshing(false);
                hideDialog();
            }
        });
    }

    /**
     * 显示加载动画
     */
    public void showDialog(String str) {

    }

    /**
     * 隐藏加载动画
     */
    public void hideDialog() {
        post.cancel();
    }

    /**
     * HistoryActivity RecyclerView 的适配器
     */
    public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {

        private LayoutInflater inflater;

        public HistoryAdapter() {
            inflater = LayoutInflater.from(HistoryActivity.this);
        }

        @Override
        public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_rv_history, parent, false);
            return new HistoryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(HistoryViewHolder holder, int position) {
            HistoryBean bean = mList.get(position);
            if (bean != null) {
                String bookname = bean.getBookname();
                if (CommenUtils.isEmpty(bookname)) {
                    holder.bookName.setText(bookname);
                } else {
                    holder.bookName.setText("...");
                }
                String borrowtime = bean.getBorrowtime();
                if (CommenUtils.isEmpty(borrowtime)) {
                    holder.borrowTime.setText("借书时间：" + borrowtime);
                } else {
                    holder.borrowTime.setText("借书时间：...");
                }
                String actualtime = bean.getActualtime();
                if (CommenUtils.isEmpty(actualtime)) {
                    holder.actualTime.setText("还书日期：" + actualtime);
                } else {
                    holder.actualTime.setText("还书日期：...");
                }
            }

        }

        @Override
        public int getItemCount() {
            return mList != null ? mList.size() : 0;
        }
    }

    /**
     * HistoryActivity RecyclerView 的ViewHolder
     */
    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        public TextView bookName;
        public TextView borrowTime;
        public TextView actualTime;


        public HistoryViewHolder(View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.bookname_item_history);
            borrowTime = (TextView) itemView.findViewById(R.id.borrowtime_item_history);
            actualTime = (TextView) itemView.findViewById(R.id.actualtime_item_history);
        }
    }


}
