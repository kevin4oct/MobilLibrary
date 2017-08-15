package com.hebth.mobilelibrary.beans;

import com.hebth.mobilelibrary.ui.borrowing.net.BorrowingParser;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by hebth on 2017-07-27.
 * 正在借阅的实体类
 */
@HttpResponse(parser = BorrowingParser.class)
public class BorrowingBean {
    /**
     * BarCode : 26859
     * BorrowTime : 2017/7/21 11:01:26
     * GiveBackTime : 2017/9/19 0:00:00
     * BookName : 中国古典四大名著三国演义
     * BookID : 342765
     * Renewal : 0
     * IsComment : 0
     */

    private String BarCode;
    private String BorrowTime;
    private String GiveBackTime;
    private String BookName;
    private String BookID;
    private String Renewal;
    private String IsComment;

    public String getBarCode() {
        return BarCode;
    }

    public void setBarCode(String BarCode) {
        this.BarCode = BarCode;
    }

    public String getBorrowTime() {
        return BorrowTime;
    }

    public void setBorrowTime(String BorrowTime) {
        this.BorrowTime = BorrowTime;
    }

    public String getGiveBackTime() {
        return GiveBackTime;
    }

    public void setGiveBackTime(String GiveBackTime) {
        this.GiveBackTime = GiveBackTime;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getRenewal() {
        return Renewal;
    }

    public void setRenewal(String Renewal) {
        this.Renewal = Renewal;
    }

    public String getIsComment() {
        return IsComment;
    }

    public void setIsComment(String IsComment) {
        this.IsComment = IsComment;
    }

    @Override
    public String toString() {
        return "BorrowingBean{" +
                "BarCode='" + BarCode + '\'' +
                ", BorrowTime='" + BorrowTime + '\'' +
                ", GiveBackTime='" + GiveBackTime + '\'' +
                ", BookName='" + BookName + '\'' +
                ", BookID='" + BookID + '\'' +
                ", Renewal='" + Renewal + '\'' +
                ", IsComment='" + IsComment + '\'' +
                '}';
    }
}
