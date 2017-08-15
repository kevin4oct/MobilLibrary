package com.hebth.mobilelibrary.ui.main.fragments.ebook.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.EbookVpAdapter;

import java.util.ArrayList;

/**
 * Created by hebth on 2017-06-08.
 * 电子阅读Fragment，用于展示电子书Fragment,切换Fragment
 */
public class EbookFragment extends BaseFragment {
    public static final String TAG = EbookFragment.class.getName();

    private ViewPager vp_container;
    private Toolbar mToolBar;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_ebook;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //

        //
        vp_container = (ViewPager) mView.findViewById(R.id.vp_ebook);
        ArrayList<Fragment> mList = new ArrayList<>();
        mList.add(new ReadFragment());
        EbookVpAdapter adapter = new EbookVpAdapter(getFragmentManager(), mList);
        vp_container.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }


}
