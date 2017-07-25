package com.hebth.mobilelibrary.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.hebth.mobilelibrary.ui.main.fragments.home.net.NewsParser;

import org.xutils.http.annotation.HttpResponse;

import java.io.Serializable;

/**
 * Created by hebth on 2017-06-13.
 * 通知公告的实体类
 */
@HttpResponse(parser = NewsParser.class)
public class NewsBean implements Parcelable {

    /**
     * SchoolID : 1110
     * QUserName : sjzts
     * QNickName : 石家庄市第十二中学
     * QTitle : 闭馆通知
     * QContent : 由于图书馆内容整体，新馆需闭馆一天
     * AddTime : 2017/5/5 14:43:18
     * ModifyTime : 2017/5/5 14:43:18
     * QType : 1
     */

    private int SchoolID;
    private String QUserName;
    private String QNickName;
    private String QTitle;
    private String QContent;
    private String AddTime;
    private String ModifyTime;
    private int QType;

    public int getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(int SchoolID) {
        this.SchoolID = SchoolID;
    }

    public String getQUserName() {
        return QUserName;
    }

    public void setQUserName(String QUserName) {
        this.QUserName = QUserName;
    }

    public String getQNickName() {
        return QNickName;
    }

    public void setQNickName(String QNickName) {
        this.QNickName = QNickName;
    }

    public String getQTitle() {
        return QTitle;
    }

    public void setQTitle(String QTitle) {
        this.QTitle = QTitle;
    }

    public String getQContent() {
        return QContent;
    }

    public void setQContent(String QContent) {
        this.QContent = QContent;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String AddTime) {
        this.AddTime = AddTime;
    }

    public String getModifyTime() {
        return ModifyTime;
    }

    public void setModifyTime(String ModifyTime) {
        this.ModifyTime = ModifyTime;
    }

    public int getQType() {
        return QType;
    }

    public void setQType(int QType) {
        this.QType = QType;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "SchoolID=" + SchoolID +
                ", QUserName='" + QUserName + '\'' +
                ", QNickName='" + QNickName + '\'' +
                ", QTitle='" + QTitle + '\'' +
                ", QContent='" + QContent + '\'' +
                ", AddTime='" + AddTime + '\'' +
                ", ModifyTime='" + ModifyTime + '\'' +
                ", QType=" + QType +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.SchoolID);
        dest.writeString(this.QUserName);
        dest.writeString(this.QNickName);
        dest.writeString(this.QTitle);
        dest.writeString(this.QContent);
        dest.writeString(this.AddTime);
        dest.writeString(this.ModifyTime);
        dest.writeInt(this.QType);
    }

    public NewsBean() {
    }

    protected NewsBean(Parcel in) {
        this.SchoolID = in.readInt();
        this.QUserName = in.readString();
        this.QNickName = in.readString();
        this.QTitle = in.readString();
        this.QContent = in.readString();
        this.AddTime = in.readString();
        this.ModifyTime = in.readString();
        this.QType = in.readInt();
    }

    public static final Parcelable.Creator<NewsBean> CREATOR = new Parcelable.Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel source) {
            return new NewsBean(source);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };
}
