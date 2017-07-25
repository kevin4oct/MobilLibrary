package com.hebth.mobilelibrary.ui.ebookdetail.model;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.hebth.mobilelibrary.MyApplication;
import com.hebth.mobilelibrary.ui.ebookdetail.bean.BookDetailBean;
import com.hebth.mobilelibrary.ui.ebookdetail.net.DetailRequest;
import com.hebth.mobilelibrary.utils.FileUtils;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.x;

import java.io.File;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的Model类
 */

public class DetailModel implements IDetailModel {
    public static final String TAG = DetailModel.class.getSimpleName();
    public static long mTaskId;

    /**
     * 加载数据
     *
     * @param bookId
     * @param listener
     */
    @Override
    public void loadData(String bookId, final OnDetailListener listener) {

        DetailRequest request = new DetailRequest();
        request.addQueryStringParameter("bookId", bookId);

        x.http().get(request, new Callback.CommonCallback<BookDetailBean>() {
            @Override
            public void onSuccess(BookDetailBean result) {
                if (result != null) {
                    listener.success(result);
                } else {
                    listener.failed("网络请求失败，请重试..");
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.e(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 下载电子书文件
     *
     * @param downloadUrl
     */
    @Override
    public void downLoadFile(String downloadUrl, String fileName, OnDownLoadListener listener) {

        Logger.e("开始下载,downloadUrl:" + downloadUrl + ",,,,fileName:" + fileName);

        //创建下载任务
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        request.setAllowedOverRoaming(false);

//        //设置文件类型，可以在下载结束后自动打开该文件
//        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(downloadUrl));
//        request.setMimeType(mimeString);

        //在通知栏中显示，默认就是显示的
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setVisibleInDownloadsUi(true);

        //sdcard的目录下的download文件夹，必须设置
        request.setDestinationInExternalFilesDir(MyApplication.getContext(),
                Environment.DIRECTORY_DOCUMENTS + File.separator + "ebooks", fileName);//也可以自己制定下载路径

        //将下载请求加入下载队列
        DownloadManager downloadManager = (DownloadManager) MyApplication.getContext()
                .getSystemService(Context.DOWNLOAD_SERVICE);

        //加入下载队列后会给该任务返回一个long型的id，
        //通过该id可以取消任务，重启任务等等，看上面源码中框起来的方法
        mTaskId = downloadManager.enqueue(request);

        listener.success(mTaskId, "");
    }

    /**
     * 下载电子书封面
     * @param downloadUrl
     * @param fileName
     * @param listener
     */
    @Override
    public void downLoadCover(String downloadUrl, String fileName, OnDownLoadListener listener) {

        Logger.e("开始下载封面,downloadUrl:" + downloadUrl + ",,,,fileName:" + fileName);

        //创建下载任务
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        request.setAllowedOverRoaming(false);

//        //设置文件类型，可以在下载结束后自动打开该文件
//        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(downloadUrl));
//        request.setMimeType(mimeString);

        //在通知栏中显示，默认就是显示的
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setVisibleInDownloadsUi(true);

        //sdcard的目录下的download文件夹，必须设置
        request.setDestinationInExternalFilesDir(MyApplication.getContext(),
                Environment.DIRECTORY_DOCUMENTS + File.separator + "cover", fileName.substring(0,fileName.lastIndexOf("."))+".jpg");//也可以自己制定下载路径

        //将下载请求加入下载队列
        DownloadManager downloadManager = (DownloadManager) MyApplication.getContext()
                .getSystemService(Context.DOWNLOAD_SERVICE);

        //加入下载队列后会给该任务返回一个long型的id，
        //通过该id可以取消任务，重启任务等等，看上面源码中框起来的方法
        mTaskId = downloadManager.enqueue(request);

        listener.success(mTaskId, "");
    }


}
