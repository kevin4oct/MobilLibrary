package com.hebth.mobilelibrary.ui.detail.presenter;

import android.os.Environment;
import android.util.Log;

import com.hebth.mobilelibrary.base.AppConstant;
import com.hebth.mobilelibrary.ui.detail.bean.BookDetailBean;
import com.hebth.mobilelibrary.ui.detail.model.DetailModel;
import com.hebth.mobilelibrary.ui.detail.model.IDetailModel;
import com.hebth.mobilelibrary.ui.detail.model.OnDetailListener;
import com.hebth.mobilelibrary.ui.detail.model.OnDownLoadListener;
import com.hebth.mobilelibrary.ui.detail.view.IDetailView;
import com.hebth.mobilelibrary.utils.DateUtils;
import com.hebth.mobilelibrary.utils.FileUtils;
import com.orhanobut.logger.Logger;

import java.text.ParseException;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的主导器
 */

public class DetailPresenter {
    public static final String TAG = DetailPresenter.class.getSimpleName();

    private IDetailModel mModel;
    private IDetailView mView;

    public DetailPresenter(IDetailView mView) {
        this.mModel = new DetailModel();
        this.mView = mView;
    }

    /**
     * 加载数据
     */
    public void loadData() {
        mView.showLoading("");
        mModel.loadData(mView.getBookId(), new OnDetailListener() {
            @Override
            public void success(BookDetailBean bean) {
                BookDetailBean.Data1Bean data1Bean = bean.getData1();


                mView.setBookCover(AppConstant.RESOURCESTR
                        + data1Bean.getBookPictures().get(0).getFilePath());
                //书名
                mView.setBookName(data1Bean.getBookName());
                //作者
                mView.setBookAuthor("作者：" + data1Bean.getBookAuthor());
                //出版社
                mView.setPress("出版社：" + data1Bean.getPress());
                //出版时间
                long publishDate = data1Bean.getPublishDate();
                try {
                    mView.setPublishDate("出版时间：" + DateUtils.longToString(publishDate, "yyyy-MM-dd"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    mView.setPublishDate("出版时间：2010-01-01");
                }
                //ISBN
                mView.setIsbn("ISBN：" + data1Bean.getIsbn());
                //定价
                mView.setbookPrice("定价：" + String.valueOf(data1Bean.getBookPrice()));
                //内容简介
                mView.setDescription(data1Bean.getDescription());
                BookDetailBean.Data1Bean.BookFilesBean bookFilesBean = data1Bean.getBookFiles().get(0);
                //文件格式
                String fileExt = bookFilesBean.getFileExt();
                mView.setFileExt("文件格式：" + fileExt);
                //数目详情
                mView.setTableContent(bookFilesBean.getTableContent());
                //文件大小
                mView.setFileSize(bookFilesBean.getFileSize());
                //文件下载路径
                String filePath = bookFilesBean.getFilePath();
                mView.setFilePath(AppConstant.RESOURCESTR + filePath);
                //文件名称
                mView.setFileName(data1Bean.getBookName() + "." + fileExt);
                //
                mView.stopLoading();
            }

            @Override
            public void failed(String info) {
                mView.stopLoading();
                mView.showErrorTip(info);
            }
        });
    }

    /**
     * 点击阅读执行的功能
     */
    public void downLoadBook() {
        mView.showLoading("");

        if (Environment.MEDIA_MOUNTED.equals(FileUtils.SDCARDSTATE)) {//判断存储卡状态，如果正常
            Log.e(TAG, "downLoadBook: 卡状态正常");
            if (FileUtils.getSDAvailableSize() > mView.getFileSize()) {//判断存储空间，如果够用
                Log.e(TAG, "downLoadBook: 卡空间正常");
                mModel.downLoadFile(mView.getFilePath(), mView.getFileName(),
                        new OnDownLoadListener() {//下载文件
                            @Override
                            public void success(long taskId, String filePath) {//下载成功

                                mView.setTaskId(taskId);
                                Logger.e("成功的下载了..taskId:" + taskId);
                                mView.stopLoading();

                            }

                            @Override
                            public void failed(String info) {//下载失败
                                //提示下载失败
                                Logger.e("下载失败..");
                                mView.stopLoading();
                            }
                        });
            } else {
                mView.showErrorTip("存储空间不足，加载失败..");
                mView.stopLoading();
            }
        } else {
            mView.showErrorTip("发生存储状态错误，请检查存储状态..");
            mView.stopLoading();
        }


    }

    /**
     * 获取阅读的进度
     *
     * @param FileName
     */
    public int readRecord(String FileName) {

        return 12;
    }
}
