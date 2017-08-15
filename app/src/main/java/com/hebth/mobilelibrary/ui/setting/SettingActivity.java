package com.hebth.mobilelibrary.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.login.LoginActivity;
import com.hebth.mobilelibrary.ui.main.activitys.MainActivity;
import com.hebth.mobilelibrary.utils.CleanUtils;
import com.hebth.mobilelibrary.utils.SharedPreferenceUtil;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.zhy.android.percent.support.PercentRelativeLayout;

import org.xutils.view.annotation.ViewInject;

public class SettingActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {

    @ViewInject(R.id.rl_pingfen_setting)
    private PercentRelativeLayout pingfen_rl;
    @ViewInject(R.id.rl_clean_setting)
    private PercentRelativeLayout clean_rl;
    @ViewInject(R.id.tv_cacheSize_setting)
    private TextView cacheSize_tv;
    @ViewInject(R.id.btn_logout_setting)
    private Button logoutBtn;

    private static MainActivity activity;

    public static Intent getSettingIntent(Context context) {
        activity = (MainActivity) context;
        return new Intent(context, SettingActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_setting);
        toolbar.setTitle("程序设置");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(toolbar);
        //
        try {
            cacheSize_tv.setText(CleanUtils.getTotalCacheSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initListener() {
        pingfen_rl.setOnClickListener(this);
        pingfen_rl.setOnTouchListener(this);
        clean_rl.setOnClickListener(this);
        clean_rl.setOnTouchListener(this);
        logoutBtn.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_pingfen_setting:
                ToastUtils.showText(this, "感谢您的五分好评，您的肯定是我们前进最大的动力！");
                break;
            case R.id.rl_clean_setting:
                CleanUtils.clearAllCache();
                try {
                    cacheSize_tv.setText(CleanUtils.getTotalCacheSize());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_logout_setting:
                new AlertDialog.Builder(this)
                        .setTitle("您确定要退出么？")
                        .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //清空登录信息
                                SharedPreferenceUtil.cleanLoginInfo();
                                startActivity(LoginActivity.getLoginIntent(SettingActivity.this));
                                activity.finish();
                                SettingActivity.this.finish();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                v.setBackgroundColor(Color.GRAY);
                break;
            case MotionEvent.ACTION_UP:
                v.setBackgroundColor(Color.WHITE);
                break;
        }

        return false;
    }
}
