package com.hebth.mobilelibrary.ui.ebookdetail.view;

import com.hebth.mobilelibrary.ui.base.BaseView;

/**
 * Created by hebth on 2017-06-14.
 * 图书详情的view接口
 */

public interface IDetailView extends BaseView {

    String getBookId();

    void setBookCover(String imagePath);

    void setBookName(String bookName);

    void setBookAuthor(String booklAuthor);

    void setPress(String press);

    void setPublishDate(String publishDate);

    void setIsbn(String isbn);

    void setbookPrice(String bookPrice);

    void setFileExt(String fileExt);

    void setDescription(String description);

    void setTableContent(String tableContent);

    long getFileSize();

    void setFileSize(long fileSize);

    String getFilePath();

    void setFilePath(String filePath);

    String getCover();

    void setCover(String bookCover);

    String getFileName();

    void setFileName(String fileName);

    void setTaskId(long taskId);

    long getBookRecord();

    void setBookRecord(long bookRecord);
}
