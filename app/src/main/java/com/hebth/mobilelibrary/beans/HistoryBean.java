package com.hebth.mobilelibrary.beans;

import com.hebth.mobilelibrary.ui.history.net.HistoryParser;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by hebth on 2017-07-27.
 * 历史借阅的实体类
 */
@HttpResponse(parser = HistoryParser.class)
public class HistoryBean {

    /**
     * Bookid : 342889
     * Barcode : 28215
     * Bookname : 话说中国千古风云－三国两晋南北朝
     * Borrowtime : 2017/7/5 15:53:20
     * Actualtime : 2017/7/5 15:53:26
     * Schoolid : 1110
     */

    private String Bookid;
    private String Barcode;
    private String Bookname;
    private String Borrowtime;
    private String Actualtime;
    private String Schoolid;

    public String getBookid() {
        return Bookid;
    }

    public void setBookid(String Bookid) {
        this.Bookid = Bookid;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String Bookname) {
        this.Bookname = Bookname;
    }

    public String getBorrowtime() {
        return Borrowtime;
    }

    public void setBorrowtime(String Borrowtime) {
        this.Borrowtime = Borrowtime;
    }

    public String getActualtime() {
        return Actualtime;
    }

    public void setActualtime(String Actualtime) {
        this.Actualtime = Actualtime;
    }

    public String getSchoolid() {
        return Schoolid;
    }

    public void setSchoolid(String Schoolid) {
        this.Schoolid = Schoolid;
    }
}
