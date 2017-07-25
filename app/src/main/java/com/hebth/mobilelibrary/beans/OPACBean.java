package com.hebth.mobilelibrary.beans;

import com.hebth.mobilelibrary.ui.opac.net.OPACParser;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by hebth on 2017-07-25.
 * opac查询实体类
 */
@HttpResponse(parser = OPACParser.class)
public class OPACBean {

    /**
     * ID : 0
     * SchoolID : 0
     * UpEAN : null
     * DownEAN : 9787543895805
     * BookName : 中国房地产大萧条还有多远
     * PinYin : null
     * SubHead : null
     * SeriesName : null
     * SeriesAuthor : null
     * FirstAuthor : 许子枋
     * SecondAuthor : null
     * DetachCompileName : null
     * DetachCompileNumber : null
     * BookPrice : 0.0
     * PublishName : 湖南人民出版社
     * PublishPlace : null
     * PrintDate : null
     * VersionNumber : null
     * ChineseSort : F299.233.5
     * MotifWord : null
     * ISAM : null
     * Breed : null
     * PageNumber : null
     * Format : null
     * Summary : null
     * Getup : 0
     * Language : null
     * CoverUrl : null
     * Remark : null
     * BookFolder : null
     * LibraryMARC : null
     * ResourceType : 0
     * Marc : null
     * AddTime : 0001-01-01T00:00:00
     * UserName : null
     * AuditUser : null
     * DatumShape : null
     * S105 : null
     * FWiterType : null
     * SWiterType : null
     * FGroup : null
     * SGroup : null
     * BorrowCount : 0
     * OrderCount : 0
     * LibPlace : null
     * ShelfNumber : null
     * BarCode : null
     * PlaceCode : null
     * GAuthor : null
     * GWiterType : null
     * Duplicate : 0
     * ChiSortWaterCode : 0
     * ISAMType : 0
     * VolumeNumber : null
     * RebuildMarc : false
     * Recommend : false
     * ShareMarcBookID : 0
     * WhereBoundCount : null
     * BindTime : null
     * YearScope : null
     * BookScope : null
     * MagazineScope : null
     * PublishCycleName : 0
     * PrintUserName : null
     * CopyNum : 0
     * BindPrice : null
     * MagazineId : null
     * MailNumber : null
     * MagazineNumber : null
     * TableNumber : 0
     * OnLibNumber : 0
     * BookCount : 3088
     * OthersText : 暂无数据
     */

    private int ID;
    private int SchoolID;
    private Object UpEAN;
    private String DownEAN;
    private String BookName;
    private Object PinYin;
    private Object SubHead;
    private Object SeriesName;
    private Object SeriesAuthor;
    private String FirstAuthor;
    private Object SecondAuthor;
    private Object DetachCompileName;
    private Object DetachCompileNumber;
    private double BookPrice;
    private String PublishName;
    private Object PublishPlace;
    private Object PrintDate;
    private Object VersionNumber;
    private String ChineseSort;
    private Object MotifWord;
    private Object ISAM;
    private Object Breed;
    private Object PageNumber;
    private Object Format;
    private Object Summary;
    private int Getup;
    private Object Language;
    private Object CoverUrl;
    private Object Remark;
    private Object BookFolder;
    private Object LibraryMARC;
    private int ResourceType;
    private Object Marc;
    private String AddTime;
    private Object UserName;
    private Object AuditUser;
    private Object DatumShape;
    private Object S105;
    private Object FWiterType;
    private Object SWiterType;
    private Object FGroup;
    private Object SGroup;
    private int BorrowCount;
    private int OrderCount;
    private Object LibPlace;
    private Object ShelfNumber;
    private Object BarCode;
    private Object PlaceCode;
    private Object GAuthor;
    private Object GWiterType;
    private int Duplicate;
    private int ChiSortWaterCode;
    private int ISAMType;
    private Object VolumeNumber;
    private boolean RebuildMarc;
    private boolean Recommend;
    private int ShareMarcBookID;
    private Object WhereBoundCount;
    private Object BindTime;
    private Object YearScope;
    private Object BookScope;
    private Object MagazineScope;
    private int PublishCycleName;
    private Object PrintUserName;
    private int CopyNum;
    private Object BindPrice;
    private Object MagazineId;
    private Object MailNumber;
    private Object MagazineNumber;
    private int TableNumber;
    private int OnLibNumber;
    private String BookCount;
    private String OthersText;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(int SchoolID) {
        this.SchoolID = SchoolID;
    }

    public Object getUpEAN() {
        return UpEAN;
    }

    public void setUpEAN(Object UpEAN) {
        this.UpEAN = UpEAN;
    }

    public String getDownEAN() {
        return DownEAN;
    }

