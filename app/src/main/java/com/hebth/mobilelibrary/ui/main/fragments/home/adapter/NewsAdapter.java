package com.hebth.mobilelibrary.ui.main.fragments.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-13.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsBean> mList;
    private LayoutInflater inflater;

    public NewsAdapter(Context context, List<NewsBean> mList) {
        if (mList != null) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
        }
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_rv_news, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsBean newsBean = mList.get(position);
        holder.title.setText(newsBean.getTitle());
        holder.time.setText(newsBean.getTime());
    }

    @Override
    public int getItemCount() {
        return mList != null?mList.size():0;
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
