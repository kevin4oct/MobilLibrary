package com.hebth.mobilelibrary.ui.detail.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.myview.MyProgressDialog;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.detail.presenter.DetailPresenter;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

public class DetailActivity extends BaseActivity implements IDetailView {

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
    //
    private DetailPresenter mPresenter = new DetailPresenter(this);


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
        bookId = getIntent().getStringExtra("bookId");
        Log.e(TAG, "接收到bookId： " + bookId);

        mPresenter.loadData();
    }

    @Override
    public void initListener() {

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

    /**
     * 开始阅读按钮点击事件
     * @param view
     */
    @Event(R.id.btn_read_bookdetail)
    private void readBtnClick(View view){

    }
}
