package com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.base.AppConstant;
import com.hebth.mobilelibrary.beans.ReadFragmentBean;
import com.hebth.mobilelibrary.ui.detail.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-09.
 * ReadFragment中RecyclerView 的适配器
 */

public class ReadRvAdapter extends RecyclerView.Adapter<ReadRvAdapter.ViewHolder> implements View.OnClickListener {

    public static final String TAG = ReadRvAdapter.class.getSimpleName();

    private List<ReadFragmentBean.DataBean.ListBean> mList;
    private Context context;
    private LayoutInflater inflater;
    private RecyclerView mRecycler;

    public ReadRvAdapter(Context context, RecyclerView mRecycler, List<ReadFragmentBean.DataBean.ListBean> mList) {
        if (mList != null) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
        }
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.mRecycler = mRecycler;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_vp_read, parent, false);
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ReadFragmentBean.DataBean.ListBean listBean = mList.get(position);
        if (listBean != null) {
            holder.tv.setText(listBean.getBookName());
            Picasso.with(context)
                    .load(AppConstant.RESOURCESTR + listBean.getBookPictures().get(0).getFilePath())
                    .into(holder.iv);
        }
    }



    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    /**
     * 下拉刷新
     *
     * @param lists
     */
    public void refreshData(List<ReadFragmentBean.DataBean.ListBean> lists) {
        if (lists != null) {
            this.mList.clear();
            this.mList.addAll(lists);
            notifyDataSetChanged();
        }
    }

    /**
     * 上拉加载
     *
     * @param lists
     */
    public void loadData(List<ReadFragmentBean.DataBean.ListBean> lists) {
        if (lists != null) {
            this.mList.addAll(lists);
            notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        int position = mRecycler.getChildAdapterPosition(v);
        Log.e(TAG, "onClick: "+position );
        context.startActivity(DetailActivity.getDetailActivity(context,mList.get(position).getId()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv;
        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_read_item);
            tv = (TextView) itemView.findViewById(R.id.tv_read_item);
        }
    }
}
