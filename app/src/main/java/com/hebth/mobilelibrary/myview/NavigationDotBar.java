package com.hebth.mobilelibrary.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by kevin on 2017-07-26.
 * 小圆点导航
 */

public class NavigationDotBar extends View {

    private int dotNum;//小圆点的个数
    private int dotSize;//小圆点的大小
    private int dotMargin;//小圆点的间距
    private int position;//小圆点的位置
    private int backDotColor;//背景小圆点的颜色
    private int topDotColor;//顶部小圆点的颜色
    private int backGround;//导航条的背景色
    private Paint paint;//画笔
    private int width;//控件的宽度
    private int height;//控件的高度
    private int xCenter;//小圆点的圆心x值
    private int yCenter;//小圆点的圆心y值

    /**
     * 设置背景小圆点的数量
     *
     * @param dotNum
     */
    public void setDotNum(int dotNum) {
        this.dotNum = dotNum;
    }

    /**
     * 设置背景小圆点的颜色
     *
     * @param backDotColor
     */
    public void setBackDotColor(int backDotColor) {
        this.backDotColor = backDotColor;
    }

    /**
     * 设置顶部小圆点的颜色
     *
     * @param topDotColor
     */
    public void setTopDotColor(int topDotColor) {
        this.topDotColor = topDotColor;
    }

    /**
     * 设置导航条的背景色
     *
     * @param backGround
     */
    public void setBackGround(int backGround) {
        this.backGround = backGround;
    }

    /**
     * 设置小圆点的大小
     *
     * @param dotSize
     */
    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
    }

    /**
     * 设置小圆点的间距
     *
     * @param dotMargin
     */
    public void setDotMargin(int dotMargin) {
        this.dotMargin = dotMargin;
    }

    public NavigationDotBar(Context context) {
        this(context, null);
    }

    public NavigationDotBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationDotBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        position = 1;
        dotNum = 1;
        dotSize = 10;
        dotMargin = 8;
        backDotColor = Color.GRAY;
        topDotColor = Color.WHITE;
        backGround = Color.BLACK;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);  //抗锯齿
    }

    private int firstDotLeft;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        yCenter = height / 2;
        firstDotLeft = (width - (dotSize * dotNum + dotMargin * (dotNum - 1))) / 2;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(backDotColor);
        for (int i = 0; i < dotNum; i++) {
            xCenter = firstDotLeft + (dotSize / 2) + i * (dotSize + dotMargin);
            canvas.drawCircle(xCenter, yCenter, dotSize, paint);
        }
        paint.setColor(topDotColor);
        xCenter = firstDotLeft + (dotSize / 2) + (position - 1) * (dotSize + dotMargin);
        canvas.drawCircle(xCenter, yCenter, dotSize, paint);
    }

    /**
     * 设置当前小圆点的位置
     *
     * @param position position 从0开始
     */
    public void setCurrentPosition(int position) {
        this.position = position % dotNum + 1;
        invalidate();
    }
}
