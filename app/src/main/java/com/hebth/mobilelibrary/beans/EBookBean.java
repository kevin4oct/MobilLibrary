package com.hebth.mobilelibrary.beans;

/**
 * Created by hebth on 2017-06-20.
 * 本地存储的电子书的实体类
 */

public class EBookBean {

    private String bookCover;

    private String bookName;

    private String bookPath;

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }
}
