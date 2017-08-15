package com.hebth.mobilelibrary.ui.readerinfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.UserBean;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.readerinfo.net.UserInfoRequestParames;
import com.hebth.mobilelibrary.utils.CommenUtils;
import com.hebth.mobilelibrary.utils.SharedPreferenceUtil;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class ReaderInfoActivity extends BaseActivity {

    @ViewInject(R.id.tv_username_userinfo)//登录名称
    private TextView userName_tv;
    @ViewInject(R.id.tv_realnamer_userinfo)//真实姓名
    private TextView realName_tv;
    @ViewInject(R.id.tv_sex_userinfo)//性别
    private TextView sex_tv;
    @ViewInject(R.id.tv_email_userinfo)//EMAIL
    private TextView email_tv;
    @ViewInject(R.id.tv_telephone_userinfo)//电话
    private TextView telephone_tv;
    @ViewInject(R.id.tv_maxborrowcount_userinfo)//可借阅量
    private TextView maxCount_tv;
    @ViewInject(R.id.tv_borrowtimes_userinfo)//借阅次数
    private TextView borrowedTimes_tv;
    @ViewInject(R.id.tv_borrowedcount_userinfo)//已借阅量
    private TextView borrowedCount_tv;
    @ViewInject(R.id.tv_ordercount_userinfo)//已预约量
    private TextView orderCount_tv;
    @ViewInject(R.id.tv_overtimecount_userinfo)//超期图数量
    private TextView overTimeCount_tv;
    @ViewInject(R.id.tv_lastlogintime_userinfo)//上次登录时间
    private TextView lastLoginTime_tv;
    @ViewInject(R.id.tv_address_userinfo)//地址
    private TextView address_tv;
    private Callback.Cancelable post;
//    private MyProgressDialog dialog;


    public static Intent getReaderInfoIntent(Context context) {
        return new Intent(context, ReaderInfoActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_reader_info;
    }

    @Override
    public void initView() {
//
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_readerinfo);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("个人信息");
        mToolBar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        showDialog("加载中..");
        getDataFromNet();
    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getDataFromNet() {
        UserInfoRequestParames parames = new UserInfoRequestParames();
        parames.UserName = SharedPreferenceUtil.getUsername();
        post = x.http().post(parames, new Callback.CommonCallback<List<UserBean>>() {
            @Override
            public void onSuccess(List<UserBean> result) {

                UserBean userBean01 = result.get(0);
                UserBean userBean02 = result.get(1);

                setText(userName_tv, userBean01.getUserName());//登录姓名
                setText(realName_tv, userBean01.getRealName());//真实姓名
                setText(sex_tv, userBean01.getSex());//性别
                setText(email_tv, userBean01.getEmail());//email
                setText(telephone_tv, userBean01.getTelephone());//电话
                setText(borrowedTimes_tv, "" + userBean01.getBorrowTimes());//借阅次数
                setText(maxCount_tv, "" + userBean02.getMaxBorrowedCount());//可借阅量
                setText(borrowedCount_tv, "" + userBean02.getBorrowedCount());//已借阅量
                setText(orderCount_tv, "" + userBean02.getOrderCount());//已预约量
                setText(overTimeCount_tv, "" + userBean02.getOverTimeCount());//超期图书量
                setText(lastLoginTime_tv, userBean01.getLastLoginTime());//上次登录时间
                setText(address_tv, userBean01.getAddress());//地址
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.e(ex.getMessage());
                ToastUtils.showText(ReaderInfoActivity.this, "未查询到数据,请刷新重试..");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                hideDialog();
            }
        });
    }

    public void setText(TextView tv, String value) {
        if (CommenUtils.isEmpty(value)) {
            tv.setText(value);
        } else {
            tv.setText("...");
        }
    }

    /**
     * 显示加载动画
     */
    public void showDialog(String str) {

    }

    /**
     * 隐藏加载动画
     */
    public void hideDialog() {
        post.cancel();
    }
}
