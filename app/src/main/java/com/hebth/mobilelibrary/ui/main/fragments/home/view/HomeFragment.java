package com.hebth.mobilelibrary.ui.main.fragments.home.view;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.main.fragments.home.adapter.CarouselVpAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.home.adapter.ContainerAdapter;

import java.util.ArrayList;

/**
 * Created by hebth on 2017-06-08.
 * 首页Fragment，展示轮播图，功能区按钮，公告区域
 * 点击跳转到对应的功能
 */

public class HomeFragment extends BaseFragment implements Handler.Callback, View.OnClickListener {
    public static final String TAG = HomeFragment.class.getName();
    public static final int NEXTIMAGE = 0x200;
    public static final int CAROUSEL_DELAY_TIME = 2000;

    private ViewPager carousel_vp;
    private LinearLayout OPAC_btn;
    private LinearLayout recommend_btn;
    private LinearLayout borrowlist_btn;
    private LinearLayout rq_btn;
    private LinearLayout readerinfo_btn;
    private LinearLayout shelf_btn;
    private LinearLayout borrowing_btn;
    private LinearLayout history_btn;
    private TabLayout mTab;
    private ViewPager container_vp;
    private CarouselVpAdapter carouselAdapter;

    private Handler mHandler = new Handler(this);

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        carousel_vp = (ViewPager) mView.findViewById(R.id.vp_carousel_home);
        OPAC_btn = (LinearLayout) mView.findViewById(R.id.btn_opac_home);
        recommend_btn = (LinearLayout) mView.findViewById(R.id.btn_recommend_home);
        borrowlist_btn = (LinearLayout) mView.findViewById(R.id.btn_borrowlist_home);
        rq_btn = (LinearLayout) mView.findViewById(R.id.btn_rq_home);
        readerinfo_btn = (LinearLayout) mView.findViewById(R.id.btn_readerinfo_home);
        shelf_btn = (LinearLayout) mView.findViewById(R.id.btn_shelf_home);
        borrowing_btn = (LinearLayout) mView.findViewById(R.id.btn_borrowing_home);
        history_btn = (LinearLayout) mView.findViewById(R.id.btn_history_home);
        mTab = (TabLayout) mView.findViewById(R.id.tab_vp_home);
        container_vp = (ViewPager) mView.findViewById(R.id.vp_home);
        //
        ArrayList<String> mList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mList.add("https://www.baidu.com/img/bd_logo1.png");
        }
        carouselAdapter = new CarouselVpAdapter(getContext(), mList);
        carousel_vp.setAdapter(carouselAdapter);
        mHandler.sendEmptyMessageDelayed(NEXTIMAGE, CAROUSEL_DELAY_TIME);
        //
        ArrayList<Fragment> fList = new ArrayList<>();
        fList.add(new NewsFragment());
        fList.add(new SystemInfoFragment());
        ContainerAdapter containerAdapter = new ContainerAdapter(getFragmentManager(), fList);
        container_vp.setAdapter(containerAdapter);
        mTab.setupWithViewPager(container_vp);
    }

    @Override
    public void initListener() {
        OPAC_btn.setOnClickListener(this);
        recommend_btn.setOnClickListener(this);
        borrowlist_btn.setOnClickListener(this);
        rq_btn.setOnClickListener(this);
        readerinfo_btn.setOnClickListener(this);
        shelf_btn.setOnClickListener(this);
        borrowing_btn.setOnClickListener(this);
        history_btn.setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.what) {
            case NEXTIMAGE:
                carousel_vp.setCurrentItem(carousel_vp.getCurrentItem() + 1);
                mHandler.sendEmptyMessageDelayed(NEXTIMAGE, CAROUSEL_DELAY_TIME);
                break;
        }
        return false;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_opac_home:

                break;
            case R.id.btn_recommend_home:

                break;
            case R.id.btn_borrowlist_home:

                break;

            case R.id.btn_rq_home:

                break;
            case R.id.btn_readerinfo_home:

                break;

            case R.id.btn_shelf_home:

                break;
            case R.id.btn_borrowing_home:

                break;
            case R.id.btn_history_home:

                break;
        }
    }
}
