package com.hebth.mobilelibrary.ui.main.fragments.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-13.
 */

public class CarouselVpAdapter extends PagerAdapter {

    private List<String> mList;
    private Context context;

    public CarouselVpAdapter(Context context, List<String> mList) {
        this.context = context;
        if (mList != null) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % (mList != null ? mList.size() : 1);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(context).load(mList.get(position)).into(imageView);
        container.addView(imageView, position);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

//        super.destroyItem(container, position, object);
        position = position % (mList != null ? mList.size() : 1);
        container.removeViewAt(position);
    }

    @Override
    public int getCount() {
        return mList != null ? Integer.MAX_VALUE / 2 : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
