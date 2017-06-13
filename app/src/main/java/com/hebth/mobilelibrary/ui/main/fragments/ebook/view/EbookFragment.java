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
 * 电子阅读Fragment，用于展示电子书列表，点击进入电子书详情
 * <p>
 * 轮播图
 * http://101.201.116.210:7726/imageManage/getImagePathForMobile/1902ce11663d4399856887e1d11918c0
 * 书城（图书列表）---------------------------------
 * //http://101.201.116.210:7726/bookTypeAndSearch/queryBookList?rankType=1&pageSize=12&pageNum=1&pageType=3&keyword=&classificationType=&classificationNumber=&classificationId=&bookType=L15_1&press=&upYearEndVal=&desc=0&upYearStartVal=&yearEnd=&yearStart=
 * 图书详情---------------------------------
 * //http://101.201.116.210:7726/mobile/bookDetailById?bookId=fe0e12821e5a11e7bd1f00163e160aa8
 * 资源前缀---------------------------------
 * // http://101.201.114.210/591/ebooks/    +   参数string
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
