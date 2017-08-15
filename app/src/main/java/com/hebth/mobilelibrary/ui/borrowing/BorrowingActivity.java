package com.hebth.mobilelibrary.ui.borrowing;

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
import android.widget.Button;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.BorrowingBean;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.borrowing.net.BorrowingRequestParams;
import com.hebth.mobilelibrary.ui.borrowing.net.ReBorrowRequestParams;
import com.hebth.mobilelibrary.utils.CommenUtils;
import com.hebth.mobilelibrary.utils.SharedPreferenceUtil;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 正在借阅
 * 展示读者目前借阅的图书列表，点击按钮续借功能，下拉刷新
 */
public class BorrowingActivity extends BaseActivity {

    @ViewInject(R.id.srl_borrowing)
    private SwipeRefreshLayout mRefresh;
    @ViewInject(R.id.recycler_borrowing)
    private RecyclerView mRecycler;
    //
    private List<BorrowingBean> mList;
    private BorrowingAdapter adapter;
    //
    private Callback.Cancelable reBorrow_post;
    private Callback.Cancelable getDate_post;

    public static Intent getBorrowingIntent(Context context) {
        return new Intent(context, BorrowingActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_borrowing;
    }

    @Override
    public void initView() {
        mList = new ArrayList<>();
        //设置toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_borrowing);
        toolbar.setTitle("正在借阅");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(toolbar);
        //
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        adapter = new BorrowingAdapter();
        mRecycler.setAdapter(adapter);
        //
//        showDialog("加载中..");
        getDateFormNet();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    /**
     * 从网络获取数据
     */
    public void getDateFormNet() {
        BorrowingRequestParams params = new BorrowingRequestParams();
        params.username = SharedPreferenceUtil.getUsername();
        getDate_post = x.http().post(params, new Callback.CommonCallback<List<BorrowingBean>>() {
            @Override
            public void onSuccess(List<BorrowingBean> result) {
                mList.clear();
                mList.addAll(result);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.e(ex.getMessage());
                ToastUtils.showText(BorrowingActivity.this, getResources().getString(R.string.net_error));
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Logger.e(cex.getMessage());
            }

            @Override
            public void onFinished() {
                mRefresh.setRefreshing(false);
                hideDialog();
            }
        });
    }

    /**
     * 续借
     *
     * @param barCode
     */
    private void reBorrow(String barCode) {
        ReBorrowRequestParams params = new ReBorrowRequestParams();
        params.BarCode = barCode;
        reBorrow_post = x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (CommenUtils.isEmpty(result)) {
                    ToastUtils.showText(BorrowingActivity.this, result.substring(2, result.length() - 2));
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.e(ex.getMessage());
                ToastUtils.showText(BorrowingActivity.this, getResources().getString(R.string.net_error));
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
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

    }

    /**
     * RecyclerView 的Adapter
     */
    private class BorrowingAdapter extends RecyclerView.Adapter<BorrowingViewHolder> {

        private LayoutInflater inflater;

        public BorrowingAdapter() {
            inflater = LayoutInflater.from(BorrowingActivity.this);
        }

        @Override
        public BorrowingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_recycler_borrowing, parent, false);

            return new BorrowingViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BorrowingViewHolder holder, int position) {

            final BorrowingBean bean = mList.get(position);
            if (bean != null) {
                //书名
                String bookName = bean.getBookName();
                if (CommenUtils.isEmpty(bookName)) {
                    holder.bookName.setText(bookName);
                } else {
                    holder.bookName.setText("...");
                }
                //借书时间
                String borrowTime = bean.getBorrowTime();
                if (CommenUtils.isEmpty(borrowTime)) {
                    holder.borrowTime.setText("借阅日期：" + borrowTime);
                } else {
                    holder.borrowTime.setText("...");
                }
                //应还时间
                String giveBackTime = bean.getGiveBackTime();
                if (CommenUtils.isEmpty(giveBackTime)) {
                    holder.giveBackTime.setText("应还日期：" + giveBackTime);
                } else {
                    holder.giveBackTime.setText("...");
                }

                holder.reborrowBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String barCode = bean.getBarCode();
                        reBorrow(barCode);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return mList != null ? mList.size() : 0;
        }
    }

    /**
     * RecyclerView 的ViewHolder
     */
    private class BorrowingViewHolder extends RecyclerView.ViewHolder {

        public TextView bookName;
        public TextView borrowTime;
        public TextView giveBackTime;
        public Button reborrowBtn;

        public BorrowingViewHolder(View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.bookname_item_borrowing);
            borrowTime = (TextView) itemView.findViewById(R.id.borrowtime_item_borrowing);
            giveBackTime = (TextView) itemView.findViewById(R.id.givebacktime_item_borrowing);
            reborrowBtn = (Button) itemView.findViewById(R.id.btn_reborrow_borrowing);
        }
    }


}
