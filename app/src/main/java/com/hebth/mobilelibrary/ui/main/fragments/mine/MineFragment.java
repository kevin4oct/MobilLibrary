package com.hebth.mobilelibrary.ui.main.fragments.mine;

import android.widget.ImageView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.myview.CircleTransform;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.squareup.picasso.Picasso;

/**
 * Created by hebth on 2017-06-08.
 * 我的Fragment，用于展示我的借阅记录和我的个人信息，点击按钮实现续借功能
 */

public class MineFragment extends BaseFragment {
    public static final String TAG = MineFragment.class.getName();

    private ImageView photo_iv;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        //加载用户头像
        photo_iv = (ImageView) mView.findViewById(R.id.iv_photo_mine);
        Picasso.with(getContext()).load(R.mipmap.icon_user_mine).transform(new CircleTransform()).into(photo_iv);
    }

    @Override
    public void initListener() {

    }
}
