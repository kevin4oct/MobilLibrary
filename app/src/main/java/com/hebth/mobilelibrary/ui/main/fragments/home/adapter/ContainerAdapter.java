package com.hebth.mobilelibrary.ui.main.fragments.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-13.
 */

public class ContainerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    public ContainerAdapter(FragmentManager manager, List<Fragment> mList) {
        super(manager);

        if (mList != null) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "本馆新闻";
                break;
            case 1:
                title = "系统公告";
                break;
        }
        return title;
    }
}
