package com.hebth.mobilelibrary.ui.opac.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-19.
 * opacViewpager的适配器
 */

public class OpacVpAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    public OpacVpAdapter(FragmentManager fm, List<Fragment> mList) {
        super(fm);
        if (fm != null) {
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
                title = "新书推荐";
                break;
            case 1:
                title = "借阅排行";
                break;
        }

        return title;
    }
}
