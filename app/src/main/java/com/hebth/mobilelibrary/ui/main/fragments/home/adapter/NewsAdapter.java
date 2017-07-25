package com.hebth.mobilelibrary.ui.main.fragments.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.NewsBean;
import com.hebth.mobilelibrary.ui.newsdetail.NewsDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-13.
 * homeFragment新闻公告的适配器
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> implements View.OnClickListener {

    private List<NewsBean> mList;
    private LayoutInflater inflater;
    private Context context;
    private RecyclerView mRecycler;

    public NewsAdapter(Context context, RecyclerView mRecycler, List<NewsBean> mList) {
        if (mList != null) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
        }
        this.mRecycler = mRecycler;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    /**
     * 刷新
     *
     * @param mList 填充的数据
     */
    public void refreshDate(List<NewsBean> mList) {
        if (mList != null) {
            this.mList.clear();
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    /**
     * 加载
     *
     * @param mList 填充的数据
     */
    public void loadDate(List<NewsBean> mList) {
        if (mList != null) {
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_rv_news, parent, false);
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsBean newsBean = mList.get(position);
        holder.title.setText(newsBean.getQTitle());
        String addTime = newsBean.getAddTime();
        holder.time.setText(addTime.substring(0, addTime.indexOf(" ")));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int position = mRecycler.getChildAdapterPosition(v);
        context.startActivity(NewsDetailActivity.getNewsDetailIntent(context, mList.get(position)));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView time;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_title_news);
            time = (TextView) itemView.findViewById(R.id.tv_time_news);
        }
    }
}
