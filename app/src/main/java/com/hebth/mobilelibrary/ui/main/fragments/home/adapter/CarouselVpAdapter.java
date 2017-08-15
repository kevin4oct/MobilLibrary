package com.hebth.mobilelibrary.ui.main.fragments.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-13.
 * homefragment中轮播图的适配器
 */

public class CarouselVpAdapter extends PagerAdapter {

    private List<Integer> mList;
    private Context context;

    public CarouselVpAdapter(Context context, List<Integer> mList) {
        this.context = context;
        if (mList != null) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View contentView = (View) object;
        container.removeView(contentView);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        ImageView imageView = new ImageView(context);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        Picasso.with(context)
//                .load(mList.get(position % mList.size()))
//                .placeholder(R.mipmap.temp_big)
//                .into(imageView);
        SimpleDraweeView draweeView = new SimpleDraweeView(context);
        draweeView.setImageResource(mList.get(position % mList.size()));
        draweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(draweeView);
        return draweeView;
//        ViewHolder holder = null;
//        View convertView = null;
//        if (mViewCache.size() == 0) {
//            holder = new ViewHolder();
//            convertView = inflater.inflate(R.layout.item_vp_carousel_home, null, false);
//            holder.iv = (ImageView) convertView.findViewById(R.id.iv_carousel_home);
//            convertView.setTag(holder);
//        } else {
//            convertView = mViewCache.removeFirst();
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        Picasso.with(context).load(mList.get(position % mList.size())).into(holder.iv);
//
//        container.addView(convertView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//        return convertView;
    }

    @Override
    public int getCount() {
        return mList != null ? Integer.MAX_VALUE / 2 : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

//    private class ViewHolder {
//        public ImageView iv;
//    }
}
