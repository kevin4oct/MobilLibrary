package com.hebth.mobilelibrary.ui.opac.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.opac.adapter.OpacVpAdapter;
import com.hebth.mobilelibrary.ui.opac.view.fragment.BorrowedListFragment;
import com.hebth.mobilelibrary.ui.opac.view.fragment.RecommendFragment;
import com.hebth.mobilelibrary.utils.ToastUtils;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

public class OPACActivity extends BaseActivity {

    @ViewInject(R.id.sp_class_opac)
    private Spinner mSpinner;
    @ViewInject(R.id.et_context_opac)
    private EditText mEt;
    @ViewInject(R.id.tab_opac)
    private TabLayout mTab;
    @ViewInject(R.id.vp_opac)
    private ViewPager mViewpager;

    private String category;

    public static Intent getOpacIntent(Context context) {
        Intent intent = new Intent(context, OPACActivity.class);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_opac;
    }

    @Override
    public void initView() {
        //
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_opac);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("馆藏查询");
        mToolBar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_spinner_opac,
                getResources().getStringArray(R.array.spinner_opac));
        mSpinner.setAdapter(adapter);
        ArrayList<Fragment> mList = new ArrayList<>();
        mList.add(new RecommendFragment());
        mList.add(new BorrowedListFragment());
        OpacVpAdapter vpAdapter = new OpacVpAdapter(getSupportFragmentManager(), mList);
        mViewpager.setAdapter(vpAdapter);
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mTab.setupWithViewPager(mViewpager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initListener() {
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = getResources().getStringArray(R.array.spinner_opac)[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Event(R.id.btn_search_opac)
    private void searchBtn(View v) {
        String categoryValue = mEt.getText().toString();
        if ("".equals(categoryValue)) {
            ToastUtils.showText(this, "请输入检索内容..");
            return;
        }
        startActivity(OPACListActivity.getOPACListIntent(this, category, categoryValue));
    }


}
