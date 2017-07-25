package com.hebth.mobilelibrary.ui.main.fragments.ebook.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.beans.EBookBean;
import com.hebth.mobilelibrary.ui.base.BaseFragment;
import com.hebth.mobilelibrary.ui.main.fragments.ebook.adapter.ShelfRvAdapter;
import com.hebth.mobilelibrary.utils.FileUtils;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.hebth.mobilelibrary.ui.ebookdetail.view.EBookDetailActivity.GALLERY_REQUEST;

/**
 * Created by hebth on 2017-06-09.
 * 书城Fragment，用于展示
 */

public class ShelfFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefresh;
    private RecyclerView mRecycler;
    private ShelfRvAdapter adapter;
    List<EBookBean> mList = new ArrayList<>();

    //权限列表
    public static final String[] WRITE_EXTERNAL_STORAGE_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_shelf;
    }

    @Override
    public void initView() {

        mRefresh = (SwipeRefreshLayout) mView.findViewById(R.id.srl_shelf);
        mRecycler = (RecyclerView) mView.findViewById(R.id.recycler_shelf);

        GridLayoutManager layout = new GridLayoutManager(
                getContext(), 3, GridLayoutManager.VERTICAL, false);

        mRecycler.setLayoutManager(layout);
        adapter = new ShelfRvAdapter(getContext(), null);
        mRecycler.setAdapter(adapter);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), WRITE_EXTERNAL_STORAGE_PERMS, GALLERY_REQUEST);
        } else {
            //// TODO: 2017-06-20 files为0 使用存储空间的权限
            getLocalBooks();
        }
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
                    Toast.makeText(getContext(), "您未授予访问本地存储空间的权限，书架功能受限..",
                            Toast.LENGTH_SHORT).show();
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
            bean.setBookCover(FileUtils.COVER_PATH + File.separator + bookName+".jpg");
            Logger.e(bookName);
            bean.setBookName(bookName);
            bean.setBookPath(FileUtils.EBOOK_PATH + File.separator + files[i]);
            mList.add(bean);
        }
        adapter.refreshData(mList);
        mRefresh.setRefreshing(false);
    }

    @Override
    public void initListener() {
        mRefresh.setOnRefreshListener(this);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        getLocalBooks();
    }


}
