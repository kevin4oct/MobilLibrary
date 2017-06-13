package com.hebth.mobilelibrary.myview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hebth on 2017-06-09.
 * 重写Viewpager的onMeasure方法，解决嵌套viewpager高度测量失败的问题
 */
public class WrapContentHeightViewpager extends ViewPager {
    public WrapContentHeightViewpager(Context context) {
        super(context);
    }

    public WrapContentHeightViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        int height = 0;
//
//        for (int i = 0; i < getChildCount(); i++) {
//            View child = getChildAt(i);
//            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//            int h = child.getMeasuredHeight();
//            if (h > height) height = h;
//        }
//
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);


        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(400, MeasureSpec.EXACTLY));
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

}