package com.hebth.mobilelibrary.ui.detail.model;

import com.hebth.mobilelibrary.ui.base.BaseModel;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的Model接口
 */

public interface IDetailModel extends BaseModel {

    //加载数据
    void loadData(String bookId, OnDetailListener listener);

    //下载文件
    void downLoadFile(String downloadUrl, String fileName, OnDownLoadListener listener);

    //获取阅读进度
    void getRecord(String cardNum, String bookId,OnRecordListener listener);
}
