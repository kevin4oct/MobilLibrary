package com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.ReadCarouselBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-12.
 * 电子阅读轮播图的适配器
 */

public class ReadCarouselVpAdapter extends PagerAdapter {

    private List<ReadCarouselBean.DataBean> mLists;
    private Context context;

    public ReadCarouselVpAdapter(Context context, List<ReadCarouselBean.DataBean> mLists) {

        this.context = context;
        if (mLists != null) {
            this.mLists = mLists;
        } else {
            this.mLists = new ArrayList<>();
            ReadCarouselBean.DataBean bean = new ReadCarouselBean.DataBean();
            this.mLists.add(bean);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        position = position % (mLists != null ? mLists.size() : 1);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        String fileUrl = mLists.get(position).getFileUrl();

        Picasso.with(context)
                .load(fileUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
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
        return mLists != null ? Integer.MAX_VALUE / 2 : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
