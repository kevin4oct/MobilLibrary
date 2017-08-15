package com.hebth.mobilelibrary.ui.main.fragments.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.myview.NavigationDotBar;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.borrowList.BorrowListActivity;
import com.hebth.mobilelibrary.ui.borrowing.BorrowingActivity;
import com.hebth.mobilelibrary.ui.ebookshelf.EbookShelfActivity;
import com.hebth.mobilelibrary.ui.history.HistoryActivity;
import com.hebth.mobilelibrary.ui.main.fragments.home.adapter.CarouselVpAdapter;
import com.hebth.mobilelibrary.ui.main.fragments.home.adapter.ContainerAdapter;
import com.hebth.mobilelibrary.ui.opac.view.activity.OPACActivity;
import com.hebth.mobilelibrary.ui.readerinfo.ReaderInfoActivity;
import com.hebth.mobilelibrary.ui.recommend.RecommendActivity;
import com.hebth.mobilelibrary.ui.saoyisao.RQActivity;

import java.util.ArrayList;

/**
 * Created by hebth on 2017-06-08.
 * 首页Fragment，展示轮播图，功能区按钮，公告区域
 * 点击跳转到对应的功能
 */

public class HomeFragment extends BaseFragment implements Handler.Callback, View.OnClickListener {
    public static final String TAG = HomeFragment.class.getName();
    public static final int NEXTIMAGE = 0x200;
    public static final int CAROUSEL_DELAY_TIME = 3000;

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
    //小圆点导航
    private NavigationDotBar navigationBar;

    private Handler mHandler = new Handler(this);

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        carousel_vp = (ViewPager) mView.findViewById(R.id.vp_carousel_home);
        OPAC_btn = (LinearLayout) mView.findViewById(R.id.btn_search_home);
        recommend_btn = (LinearLayout) mView.findViewById(R.id.btn_recommend_home);
        borrowlist_btn = (LinearLayout) mView.findViewById(R.id.btn_borrowlist_home);
        rq_btn = (LinearLayout) mView.findViewById(R.id.btn_rq_home);
        readerinfo_btn = (LinearLayout) mView.findViewById(R.id.btn_readerinfo_home);
        shelf_btn = (LinearLayout) mView.findViewById(R.id.btn_shelf_home);
        borrowing_btn = (LinearLayout) mView.findViewById(R.id.btn_borrowing_home);
        history_btn = (LinearLayout) mView.findViewById(R.id.btn_history_home);
        mTab = (TabLayout) mView.findViewById(R.id.tab_vp_home);
        container_vp = (ViewPager) mView.findViewById(R.id.vp_home);
        //添加轮播图
//        ArrayList<ImageView> mList = new ArrayList<>();
//        ImageView imageView01 = new ImageView(getContext());
//        imageView01.setImageResource(R.mipmap.carouse01);
//        mList.add(imageView01);
//        ImageView imageView02 = new ImageView(getContext());
//        imageView02.setImageResource(R.mipmap.carouse02);
//        mList.add(imageView02);
//        ImageView imageView03 = new ImageView(getContext());
//        imageView03.setImageResource(R.mipmap.carouse03);
//        mList.add(imageView03);
//        ImageView imageView04 = new ImageView(getContext());
//        imageView04.setImageResource(R.mipmap.carouse04);
//        mList.add(imageView04);
        ArrayList<Integer> mList = new ArrayList<>();
        mList.add(R.mipmap.carouse01);
        mList.add(R.mipmap.carouse02);
        mList.add(R.mipmap.carouse03);
        mList.add(R.mipmap.carouse04);
        carouselAdapter = new CarouselVpAdapter(getContext(), mList);
        carousel_vp.setAdapter(carouselAdapter);
        //添加碎片
        ArrayList<Fragment> fList = new ArrayList<>();
        fList.add(new NewsFragment());
        fList.add(new SystemInfoFragment());
        ContainerAdapter containerAdapter = new ContainerAdapter(getFragmentManager(), fList);
        container_vp.setAdapter(containerAdapter);
        mTab.setupWithViewPager(container_vp);
        //导航小圆点
        navigationBar = (NavigationDotBar) mView.findViewById(R.id.navigation_home);
        navigationBar.setDotNum(mList.size());
        navigationBar.setDotMargin(50);
    }

    @Override
    public void onResume() {
        super.onResume();
        mHandler.sendEmptyMessageDelayed(NEXTIMAGE, CAROUSEL_DELAY_TIME);
    }

    @Override
    public void onPause() {
        super.onPause();
        mHandler.removeMessages(NEXTIMAGE);
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
        // 轮播图滑动监听，控制小圆点
        carousel_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationBar.setCurrentPosition(carousel_vp.getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.what) {
            case NEXTIMAGE:
                //控制轮播图位置
                carousel_vp.setCurrentItem(carousel_vp.getCurrentItem() + 1);
                //设置小圆点位置
                navigationBar.setCurrentPosition(carousel_vp.getCurrentItem());
                mHandler.sendEmptyMessageDelayed(NEXTIMAGE, CAROUSEL_DELAY_TIME);
                break;
        }
        return false;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search_home:
                startActivity(OPACActivity.getOpacIntent(getContext()));
                break;
            case R.id.btn_recommend_home:
                startActivity(RecommendActivity.getRecommendIntent(getContext()));
                break;
            case R.id.btn_borrowlist_home:
                startActivity(BorrowListActivity.getBorrowListIntent(getContext()));
                break;
            case R.id.btn_rq_home:
                startActivity(new Intent(getContext(), RQActivity.class));
                break;
            case R.id.btn_readerinfo_home:
                startActivity(ReaderInfoActivity.getReaderInfoIntent(getContext()));
                break;
            case R.id.btn_shelf_home:
                startActivity(EbookShelfActivity.getShelfIntent(getContext()));
                break;
            case R.id.btn_borrowing_home:
                startActivity(BorrowingActivity.getBorrowingIntent(getContext()));
                break;
            case R.id.btn_history_home:
                startActivity(HistoryActivity.getHistoryIntent(getContext()));
                break;
        }
    }

}
