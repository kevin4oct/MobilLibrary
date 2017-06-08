package com.hebth.mobilelibrary.ui.main.activitys;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.view.EbookFragment;
import com.hebth.mobilelibrary.ui.main.fragments.home.HomeFragment;
import com.hebth.mobilelibrary.ui.main.fragments.library.LibraryFragment;
import com.hebth.mobilelibrary.ui.main.fragments.mine.MineFragment;

import org.xutils.view.annotation.ViewInject;

/**
 * 主页面，fragment和控制条的容器，点击控制条的radiobutton切换到对应的fragment
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @ViewInject(R.id.control_main)
    private RadioGroup mControler;

    private Fragment mShowFragment = new HomeFragment();

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toobar_main);
        setSupportActionBar(toolbar);

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
    }

}
