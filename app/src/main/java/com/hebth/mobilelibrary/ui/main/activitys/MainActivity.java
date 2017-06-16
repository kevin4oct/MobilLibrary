package com.hebth.mobilelibrary.ui.main.activitys;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.view.EbookFragment;
import com.hebth.mobilelibrary.ui.main.fragments.home.view.HomeFragment;
import com.hebth.mobilelibrary.ui.main.fragments.library.LibraryFragment;
import com.hebth.mobilelibrary.ui.main.fragments.mine.MineFragment;
import com.orhanobut.logger.Logger;

import org.xutils.view.annotation.ViewInject;

/**
 * 主页面，fragment和控制条的容器，点击控制条的radiobutton切换到对应的fragment
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @ViewInject(R.id.control_main)
    private RadioGroup mControler;

    private DrawerLayout mDrawerlayout;

    //    private TextView title_tv;
    private Toolbar mToolBar;

    private Fragment mShowFragment = new HomeFragment();
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout_main);
        mToolBar = (Toolbar) findViewById(R.id.toolbar_main);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("天海移动图书馆");
        setSupportActionBar(mToolBar);
        //设置返回键可用
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//创建返回键，并实现打开/关闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolBar, R.string.open, R.string.close) {

        };
        mDrawerToggle.syncState();
        mDrawerlayout.setDrawerListener(mDrawerToggle);


        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
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
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        transaction.commit();
        if (MineFragment.TAG.equals(fragmentTag)) {
            mToolBar.setTitle(getResources().getString(R.string.mine));
        } else if (EbookFragment.TAG.equals(fragmentTag)) {
            mToolBar.setTitle(getResources().getString(R.string.ebook));
        } else if (LibraryFragment.TAG.equals(fragmentTag)) {
            mToolBar.setTitle(getResources().getString(R.string.library));
        } else {
            mToolBar.setTitle(getResources().getString(R.string.app_name));
        }

    }

}
