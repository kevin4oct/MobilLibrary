package com.hebth.mobilelibrary.ui.lilbrarydetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.LibraryBean;
import com.hebth.mobilelibrary.ui.base.BaseActivity;

import org.xutils.view.annotation.ViewInject;

public class LibraryDetailActivity extends BaseActivity {

    public static final int ABSTRACT = 0x000;
    public static final int GUIDE = 0x001;
    public static final int NOTICE = 0x002;
    public static final int TIME = 0x003;

    @ViewInject(R.id.tv_content_librarydetail)
    private TextView container_tv;

    private LibraryBean bean;
    private int funType;

    private String title;
    private String contain;

    public static Intent getLibraryDetailIntent(Context context, int buttonId, LibraryBean bean) {
        Intent intent = new Intent(context, LibraryDetailActivity.class);
        intent.putExtra("funType", buttonId);
        intent.putExtra("bean", bean);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_library_detail;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        funType = intent.getIntExtra("funType", 0);
        bean = (LibraryBean) intent.getParcelableExtra("bean");
        //选择加载类型
        switch (funType) {
            case ABSTRACT:
                title = "本馆简介";
                contain = bean.getSchoolIntro();
                break;
            case GUIDE:
                title = "办证指南";
                contain = bean.getBorrowCard();
                break;
            case NOTICE:
                title = "读者须知";
                contain = bean.getSchoolRule();
                break;
            case TIME:
                title = "开馆时间";
                contain = bean.getWorkTime();
                break;
        }
        //设置标题
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_librarydetail);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(toolbar);
        //设置内容
        container_tv.setText(contain);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initListener() {

    }


}
