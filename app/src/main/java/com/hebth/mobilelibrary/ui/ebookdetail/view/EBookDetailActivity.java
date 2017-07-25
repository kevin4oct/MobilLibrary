package com.hebth.mobilelibrary.ui.ebookdetail.view;

import android.Manifest;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.folioreader.activity.FolioActivity;
import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.myview.MyProgressDialog;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.ebookdetail.presenter.DetailPresenter;
import com.hebth.mobilelibrary.utils.FileUtils;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.io.File;

public class EBookDetailActivity extends BaseActivity implements IDetailView {
    public static final String TAG = EBookDetailActivity.class.getSimpleName();
    public static final int GALLERY_REQUEST = 0x300;

    @ViewInject(R.id.iv_cover_bookdetail)
    private ImageView cover_iv;
    @ViewInject(R.id.tv_bookname_bookdetail)
    private TextView bookName_tv;
    @ViewInject(R.id.tv_bookauthor_bookdetail)
    private TextView bookAuthor_tv;
    @ViewInject(R.id.tv_press_bookdetail)
    private TextView press_tv;
    //    @ViewInject(R.id.tv_publishdate_bookdetail)
    //    private TextView publishDate_tv;
    @ViewInject(R.id.tv_isbn_bookdetail)
    private TextView isbn_tv;
    //    @ViewInject(R.id.tv_bookprice_bookdetail)
    //    private TextView bookPrice_tv;
    @ViewInject(R.id.tv_fileext_bookdetail)
    private TextView filtExt_tv;
    @ViewInject(R.id.tv_description_bookdetail)
    private TextView description_tv;
    @ViewInject(R.id.tv_tablecontent_bookdetail)
    private TextView tableContent_tv;
    //
    private MyProgressDialog dialog;
    //
    private String bookId;
    //    private String downloadPath;
    private long fileSize;//电子书文件大小
    private String filePath;//电子书url
    private String fileName;//电子书名称（带后缀名）
    private String bookCover;//电子书封面url
    private long mTaskId;//电子书下载任务ID
    private long bookRecord;
    //
    private DetailPresenter mPresenter = new DetailPresenter(this);
    //权限列表
    public static final String[] WRITE_EXTERNAL_STORAGE_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private DownloadManager downloadManager;

    public static Intent getDetailActivity(Context context, String bookId) {
        Intent intent = new Intent(context, EBookDetailActivity.class);
        intent.putExtra("bookId", bookId);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_ebookdetail;
    }

    @Override
    public void initView() {

        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_detail);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("图书详情");
        mToolBar.setNavigationIcon(R.mipmap.btn_back);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bookId = getIntent().getStringExtra("bookId");
        Logger.e(TAG, "接收到bookId： " + bookId);

        //加载图书详细数据
        mPresenter.loadData();

        //注册广播接收者，监听下载状态
        registerReceiver(receiver,
                new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
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

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    @Override
    public void showLoading(String title) {
        dialog = MyProgressDialog.show(this, "正在加载，请稍后..", false, null);
    }

    @Override
    public void stopLoading() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void showErrorTip(String msg) {
        ToastUtils.showText(this, msg);
    }

    @Override
    public String getBookId() {
        return bookId;
    }

    @Override
    public void setBookCover(String imagePath) {
        Picasso.with(this).load(imagePath).placeholder(R.mipmap.temp_ebook)
                .error(R.mipmap.temp_ebook).into(cover_iv);
    }

    @Override
    public void setBookName(String bookName) {
        bookName_tv.setText(bookName);
    }

    @Override
    public void setBookAuthor(String booklAuthor) {
        bookAuthor_tv.setText(booklAuthor);
    }

    @Override
    public void setPress(String press) {
        press_tv.setText(press);
    }

    @Override
    public void setPublishDate(String publishDate) {
//        publishDate_tv.setText(publishDate);
    }

    @Override
    public void setIsbn(String isbn) {
        isbn_tv.setText(isbn);
    }

    @Override
    public void setbookPrice(String bookPrice) {
//        bookPrice_tv.setText(bookPrice);
    }

    @Override
    public void setFileExt(String fileExt) {
        filtExt_tv.setText(fileExt);
    }

    @Override
    public void setDescription(String description) {
        description_tv.setText(description);
    }

    @Override
    public void setTableContent(String tableContent) {
        tableContent_tv.setText(tableContent);
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

    @Override
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getCover() {
        return bookCover;
    }

    @Override
    public void setCover(String bookCover) {
        this.bookCover = bookCover;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setTaskId(long taskId) {
        mTaskId = taskId;
    }

    @Override
    public long getBookRecord() {
        return bookRecord;
    }

    @Override
    public void setBookRecord(long bookRecord) {
        this.bookRecord = bookRecord;
    }

    /**
     * 开始阅读按钮点击事件
     *
     * @param view
     */
    @Event(R.id.btn_read_bookdetail)
    private void readBtnClick(View view) {
        if (ContextCompat.checkSelfPermission(EBookDetailActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EBookDetailActivity.this, WRITE_EXTERNAL_STORAGE_PERMS, GALLERY_REQUEST);
        } else {

            if (!FileUtils.isInclude(FileUtils.COVER, fileName)) {//判断本地是否有该书封面,如果没有进行下载
                mPresenter.downloadCover();

            }
            if (!FileUtils.isInclude(FileUtils.EBOOK, fileName)) {//判断本地是否有该书,如果没有进行下载

                Logger.e(TAG, "downLoadBook: 未找到该书");

                mPresenter.downLoadBook();

            } else {//判断本地是否有该书,如果已经存在，获取阅读进度，直接打开

                openEpub();
            }
        }
    }

    /**
     * 打开电子阅读
     */
    private void openEpub() {
        //// TODO: 2017-06-19 打开电子书到指定的位置
        String bookPath = FileUtils.EBOOK_PATH + File.separator + fileName;
        Intent intent = new Intent(EBookDetailActivity.this, FolioActivity.class);
        intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_TYPE, FolioActivity.EpubSourceType.SD_CARD);
        intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, bookPath);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (grantResults != null && grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mPresenter.downLoadBook();
                } else {
                    Toast.makeText(this, "不能开始阅读功能，该功能需要访问存储的权限!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //广播接受者，接收下载状态
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Logger.e("mTaskId:" + mTaskId + "，下载完成，这本书已经阅读到：" + bookRecord);
            //下载完成之后,打开文件
            openEpub();
        }
    };


}
