package com.hebth.mobilelibrary.ui.ebookshelf;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.EBookBean;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ShelfRvAdapter;
import com.hebth.mobilelibrary.utils.FileUtils;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.xutils.view.annotation.ViewInject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.hebth.mobilelibrary.ui.ebookdetail.view.EBookDetailActivity.GALLERY_REQUEST;

public class EbookShelfActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    @ViewInject(R.id.srl_shelf)
    private SwipeRefreshLayout mRefresh;
    @ViewInject(R.id.recycler_shelf)
    private RecyclerView mRecycler;
    //
    private ShelfRvAdapter adapter;
    //
    List<EBookBean> mList = new ArrayList<>();
    //权限列表
    public static final String[] WRITE_EXTERNAL_STORAGE_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static Intent getShelfIntent(Context context) {
        return new Intent(context, EbookShelfActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_ebook_shelf;
    }

    @Override
    public void initView() {
        //
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_shelf);
        mToolBar.setTitle("我的书架");
        mToolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.mipmap.btn_back);
        //
        GridLayoutManager layout = new GridLayoutManager(
                this, 3, GridLayoutManager.VERTICAL, false);

        mRecycler.setLayoutManager(layout);
        adapter = new ShelfRvAdapter(this, null);
        mRecycler.setAdapter(adapter);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, WRITE_EXTERNAL_STORAGE_PERMS, GALLERY_REQUEST);
        } else {
            //// TODO: 2017-06-20 files为0 使用存储空间的权限
            getLocalBooks();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home==item.getItemId()) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     *
     */


    @Override
    public void initListener() {
        mRefresh.setOnRefreshListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (grantResults != null && grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //执行授权之后的代码
                    getLocalBooks();
                } else {
                    ToastUtils.showText(this, "您未授予访问本地存储空间的权限，书架功能受限..");
                }
                break;
        }
    }

    /**
     * 加载本地的图书
     */
    private void getLocalBooks() {

        String[] files = FileUtils.getFiles(FileUtils.EBOOK);
        mList.clear();
        for (int i = 0; i < files.length; i++) {
            EBookBean bean = new EBookBean();
            String bookName = files[i].substring(0, files[i].lastIndexOf("."));
            bean.setBookCover(FileUtils.COVER_PATH + File.separator + bookName + ".jpg");
            Logger.e(bookName);
            bean.setBookName(bookName);
            bean.setBookPath(FileUtils.EBOOK_PATH + File.separator + files[i]);
            mList.add(bean);
        }
        adapter.refreshData(mList);
        mRefresh.setRefreshing(false);
    }


    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        getLocalBooks();
    }


}
