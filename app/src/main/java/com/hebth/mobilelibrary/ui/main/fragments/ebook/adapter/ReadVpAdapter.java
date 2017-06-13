package com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hebth.mobilelibrary.beans.ReadCarouselBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-12.
 */

public class ReadVpAdapter extends PagerAdapter {

    private List<ReadCarouselBean.DataBean> mLists;
    private Context context;

    public ReadVpAdapter(Context context, List<ReadCarouselBean.DataBean> mLists) {

        this.context = context;

        if (mLists != null) {
            this.mLists = mLists;
        } else {
            this.mLists = new ArrayList<>();
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(context).load(mLists.get(position).getFileUrl()).into(imageView);
        container.addView(imageView);
        return imageView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(mLists.get(position));

    }

    public void refreshData(ReadCarouselBean bean) {
        if (bean != null) {
            this.mLists.clear();
            this.mLists.addAll(bean.getData());
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mLists != null ? mLists.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
