package com.hebth.mobilelibrary.ui.main.fragments.library;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.MarkerOptions;
import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.base.AppConstant;
import com.hebth.mobilelibrary.beans.LibraryBean;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.lilbrarydetail.LibraryDetailActivity;
import com.hebth.mobilelibrary.utils.ToastUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by hebth on 2017-06-08.
 * 图书馆须知的Fragment，用于展示功能区按钮 和 地图导航，点击进入相应功能
 */

public class LibraryFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = LibraryFragment.class.getName();

    private ImageView abstract_iv;
    private ImageView guide_iv;
    private ImageView notice_iv;
    private ImageView time_iv;
    private ImageView location_iv;
    //地图
    private MapView mMap;
    //网络请求
    private Callback.Cancelable post;
    //地图对象
    private AMap aMap;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_library;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //
        abstract_iv = (ImageView) mView.findViewById(R.id.iv_abstract_library);
        guide_iv = (ImageView) mView.findViewById(R.id.iv_guide_library);
        notice_iv = (ImageView) mView.findViewById(R.id.iv_notice_library);
        time_iv = (ImageView) mView.findViewById(R.id.iv_time_library);
        location_iv = (ImageView) mView.findViewById(R.id.iv_location_library);
        //创建地图
        mMap = (MapView) mView.findViewById(R.id.map_library);

        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMap.onCreate(savedInstanceState);
        //初始化地图控制器对象
        if (aMap == null) {
            aMap = mMap.getMap();
            //定位点
            aMap.addMarker(new MarkerOptions().position(AppConstant.centerLatLng).title("河北省图书馆").snippet("为您服务"));
            //
            UiSettings uiSettings = aMap.getUiSettings();
            //设置放大缩小按钮隐藏
            uiSettings.setZoomControlsEnabled(false);
            setLocation();
        }
    }

    /**
     * 设置地图中心点
     */
    private void setLocation() {
        //设置中心点和缩放比例
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(AppConstant.centerLatLng));
        aMap.moveCamera(CameraUpdateFactory.zoomTo(16));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMap.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMap.onSaveInstanceState(outState);
    }

    @Override
    public void initListener() {
        abstract_iv.setOnClickListener(this);
        guide_iv.setOnClickListener(this);
        notice_iv.setOnClickListener(this);
        time_iv.setOnClickListener(this);
        location_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_abstract_library:
                getDateFromNet(LibraryDetailActivity.ABSTRACT);
                break;
            case R.id.iv_guide_library:
                getDateFromNet(LibraryDetailActivity.GUIDE);
                break;
            case R.id.iv_notice_library:
                getDateFromNet(LibraryDetailActivity.NOTICE);
                break;
            case R.id.iv_time_library:
                getDateFromNet(LibraryDetailActivity.TIME);
                break;
            case R.id.iv_location_library:
                setLocation();
                break;
        }
    }

    public void getDateFromNet(final int type) {

        showDialog(getActivity(), "加载中..");

        RequestParams entity = new RequestParams(AppConstant.HOST + "/" + AppConstant.LIBRARY_PATH);

        post = x.http().post(entity, new Callback.CommonCallback<LibraryBean>() {
            @Override
            public void onSuccess(LibraryBean result) {
                startActivity(LibraryDetailActivity.getLibraryDetailIntent(getContext(), type, result));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ToastUtils.showText(getContext(), "网络异常..");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                hideDialog();
            }
        });
    }


    /**
     * 显示加载动画
     */
    public void showDialog(final Activity activity, String str) {
    }

    /**
     * 隐藏加载动画
     */
    public void hideDialog() {
        post.cancel();
    }

}
