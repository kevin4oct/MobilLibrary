package com.hebth.mobilelibrary.beans;

import com.hebth.mobilelibrary.ui.readerinfo.net.UserInfoParser;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by hebth on 2017-07-26.
 * 读者的实体类
 */
@HttpResponse(parser = UserInfoParser.class)
public class UserBean {

    /**
     * SchoolID : 1110
     * UserName : sjzts
     * RoleID : 124
     * ClassID : 0
     * NickName : 石家庄市第十二中学
     * RealName : 石家庄市第十二中学
     * UserFace :
     * Password : null
     * Email : 273468992@qq.com
     * Sex : 男
     * Question : null
     * Answer : null
     * ProvinceID : null
     * CityID : null
     * CountyID : null
     * IsLock : 0
     * Address : 石家庄市第十二中学
     * Telephone : 83617820
     * IDPhoto :
     * UserSign :
     * QQ :
     * UserFolder : null
     * UserParams : null
     * Score : 0
     * UserMoney : 0.0
     * UserMsg : 0
     * BorrowTimes : 5
     * LoginTimes : 141
     * OnLibTime : 0.0
     * OnlineTime : null
     * LastLoginIP : 222.223.215.75
     * LastLoginTime : 2017-07-26T09:13:11
     * AddTime : 2017-05-04T17:58:37
     * IsAdministrator : null
     * UserType : null
     * ValideDate : null
     * MacAddress : null
     * SchoolUserType : null
     * EducationType : null
     * ManageSchoolIDList : null
     * ClassName :
     * RoleName : 管理员
     * BorrowedCount : 3
     * OrderCount : 1
     * OverTimeCount : 0
     * MaxBorrowedCount : 4
     */

    private int SchoolID;
    private String UserName;
    private int RoleID;
    private int ClassID;
    private String NickName;
    private String RealName;
    private String UserFace;
    private Object Password;
    private String Email;
    private String Sex;
    private Object Question;
    private Object Answer;
    private Object ProvinceID;
    private Object CityID;
    private Object CountyID;
    private int IsLock;
    private String Address;
    private String Telephone;
    private String IDPhoto;
    private String UserSign;
    private String QQ;
    private Object UserFolder;
    private Object UserParams;
    private int Score;
    private double UserMoney;
    private int UserMsg;
    private int BorrowTimes;
    private int LoginTimes;
    private double OnLibTime;
    private Object OnlineTime;
    private String LastLoginIP;
    private String LastLoginTime;
    private String AddTime;
    private Object IsAdministrator;
    private Object UserType;
    private Object ValideDate;
    private Object MacAddress;
    private Object SchoolUserType;
    private Object EducationType;
    private Object ManageSchoolIDList;
    private String ClassName;
    private String RoleName;
    private int BorrowedCount;
    private int OrderCount;
    private int OverTimeCount;
    private int MaxBorrowedCount;

    public int getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(int SchoolID) {
        this.SchoolID = SchoolID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String RealName) {
        this.RealName = RealName;
    }

    public String getUserFace() {
        return UserFace;
    }

    public void setUserFace(String UserFace) {
        this.UserFace = UserFace;
    }

    public Object getPassword() {
        return Password;
    }

