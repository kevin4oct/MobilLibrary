package com.hebth.mobilelibrary.myview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;


/**
 * Created by kevin on 2017/3/29.
 * 显示和隐藏加载动画对话框的工具类
 */
public class MyProgressDialog extends Dialog {

    public MyProgressDialog(Context context) {
        super(context);
    }

    public MyProgressDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
    }

    /**
     * 当窗口焦点改变时调用
     */
    public void onWindowFocusChanged(boolean hasFocus) {

        ImageView imageView = (ImageView) findViewById(R.id.loadingIv);
        // 获取ImageView上的动画背景
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        // 开始动画
        spinner.start();
    }

    /**
     * 给Dialog设置提示信息
     *
     * @param message 显示的提示内容
     */
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            findViewById(R.id.loadingTv).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.loadingTv);
            txt.setText(message);
            txt.invalidate();
        }
    }

    /**
     * 弹出自定义ProgressDialog
     *
     * @param context        上下文
     * @param message        提示
     * @param cancelable     是否按返回键取消
     * @param cancelListener 按下返回键监听
     * @return 返回一个设置好的dialog
     */
    public static MyProgressDialog show(Context context, CharSequence message, boolean cancelable, OnCancelListener cancelListener) {

        MyProgressDialog dialog = new MyProgressDialog(context, R.style.Custom_Progress);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_dialog);
        if (message == null || message.length() == 0) {
            dialog.findViewById(R.id.loadingTv).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView) dialog.findViewById(R.id.loadingTv);
            txt.setVisibility(View.VISIBLE);
            txt.setText(message);
        }
        // 按返回键是否取消
        dialog.setCancelable(cancelable);
        // 监听返回键处理
        dialog.setOnCancelListener(cancelListener);
        // 设置居中
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.7f;
        dialog.getWindow().setAttributes(lp);
        // dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.show();
        return dialog;
    }
}
