package com.hebth.mobilelibrary.ui.detail.presenter;

import com.hebth.mobilelibrary.base.AppConstant;
import com.hebth.mobilelibrary.ui.detail.bean.BookDetailBean;
import com.hebth.mobilelibrary.ui.detail.model.DetailModel;
import com.hebth.mobilelibrary.ui.detail.model.IDetailModel;
import com.hebth.mobilelibrary.ui.detail.model.OnDetailListener;
import com.hebth.mobilelibrary.ui.detail.view.IDetailView;
import com.hebth.mobilelibrary.utils.DateUtils;

import java.text.ParseException;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的主导器
 */

public class DetailPresenter {

    private IDetailModel mModel;
    private IDetailView mView;

    public DetailPresenter(IDetailView mView) {
        this.mModel = new DetailModel();
        this.mView = mView;
    }

    public void loadData() {
        mView.showLoading("");

        mModel.loadData(mView.getBookId(), new OnDetailListener() {
            @Override
            public void success(BookDetailBean bean) {
                BookDetailBean.Data1Bean data1Bean = bean.getData1();
                mView.setBookCover(AppConstant.RESOURCESTR
                        + data1Bean.getBookPictures().get(0).getFilePath());
                mView.setBookName(data1Bean.getBookName());
                mView.setBookAuthor("作者：" + data1Bean.getBookAuthor());
                mView.setPress("出版社：" + data1Bean.getPress());
                long publishDate = data1Bean.getPublishDate();

                try {
                    mView.setPublishDate("出版时间：" + DateUtils.longToString(publishDate, "YYYY-MM-dd"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    mView.setPublishDate("出版时间：2010-01-01");
                }

                mView.setIsbn("ISBN：" + data1Bean.getIsbn());
                mView.setbookPrice("定价：" + String.valueOf(data1Bean.getBookPrice()));
                mView.setFileExt("文件格式：" + data1Bean.getBookFiles().get(0).getFileExt());
                mView.setDescription(data1Bean.getDescription());
                mView.setTableContent(data1Bean.getBookFiles().get(0).getTableContent());
                mView.stopLoading();
            }

            @Override
            public void failed(String info) {
                mView.stopLoading();
                mView.showErrorTip(info);
            }
        });

    }
}
