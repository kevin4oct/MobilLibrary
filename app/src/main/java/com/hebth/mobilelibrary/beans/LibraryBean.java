package com.hebth.mobilelibrary.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.hebth.mobilelibrary.ui.main.fragments.library.net.LibraryParser;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by hebth on 2017-07-26.
 * 图书馆指南的实体类
 */
@HttpResponse(parser = LibraryParser.class)
public class LibraryBean implements Parcelable {

    /**
     * ID : 0
     * SchoolIntro : 本馆成立于1949年,借阅图书、保存图书资料
     * IsOffline : 0
     * OfflineTime : 1899-12-31T00:00:00
     * SchoolLevel : 0
     * IsLock : 0
     * StartTime : 0001-01-01T00:00:00
     * EndTime : 0001-01-01T00:00:00
     * AddTime : 0001-01-01T00:00:00
     * SchoolParams : null
     * SchoolType : 0
     * SchoolID : 0
     * Address : null
     * Remark : null
     * SchoolName : 石家庄市第十二中学
     * Functions : null
     * SchoolRule : 图书馆规则制度
     * WebBottom : 河北天海网络工程有限公司 版权所有 2017
     * WorkTime : 早上九点开馆，晚上9点闭馆
     * BorrowCard : 借阅证办理须知
     * WebLogoUrl :
     * SchoolFolder : null
     * ProvinceID : 84
     * CityID : 0
     * CountyID : 0
     * ReaderCount : 0
     * BookCount : 0
     */

    private int ID;
    private String SchoolIntro;
    private int IsOffline;
    private String OfflineTime;
    private int SchoolLevel;
    private int IsLock;
    private String StartTime;
    private String EndTime;
    private String AddTime;
    private String SchoolParams;
    private int SchoolType;
    private int SchoolID;
    private String Address;
    private String Remark;
    private String SchoolName;
    private String Functions;
    private String SchoolRule;
    private String WebBottom;
    private String WorkTime;
    private String BorrowCard;
    private String WebLogoUrl;
    private String SchoolFolder;
    private int ProvinceID;
    private int CityID;
    private int CountyID;
    private int ReaderCount;
    private int BookCount;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSchoolIntro() {
        return SchoolIntro;
    }

    public void setSchoolIntro(String SchoolIntro) {
        this.SchoolIntro = SchoolIntro;
    }

    public int getIsOffline() {
        return IsOffline;
    }

    public void setIsOffline(int IsOffline) {
        this.IsOffline = IsOffline;
    }

    public String getOfflineTime() {
        return OfflineTime;
    }

    public void setOfflineTime(String OfflineTime) {
        this.OfflineTime = OfflineTime;
    }

    public int getSchoolLevel() {
        return SchoolLevel;
    }

    public void setSchoolLevel(int SchoolLevel) {
        this.SchoolLevel = SchoolLevel;
    }

    public int getIsLock() {
        return IsLock;
    }

    public void setIsLock(int IsLock) {
        this.IsLock = IsLock;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String AddTime) {
        this.AddTime = AddTime;
    }

    public String getSchoolParams() {
        return SchoolParams;
    }

    public void setSchoolParams(String SchoolParams) {
        this.SchoolParams = SchoolParams;
    }

    public int getSchoolType() {
        return SchoolType;
    }

    public void setSchoolType(int SchoolType) {
        this.SchoolType = SchoolType;
    }

    public int getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(int SchoolID) {
        this.SchoolID = SchoolID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String SchoolName) {
        this.SchoolName = SchoolName;
    }

    public String getFunctions() {
        return Functions;
    }

    public void setFunctions(String Functions) {
        this.Functions = Functions;
    }

    public String getSchoolRule() {
        return SchoolRule;
    }

    public void setSchoolRule(String SchoolRule) {
        this.SchoolRule = SchoolRule;
    }

    public String getWebBottom() {
        return WebBottom;
    }

    public void setWebBottom(String WebBottom) {
        this.WebBottom = WebBottom;
    }

    public String getWorkTime() {
        return WorkTime;
    }

    public void setWorkTime(String WorkTime) {
        this.WorkTime = WorkTime;
    }

    public String getBorrowCard() {
        return BorrowCard;
    }

    public void setBorrowCard(String BorrowCard) {
        this.BorrowCard = BorrowCard;
    }

    public String getWebLogoUrl() {
        return WebLogoUrl;
    }

    public void setWebLogoUrl(String WebLogoUrl) {
        this.WebLogoUrl = WebLogoUrl;
    }

    public String getSchoolFolder() {
        return SchoolFolder;
    }

    public void setSchoolFolder(String SchoolFolder) {
        this.SchoolFolder = SchoolFolder;
    }

