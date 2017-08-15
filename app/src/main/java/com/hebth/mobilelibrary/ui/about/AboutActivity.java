package com.hebth.mobilelibrary.ui.about;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;

/**
 * 关于我们
 * 
 */
public class AboutActivity extends BaseActivity {

    public static Intent getAboutIntent(Context context) {
        return new Intent(context, AboutActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
        toolbar.setTitle("关于我们");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(toolbar);
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
