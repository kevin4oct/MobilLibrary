package com.hebth.mobilelibrary.ui.main.activitys;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.view.EbookFragment;
import com.hebth.mobilelibrary.ui.main.fragments.home.view.HomeFragment;
import com.hebth.mobilelibrary.ui.main.fragments.library.LibraryFragment;
import com.hebth.mobilelibrary.ui.main.fragments.mine.MineFragment;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.xutils.view.annotation.ViewInject;

/**
 * 主页面，fragment和控制条的容器，点击控制条的radiobutton切换到对应的fragment
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, Toolbar.OnMenuItemClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @ViewInject(R.id.control_main)
    private RadioGroup mControler;
    private Fragment mShowFragment = new HomeFragment();

    public static Intent getMainIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        //设置碎片切换
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container_main, mShowFragment, HomeFragment.TAG);
        transaction.commit();
    }

    @Override
    public void initListener() {
        mControler.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        switch (checkedId) {
            case R.id.rb_home_control:
                switchFragment(HomeFragment.TAG);
                break;
            case R.id.rb_ebook_control:
                switchFragment(EbookFragment.TAG);
                break;
            case R.id.rb_library_control:
                switchFragment(LibraryFragment.TAG);
                break;
            case R.id.rb_mine_control:
                switchFragment(MineFragment.TAG);
                break;
        }
    }

    private void switchFragment(String fragmentTag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (mShowFragment != null) {
            transaction.hide(mShowFragment);
        }
        mShowFragment = fm.findFragmentByTag(fragmentTag);
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        } else {
            try {
                mShowFragment = (Fragment) Class.forName(fragmentTag).newInstance();
                transaction.add(R.id.container_main, mShowFragment, fragmentTag);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                Logger.e(e.getMessage());
            }

        }
        transaction.commit();
    }

    /**
     * 再按一次退出
     */
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtils.showText(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        ToastUtils.showText(this, "search");

        return false;
    }
}