    public int getProvinceID() {
        return ProvinceID;
    }

    public void setProvinceID(int ProvinceID) {
        this.ProvinceID = ProvinceID;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int CityID) {
        this.CityID = CityID;
    }

    public int getCountyID() {
        return CountyID;
    }

    public void setCountyID(int CountyID) {
        this.CountyID = CountyID;
    }

    public int getReaderCount() {
        return ReaderCount;
    }

    public void setReaderCount(int ReaderCount) {
        this.ReaderCount = ReaderCount;
    }

    public int getBookCount() {
        return BookCount;
    }

    public void setBookCount(int BookCount) {
        this.BookCount = BookCount;
    }

    @Override
    public String toString() {
        return "LibraryBean{" +
                "ID=" + ID +
                ", SchoolIntro='" + SchoolIntro + '\'' +
                ", IsOffline=" + IsOffline +
                ", OfflineTime='" + OfflineTime + '\'' +
                ", SchoolLevel=" + SchoolLevel +
                ", IsLock=" + IsLock +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", AddTime='" + AddTime + '\'' +
                ", SchoolParams='" + SchoolParams + '\'' +
                ", SchoolType=" + SchoolType +
                ", SchoolID=" + SchoolID +
                ", Address='" + Address + '\'' +
                ", Remark='" + Remark + '\'' +
                ", SchoolName='" + SchoolName + '\'' +
                ", Functions='" + Functions + '\'' +
                ", SchoolRule='" + SchoolRule + '\'' +
                ", WebBottom='" + WebBottom + '\'' +
                ", WorkTime='" + WorkTime + '\'' +
                ", BorrowCard='" + BorrowCard + '\'' +
                ", WebLogoUrl='" + WebLogoUrl + '\'' +
                ", SchoolFolder='" + SchoolFolder + '\'' +
                ", ProvinceID=" + ProvinceID +
                ", CityID=" + CityID +
                ", CountyID=" + CountyID +
                ", ReaderCount=" + ReaderCount +
                ", BookCount=" + BookCount +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ID);
        dest.writeString(this.SchoolIntro);
        dest.writeInt(this.IsOffline);
        dest.writeString(this.OfflineTime);
        dest.writeInt(this.SchoolLevel);
        dest.writeInt(this.IsLock);
        dest.writeString(this.StartTime);
        dest.writeString(this.EndTime);
        dest.writeString(this.AddTime);
        dest.writeString(this.SchoolParams);
        dest.writeInt(this.SchoolType);
        dest.writeInt(this.SchoolID);
        dest.writeString(this.Address);
        dest.writeString(this.Remark);
        dest.writeString(this.SchoolName);
        dest.writeString(this.Functions);
        dest.writeString(this.SchoolRule);
        dest.writeString(this.WebBottom);
        dest.writeString(this.WorkTime);
        dest.writeString(this.BorrowCard);
        dest.writeString(this.WebLogoUrl);
        dest.writeString(this.SchoolFolder);
        dest.writeInt(this.ProvinceID);
        dest.writeInt(this.CityID);
        dest.writeInt(this.CountyID);
        dest.writeInt(this.ReaderCount);
        dest.writeInt(this.BookCount);
    }

    public LibraryBean() {
    }

    protected LibraryBean(Parcel in) {
        this.ID = in.readInt();
        this.SchoolIntro = in.readString();
        this.IsOffline = in.readInt();
        this.OfflineTime = in.readString();
        this.SchoolLevel = in.readInt();
        this.IsLock = in.readInt();
        this.StartTime = in.readString();
        this.EndTime = in.readString();
        this.AddTime = in.readString();
        this.SchoolParams = in.readString();
        this.SchoolType = in.readInt();
        this.SchoolID = in.readInt();
        this.Address = in.readString();
        this.Remark = in.readString();
        this.SchoolName = in.readString();
        this.Functions = in.readString();
        this.SchoolRule = in.readString();
        this.WebBottom = in.readString();
        this.WorkTime = in.readString();
        this.BorrowCard = in.readString();
        this.WebLogoUrl = in.readString();
        this.SchoolFolder = in.readString();
        this.ProvinceID = in.readInt();
        this.CityID = in.readInt();
        this.CountyID = in.readInt();
        this.ReaderCount = in.readInt();
        this.BookCount = in.readInt();
    }

    public static final Parcelable.Creator<LibraryBean> CREATOR = new Parcelable.Creator<LibraryBean>() {
        @Override
        public LibraryBean createFromParcel(Parcel source) {
            return new LibraryBean(source);
        }

        @Override
        public LibraryBean[] newArray(int size) {
            return new LibraryBean[size];
        }
    };
}
