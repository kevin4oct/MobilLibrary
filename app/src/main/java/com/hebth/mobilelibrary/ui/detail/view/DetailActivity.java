package com.hebth.mobilelibrary.ui.detail.view;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.myview.MyProgressDialog;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.detail.presenter.DetailPresenter;
import com.hebth.mobilelibrary.utils.FileUtils;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

public class DetailActivity extends BaseActivity implements IDetailView {
    public static final String TAG = DetailActivity.class.getSimpleName();
    public static final int GALLERY_REQUEST = 0x300;

    @ViewInject(R.id.iv_cover_bookdetail)
    private ImageView cover_iv;
    @ViewInject(R.id.tv_bookname_bookdetail)
    private TextView bookName_tv;
    @ViewInject(R.id.tv_press_bookdetail)
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
    private String downloadPath;
    private long fileSize;
    private String filePath;
    private String fileName;
    private long mTaskId;
    //
    private DetailPresenter mPresenter = new DetailPresenter(this);
    //
    public static final String[] WRITE_EXTERNAL_STORAGE_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private DownloadManager downloadManager;


    public static Intent getDetailActivity(Context context, String bookId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("bookId", bookId);
        return intent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_detail;
    }

    @Override
    public void initView() {

        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar_detail);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("图书详情");
        setSupportActionBar(mToolBar);

        bookId = getIntent().getStringExtra("bookId");
        Log.e(TAG, "接收到bookId： " + bookId);

        if (!FileUtils.getFiles(fileName)) {//判断本地是否有该书,如果没有进行下载

            Log.e(TAG, "downLoadBook: 未找到该书");

            mPresenter.loadData();

        } else {//判断本地是否有该书,如果已经存在，获取阅读进度，直接打开
            // TODO: 2017-06-16 获取阅读

        }

//        //注册广播接收者，监听下载状态
//        registerReceiver(receiver,
//                new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(receiver);
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
        Picasso.with(this).load(imagePath).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).into(cover_iv);
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

    /**
     * 开始阅读按钮点击事件
     *
     * @param view
     */
    @Event(R.id.btn_read_bookdetail)
    private void readBtnClick(View view) {
        if (ContextCompat.checkSelfPermission(DetailActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DetailActivity.this, WRITE_EXTERNAL_STORAGE_PERMS, GALLERY_REQUEST);
        } else {

//            //openEpub(FolioActivity.EpubSourceType.ASSESTS,"PhysicsSyllabus.epub",0);
//            openEpub(FolioActivity.EpubSourceType.ASSESTS, "The Silver Chair.epub", 0);
            mPresenter.downLoadBook();
        }

//        Intent intent = new Intent(DetailActivity.this, FolioActivity.class);
//        intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_TYPE, FolioActivity.EpubSourceType.ASSESTS);
//        intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, "ebook.epub");
//        startActivity(intent);
    }

//    private void openEpub(FolioActivity.EpubSourceType sourceType, String path, int rawID) {
//        Intent intent = new Intent(DetailActivity.this, FolioActivity.class);
//        if (rawID != 0) {
//            intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, rawID);
//        } else {
//            intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, path);
//        }
//        intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_TYPE, sourceType);
//        startActivity(intent);
//    }

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

//    //广播接受者，接收下载状态
//    private BroadcastReceiver receiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            Logger.e("mTaskId:" + DetailModel.mTaskId);
////            checkDownloadStatus();//检查下载状态
//        }
//    };

//    //检查下载状态
//    private void checkDownloadStatus() {
//        DownloadManager.Query query = new DownloadManager.Query();
//        query.setFilterById(DetailModel.mTaskId);//筛选下载任务，传入任务ID，可变参数
//        Cursor c = downloadManager.query(query);
//        if (c.moveToFirst()) {
//            int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
//            switch (status) {
//                case DownloadManager.STATUS_PAUSED:
//                    Logger.i(">>>下载暂停");
//                    break;
//                case DownloadManager.STATUS_PENDING:
//                    Logger.i(">>>下载延迟");
//                    break;
//                case DownloadManager.STATUS_RUNNING:
//                    Logger.i(">>>正在下载");
//                    break;
//                case DownloadManager.STATUS_SUCCESSFUL:
//                    Logger.i(">>>下载完成");
//                    //下载完成安装APK
//                    //downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + versionName;
////                    installAPK(new File(downloadPath));
//                    //todo 打开SD卡内的文件
////                    openEpub(FolioActivity.EpubSourceType.ASSESTS, "ebook.epub", 0);
//
//                    stopLoading();
//                    Logger.e("下载完成..");
//
//                    break;
//                case DownloadManager.STATUS_FAILED:
//                    Logger.i(">>>下载失败");
//                    break;
//            }
//        }
//    }

}