    public void setDownEAN(String DownEAN) {
        this.DownEAN = DownEAN;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public Object getPinYin() {
        return PinYin;
    }

    public void setPinYin(Object PinYin) {
        this.PinYin = PinYin;
    }

    public Object getSubHead() {
        return SubHead;
    }

    public void setSubHead(Object SubHead) {
        this.SubHead = SubHead;
    }

    public Object getSeriesName() {
        return SeriesName;
    }

    public void setSeriesName(Object SeriesName) {
        this.SeriesName = SeriesName;
    }

    public Object getSeriesAuthor() {
        return SeriesAuthor;
    }

    public void setSeriesAuthor(Object SeriesAuthor) {
        this.SeriesAuthor = SeriesAuthor;
    }

    public String getFirstAuthor() {
        return FirstAuthor;
    }

    public void setFirstAuthor(String FirstAuthor) {
        this.FirstAuthor = FirstAuthor;
    }

    public Object getSecondAuthor() {
        return SecondAuthor;
    }

    public void setSecondAuthor(Object SecondAuthor) {
        this.SecondAuthor = SecondAuthor;
    }

    public Object getDetachCompileName() {
        return DetachCompileName;
    }

    public void setDetachCompileName(Object DetachCompileName) {
        this.DetachCompileName = DetachCompileName;
    }

    public Object getDetachCompileNumber() {
        return DetachCompileNumber;
    }

    public void setDetachCompileNumber(Object DetachCompileNumber) {
        this.DetachCompileNumber = DetachCompileNumber;
    }

    public double getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(double BookPrice) {
        this.BookPrice = BookPrice;
    }

    public String getPublishName() {
        return PublishName;
    }

    public void setPublishName(String PublishName) {
        this.PublishName = PublishName;
    }

    public Object getPublishPlace() {
        return PublishPlace;
    }

    public void setPublishPlace(Object PublishPlace) {
        this.PublishPlace = PublishPlace;
    }

    public Object getPrintDate() {
        return PrintDate;
    }

    public void setPrintDate(Object PrintDate) {
        this.PrintDate = PrintDate;
    }

    public Object getVersionNumber() {
        return VersionNumber;
    }

    public void setVersionNumber(Object VersionNumber) {
        this.VersionNumber = VersionNumber;
    }

    public String getChineseSort() {
        return ChineseSort;
    }

    public void setChineseSort(String ChineseSort) {
        this.ChineseSort = ChineseSort;
    }

    public Object getMotifWord() {
        return MotifWord;
    }

    public void setMotifWord(Object MotifWord) {
        this.MotifWord = MotifWord;
    }

    public Object getISAM() {
        return ISAM;
    }

    public void setISAM(Object ISAM) {
        this.ISAM = ISAM;
    }

    public Object getBreed() {
        return Breed;
    }

    public void setBreed(Object Breed) {
        this.Breed = Breed;
    }

    public Object getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(Object PageNumber) {
        this.PageNumber = PageNumber;
    }

    public Object getFormat() {
        return Format;
    }

    public void setFormat(Object Format) {
        this.Format = Format;
    }

    public Object getSummary() {
        return Summary;
    }

    public void setSummary(Object Summary) {
        this.Summary = Summary;
    }

    public int getGetup() {
        return Getup;
    }

    public void setGetup(int Getup) {
        this.Getup = Getup;
    }

    public Object getLanguage() {
        return Language;
    }

    public void setLanguage(Object Language) {
        this.Language = Language;
    }

    public Object getCoverUrl() {
        return CoverUrl;
    }

    public void setCoverUrl(Object CoverUrl) {
        this.CoverUrl = CoverUrl;
    }

    public Object getRemark() {
        return Remark;
    }

    public void setRemark(Object Remark) {
        this.Remark = Remark;
    }

    public Object getBookFolder() {
        return BookFolder;
    }

    public void setBookFolder(Object BookFolder) {
        this.BookFolder = BookFolder;
    }

    public Object getLibraryMARC() {
        return LibraryMARC;
    }

    public void setLibraryMARC(Object LibraryMARC) {
        this.LibraryMARC = LibraryMARC;
    }

    public int getResourceType() {
        return ResourceType;
    }

    public void setResourceType(int ResourceType) {
        this.ResourceType = ResourceType;
    }

    public Object getMarc() {
        return Marc;
    }

    public void setMarc(Object Marc) {
        this.Marc = Marc;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String AddTime) {
        this.AddTime = AddTime;
    }

    public Object getUserName() {
        return UserName;
    }

    public void setUserName(Object UserName) {
        this.UserName = UserName;
    }

    public Object getAuditUser() {
        return AuditUser;
    }

    public void setAuditUser(Object AuditUser) {
        this.AuditUser = AuditUser;
    }

    public Object getDatumShape() {
        return DatumShape;
    }

    public void setDatumShape(Object DatumShape) {
        this.DatumShape = DatumShape;
    }

    public Object getS105() {
        return S105;
    }

    public void setS105(Object S105) {
        this.S105 = S105;
    }

    public Object getFWiterType() {
        return FWiterType;
    }

    public void setFWiterType(Object FWiterType) {
        this.FWiterType = FWiterType;
    }

    public Object getSWiterType() {
        return SWiterType;
    }

    public void setSWiterType(Object SWiterType) {
        this.SWiterType = SWiterType;
    }

    public Object getFGroup() {
        return FGroup;
    }

    public void setFGroup(Object FGroup) {
        this.FGroup = FGroup;
    }

    public Object getSGroup() {
        return SGroup;
    }

    public void setSGroup(Object SGroup) {
        this.SGroup = SGroup;
    }

    public int getBorrowCount() {
        return BorrowCount;
    }

    public void setBorrowCount(int BorrowCount) {
        this.BorrowCount = BorrowCount;
    }

    public int getOrderCount() {
        return OrderCount;
    }

    public void setOrderCount(int OrderCount) {
        this.OrderCount = OrderCount;
    }

    public Object getLibPlace() {
        return LibPlace;
    }

    public void setLibPlace(Object LibPlace) {
        this.LibPlace = LibPlace;
    }

    public Object getShelfNumber() {
        return ShelfNumber;
    }

    public void setShelfNumber(Object ShelfNumber) {
        this.ShelfNumber = ShelfNumber;
    }

    public Object getBarCode() {
        return BarCode;
    }

    public void setBarCode(Object BarCode) {
        this.BarCode = BarCode;
    }

    public Object getPlaceCode() {
        return PlaceCode;
    }

    public void setPlaceCode(Object PlaceCode) {
        this.PlaceCode = PlaceCode;
    }

    public Object getGAuthor() {
        return GAuthor;
    }

    public void setGAuthor(Object GAuthor) {
        this.GAuthor = GAuthor;
    }

    public Object getGWiterType() {
        return GWiterType;
    }

    public void setGWiterType(Object GWiterType) {
        this.GWiterType = GWiterType;
    }

    public int getDuplicate() {
        return Duplicate;
    }

    public void setDuplicate(int Duplicate) {
        this.Duplicate = Duplicate;
    }

    public int getChiSortWaterCode() {
        return ChiSortWaterCode;
    }

    public void setChiSortWaterCode(int ChiSortWaterCode) {
        this.ChiSortWaterCode = ChiSortWaterCode;
    }

    public int getISAMType() {
        return ISAMType;
    }

    public void setISAMType(int ISAMType) {
        this.ISAMType = ISAMType;
    }

    public Object getVolumeNumber() {
        return VolumeNumber;
    }

    public void setVolumeNumber(Object VolumeNumber) {
        this.VolumeNumber = VolumeNumber;
    }

    public boolean isRebuildMarc() {
        return RebuildMarc;
    }

    public void setRebuildMarc(boolean RebuildMarc) {
        this.RebuildMarc = RebuildMarc;
    }

    public boolean isRecommend() {
        return Recommend;
    }

    public void setRecommend(boolean Recommend) {
        this.Recommend = Recommend;
    }

    public int getShareMarcBookID() {
        return ShareMarcBookID;
    }

    public void setShareMarcBookID(int ShareMarcBookID) {
        this.ShareMarcBookID = ShareMarcBookID;
    }

    public Object getWhereBoundCount() {
        return WhereBoundCount;
    }

    public void setWhereBoundCount(Object WhereBoundCount) {
        this.WhereBoundCount = WhereBoundCount;
    }

    public Object getBindTime() {
        return BindTime;
    }

    public void setBindTime(Object BindTime) {
        this.BindTime = BindTime;
    }

    public Object getYearScope() {
        return YearScope;
    }

    public void setYearScope(Object YearScope) {
        this.YearScope = YearScope;
    }

    public Object getBookScope() {
        return BookScope;
    }

    public void setBookScope(Object BookScope) {
        this.BookScope = BookScope;
    }

    public Object getMagazineScope() {
        return MagazineScope;
    }

    public void setMagazineScope(Object MagazineScope) {
        this.MagazineScope = MagazineScope;
    }

    public int getPublishCycleName() {
        return PublishCycleName;
    }

    public void setPublishCycleName(int PublishCycleName) {
        this.PublishCycleName = PublishCycleName;
    }

    public Object getPrintUserName() {
        return PrintUserName;
    }

    public void setPrintUserName(Object PrintUserName) {
        this.PrintUserName = PrintUserName;
    }

    public int getCopyNum() {
        return CopyNum;
    }

    public void setCopyNum(int CopyNum) {
        this.CopyNum = CopyNum;
    }

    public Object getBindPrice() {
        return BindPrice;
    }

    public void setBindPrice(Object BindPrice) {
        this.BindPrice = BindPrice;
    }

    public Object getMagazineId() {
        return MagazineId;
    }

    public void setMagazineId(Object MagazineId) {
        this.MagazineId = MagazineId;
    }

    public Object getMailNumber() {
        return MailNumber;
    }

    public void setMailNumber(Object MailNumber) {
        this.MailNumber = MailNumber;
    }

    public Object getMagazineNumber() {
        return MagazineNumber;
    }

    public void setMagazineNumber(Object MagazineNumber) {
        this.MagazineNumber = MagazineNumber;
    }

    public int getTableNumber() {
        return TableNumber;
    }

    public void setTableNumber(int TableNumber) {
        this.TableNumber = TableNumber;
    }

    public int getOnLibNumber() {
        return OnLibNumber;
    }

    public void setOnLibNumber(int OnLibNumber) {
        this.OnLibNumber = OnLibNumber;
    }

    public String getBookCount() {
        return BookCount;
    }

    public void setBookCount(String BookCount) {
        this.BookCount = BookCount;
    }

    public String getOthersText() {
        return OthersText;
    }

    public void setOthersText(String OthersText) {
        this.OthersText = OthersText;
    }

    @Override
    public String toString() {
        return "OPACBean{" +
                "ID=" + ID +
                ", SchoolID=" + SchoolID +
                ", UpEAN=" + UpEAN +
                ", DownEAN='" + DownEAN + '\'' +
                ", BookName='" + BookName + '\'' +
                ", PinYin=" + PinYin +
                ", SubHead=" + SubHead +
                ", SeriesName=" + SeriesName +
                ", SeriesAuthor=" + SeriesAuthor +
                ", FirstAuthor='" + FirstAuthor + '\'' +
                ", SecondAuthor=" + SecondAuthor +
                ", DetachCompileName=" + DetachCompileName +
                ", DetachCompileNumber=" + DetachCompileNumber +
                ", BookPrice=" + BookPrice +
                ", PublishName='" + PublishName + '\'' +
                ", PublishPlace=" + PublishPlace +
                ", PrintDate=" + PrintDate +
                ", VersionNumber=" + VersionNumber +
                ", ChineseSort='" + ChineseSort + '\'' +
                ", MotifWord=" + MotifWord +
                ", ISAM=" + ISAM +
                ", Breed=" + Breed +
                ", PageNumber=" + PageNumber +
                ", Format=" + Format +
                ", Summary=" + Summary +
                ", Getup=" + Getup +
                ", Language=" + Language +
                ", CoverUrl=" + CoverUrl +
                ", Remark=" + Remark +
                ", BookFolder=" + BookFolder +
                ", LibraryMARC=" + LibraryMARC +
                ", ResourceType=" + ResourceType +
                ", Marc=" + Marc +
                ", AddTime='" + AddTime + '\'' +
                ", UserName=" + UserName +
                ", AuditUser=" + AuditUser +
                ", DatumShape=" + DatumShape +
                ", S105=" + S105 +
                ", FWiterType=" + FWiterType +
                ", SWiterType=" + SWiterType +
                ", FGroup=" + FGroup +
                ", SGroup=" + SGroup +
                ", BorrowCount=" + BorrowCount +
                ", OrderCount=" + OrderCount +
                ", LibPlace=" + LibPlace +
                ", ShelfNumber=" + ShelfNumber +
                ", BarCode=" + BarCode +
                ", PlaceCode=" + PlaceCode +
                ", GAuthor=" + GAuthor +
                ", GWiterType=" + GWiterType +
                ", Duplicate=" + Duplicate +
                ", ChiSortWaterCode=" + ChiSortWaterCode +
                ", ISAMType=" + ISAMType +
                ", VolumeNumber=" + VolumeNumber +
                ", RebuildMarc=" + RebuildMarc +
                ", Recommend=" + Recommend +
                ", ShareMarcBookID=" + ShareMarcBookID +
                ", WhereBoundCount=" + WhereBoundCount +
                ", BindTime=" + BindTime +
                ", YearScope=" + YearScope +
                ", BookScope=" + BookScope +
                ", MagazineScope=" + MagazineScope +
                ", PublishCycleName=" + PublishCycleName +
                ", PrintUserName=" + PrintUserName +
                ", CopyNum=" + CopyNum +
                ", BindPrice=" + BindPrice +
                ", MagazineId=" + MagazineId +
                ", MailNumber=" + MailNumber +
                ", MagazineNumber=" + MagazineNumber +
                ", TableNumber=" + TableNumber +
                ", OnLibNumber=" + OnLibNumber +
                ", BookCount='" + BookCount + '\'' +
                ", OthersText='" + OthersText + '\'' +
                '}';
    }
}
