package com.hebth.mobilelibrary.ui.newsdetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.NewsBean;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.orhanobut.logger.Logger;

import org.xutils.view.annotation.ViewInject;

public class NewsDetailActivity extends BaseActivity {

    @ViewInject(R.id.tv_content_news)
    private TextView content_tv;

    public static Intent getNewsDetailIntent(Context context, NewsBean bean) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("newsBean", bean);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initView() {
        NewsBean bean = (NewsBean) getIntent().getParcelableExtra("newsBean");
        //
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_newsdetail);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setNavigationIcon(R.mipmap.btn_back);
        mToolBar.setTitle(bean.getQTitle());
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        content_tv.setText(bean.getQContent());
    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
