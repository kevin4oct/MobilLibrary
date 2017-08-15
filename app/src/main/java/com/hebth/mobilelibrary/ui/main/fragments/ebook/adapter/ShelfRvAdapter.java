package com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.EBookBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-20.
 * 书架Fragment Recycler 的适配器
 */

public class ShelfRvAdapter extends RecyclerView.Adapter<ShelfRvAdapter.ViewHolder> {

    private List<EBookBean> mList;
    private Context context;
    private LayoutInflater inflater;

    public ShelfRvAdapter(Context context, List<EBookBean> mList) {
        if (mList != null) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
        }
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_vp_shelf, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        Picasso.with(context).load(mList.get(position).getBookCover())
//                .placeholder(R.mipmap.temp_small).into(holder.bookCover);

        holder.bookCover.setImageURI(mList.get(position).getBookCover());
        holder.bookName.setText(mList.get(position).getBookName());

    }

    /**
     * 刷新数据
     *
     * @param mList
     */
    public void refreshData(List<EBookBean> mList) {
        if (mList != null) {
            this.mList.clear();
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView bookCover;
        public TextView bookName;

        public ViewHolder(View itemView) {
            super(itemView);
            bookCover = (SimpleDraweeView) itemView.findViewById(R.id.iv_item_shelf);
            bookName = (TextView) itemView.findViewById(R.id.tv_item_shelf);
        }
    }
}
