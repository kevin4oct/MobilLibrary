package com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebth on 2017-06-09.
 * Ebook viewpager的适配器
 */

public class EbookVpAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    public EbookVpAdapter(FragmentManager fm, List<Fragment> mList) {
        super(fm);
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
        return mList.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "阅读";
//            case 1:
//                return "书架";
//        }
//        return null;
//    }
}
