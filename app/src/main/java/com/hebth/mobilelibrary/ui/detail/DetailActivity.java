package com.hebth.mobilelibrary.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;

public class DetailActivity extends BaseActivity {

    private FloatingActionButton fab;

    public static Intent getDetailActivity(Context context,String bookId){
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra("bookId",bookId);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_detail;
    }

    @Override
    public void initView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        String bookId = getIntent().getStringExtra("bookId");

        Log.e(TAG, "接收到bookId： "+bookId );

    }

    @Override
    public void initListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
