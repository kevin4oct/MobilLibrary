package com.hebth.mobilelibrary.ui.main.fragments.ebook.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

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
    private TabLayout mTabLayout;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_ebook;
    }

    @Override
    public void initView() {
        vp_container = (ViewPager) mView.findViewById(R.id.vp_ebook);
        mTabLayout = (TabLayout) mView.findViewById(R.id.tablayout_ebook);
        ArrayList<Fragment> mList = new ArrayList<>();
        mList.add(new ReadFragment());
        mList.add(new ClassFragment());
        mList.add(new DissertationFragment());
        EbookVpAdapter adapter = new EbookVpAdapter(getFragmentManager(), mList);
        vp_container.setAdapter(adapter);
        mTabLayout.setupWithViewPager(vp_container);
    }

    @Override
    public void initListener() {

    }


}