    public void setPassword(Object Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public Object getQuestion() {
        return Question;
    }

    public void setQuestion(Object Question) {
        this.Question = Question;
    }

    public Object getAnswer() {
        return Answer;
    }

    public void setAnswer(Object Answer) {
        this.Answer = Answer;
    }

    public Object getProvinceID() {
        return ProvinceID;
    }

    public void setProvinceID(Object ProvinceID) {
        this.ProvinceID = ProvinceID;
    }

    public Object getCityID() {
        return CityID;
    }

    public void setCityID(Object CityID) {
        this.CityID = CityID;
    }

    public Object getCountyID() {
        return CountyID;
    }

    public void setCountyID(Object CountyID) {
        this.CountyID = CountyID;
    }

    public int getIsLock() {
        return IsLock;
    }

    public void setIsLock(int IsLock) {
        this.IsLock = IsLock;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getIDPhoto() {
        return IDPhoto;
    }

    public void setIDPhoto(String IDPhoto) {
        this.IDPhoto = IDPhoto;
    }

    public String getUserSign() {
        return UserSign;
    }

    public void setUserSign(String UserSign) {
        this.UserSign = UserSign;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public Object getUserFolder() {
        return UserFolder;
    }

    public void setUserFolder(Object UserFolder) {
        this.UserFolder = UserFolder;
    }

    public Object getUserParams() {
        return UserParams;
    }

    public void setUserParams(Object UserParams) {
        this.UserParams = UserParams;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public double getUserMoney() {
        return UserMoney;
    }

    public void setUserMoney(double UserMoney) {
        this.UserMoney = UserMoney;
    }

    public int getUserMsg() {
        return UserMsg;
    }

    public void setUserMsg(int UserMsg) {
        this.UserMsg = UserMsg;
    }

    public int getBorrowTimes() {
        return BorrowTimes;
    }

    public void setBorrowTimes(int BorrowTimes) {
        this.BorrowTimes = BorrowTimes;
    }

    public int getLoginTimes() {
        return LoginTimes;
    }

    public void setLoginTimes(int LoginTimes) {
        this.LoginTimes = LoginTimes;
    }

    public double getOnLibTime() {
        return OnLibTime;
    }

    public void setOnLibTime(double OnLibTime) {
        this.OnLibTime = OnLibTime;
    }

    public Object getOnlineTime() {
        return OnlineTime;
    }

    public void setOnlineTime(Object OnlineTime) {
        this.OnlineTime = OnlineTime;
    }

    public String getLastLoginIP() {
        return LastLoginIP;
    }

    public void setLastLoginIP(String LastLoginIP) {
        this.LastLoginIP = LastLoginIP;
    }

    public String getLastLoginTime() {
        return LastLoginTime;
    }

    public void setLastLoginTime(String LastLoginTime) {
        this.LastLoginTime = LastLoginTime;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String AddTime) {
        this.AddTime = AddTime;
    }

    public Object getIsAdministrator() {
        return IsAdministrator;
    }

    public void setIsAdministrator(Object IsAdministrator) {
        this.IsAdministrator = IsAdministrator;
    }

    public Object getUserType() {
        return UserType;
    }

    public void setUserType(Object UserType) {
        this.UserType = UserType;
    }

    public Object getValideDate() {
        return ValideDate;
    }

    public void setValideDate(Object ValideDate) {
        this.ValideDate = ValideDate;
    }

    public Object getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(Object MacAddress) {
        this.MacAddress = MacAddress;
    }

    public Object getSchoolUserType() {
        return SchoolUserType;
    }

    public void setSchoolUserType(Object SchoolUserType) {
        this.SchoolUserType = SchoolUserType;
    }

    public Object getEducationType() {
        return EducationType;
    }

    public void setEducationType(Object EducationType) {
        this.EducationType = EducationType;
    }

    public Object getManageSchoolIDList() {
        return ManageSchoolIDList;
    }

    public void setManageSchoolIDList(Object ManageSchoolIDList) {
        this.ManageSchoolIDList = ManageSchoolIDList;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public int getBorrowedCount() {
        return BorrowedCount;
    }

    public void setBorrowedCount(int BorrowedCount) {
        this.BorrowedCount = BorrowedCount;
    }

    public int getOrderCount() {
        return OrderCount;
    }

    public void setOrderCount(int OrderCount) {
        this.OrderCount = OrderCount;
    }

    public int getOverTimeCount() {
        return OverTimeCount;
    }

    public void setOverTimeCount(int OverTimeCount) {
        this.OverTimeCount = OverTimeCount;
    }

    public int getMaxBorrowedCount() {
        return MaxBorrowedCount;
    }

    public void setMaxBorrowedCount(int MaxBorrowedCount) {
        this.MaxBorrowedCount = MaxBorrowedCount;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "SchoolID=" + SchoolID +
                ", UserName='" + UserName + '\'' +
                ", RoleID=" + RoleID +
                ", ClassID=" + ClassID +
                ", NickName='" + NickName + '\'' +
                ", RealName='" + RealName + '\'' +
                ", UserFace='" + UserFace + '\'' +
                ", Password=" + Password +
                ", Email='" + Email + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Question=" + Question +
                ", Answer=" + Answer +
                ", ProvinceID=" + ProvinceID +
                ", CityID=" + CityID +
                ", CountyID=" + CountyID +
                ", IsLock=" + IsLock +
                ", Address='" + Address + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", IDPhoto='" + IDPhoto + '\'' +
                ", UserSign='" + UserSign + '\'' +
                ", QQ='" + QQ + '\'' +
                ", UserFolder=" + UserFolder +
                ", UserParams=" + UserParams +
                ", Score=" + Score +
                ", UserMoney=" + UserMoney +
                ", UserMsg=" + UserMsg +
                ", BorrowTimes=" + BorrowTimes +
                ", LoginTimes=" + LoginTimes +
                ", OnLibTime=" + OnLibTime +
                ", OnlineTime=" + OnlineTime +
                ", LastLoginIP='" + LastLoginIP + '\'' +
                ", LastLoginTime='" + LastLoginTime + '\'' +
                ", AddTime='" + AddTime + '\'' +
                ", IsAdministrator=" + IsAdministrator +
                ", UserType=" + UserType +
                ", ValideDate=" + ValideDate +
                ", MacAddress=" + MacAddress +
                ", SchoolUserType=" + SchoolUserType +
                ", EducationType=" + EducationType +
                ", ManageSchoolIDList=" + ManageSchoolIDList +
                ", ClassName='" + ClassName + '\'' +
                ", RoleName='" + RoleName + '\'' +
                ", BorrowedCount=" + BorrowedCount +
                ", OrderCount=" + OrderCount +
                ", OverTimeCount=" + OverTimeCount +
                ", MaxBorrowedCount=" + MaxBorrowedCount +
                '}';
    }
}
