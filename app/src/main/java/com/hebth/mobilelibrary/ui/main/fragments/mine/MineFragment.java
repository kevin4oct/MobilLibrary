package com.hebth.mobilelibrary.ui.main.fragments.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.about.AboutActivity;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.borrowing.BorrowingActivity;
import com.hebth.mobilelibrary.ui.readerinfo.ReaderInfoActivity;
import com.hebth.mobilelibrary.ui.setting.SettingActivity;
import com.hebth.mobilelibrary.utils.SharedPreferenceUtil;

/**
 * Created by hebth on 2017-06-08.
 * 我的Fragment，用于展示我的借阅记录和我的个人信息，点击按钮实现续借功能
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = MineFragment.class.getName();


    private ImageView photo_iv;
    private RelativeLayout persioninfo_rl;
    private RelativeLayout borrowInfo_rl;
    private RelativeLayout setting_rl;
    private RelativeLayout about_rl;
    private TextView userName_tv;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //设置用户名
        userName_tv = (TextView) mView.findViewById(R.id.tv_username_mine);
        userName_tv.setText(SharedPreferenceUtil.getUsername());
        //加载用户头像
        photo_iv = (ImageView) mView.findViewById(R.id.iv_photo_mine);

//        Picasso.with(getContext()).load(R.mipmap.icon_user_mine).transform(new CircleTransform()).into(photo_iv);
        persioninfo_rl = (RelativeLayout) mView.findViewById(R.id.rl_persion_mine);
        borrowInfo_rl = (RelativeLayout) mView.findViewById(R.id.rl_borrowing_mine);
        setting_rl = (RelativeLayout) mView.findViewById(R.id.rl_setting_mine);
        about_rl = (RelativeLayout) mView.findViewById(R.id.rl_about_mine);
    }

    @Override
    public void initListener() {
        persioninfo_rl.setOnClickListener(this);
        borrowInfo_rl.setOnClickListener(this);
        setting_rl.setOnClickListener(this);
        about_rl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_persion_mine:
                startActivity(ReaderInfoActivity.getReaderInfoIntent(getContext()));
                break;
            case R.id.rl_borrowing_mine:
                startActivity(BorrowingActivity.getBorrowingIntent(getContext()));
                break;
            case R.id.rl_setting_mine:
                startActivity(SettingActivity.getSettingIntent(getContext()));
                break;
            case R.id.rl_about_mine:
                startActivity(AboutActivity.getAboutIntent(getContext()));
                break;
        }
    }
}
