package com.hebth.mobilelibrary.base;

import com.amap.api.maps2d.model.LatLng;

/**
 * Created by hebth on 2017-06-09.
 * 应用程序的常量
 */

public class AppConstant {
    //
    public static final String RESOURCESTR = "http://101.201.114.210/591/ebooks/";//社管电子书
    //
    public static final String HOST = "http://www.thyhapp.com:8091";//主机名
    public static final String NEWS_PATH = "News.asmx/GetNews";//首页新闻
    public static final String OPAC_PATH = "BookInfoService.asmx/GetBookInfo";//opac搜索
    public static final String RECOMMEND_PATH = "BookInfoService.asmx/NewBookRecommend";//新书推荐
    public static final String BOOKRANK_PATH = "BookInfoService.asmx/BookRank";//借阅排行
    public static final String USERINFO = "UserInfoService.asmx/GetUserInfo";//读者信息
    public static final String CURRENTBORROW = "UserInfoService.asmx/GetCurrentBorrow";//正在借阅
    public static final String REBORROW = "UserInfoService.asmx/ReBorrow";//续借
    public static final String HISTORY = "UserInfoService.asmx/GetHistoryBorrow";//历史借阅
    public static final String LOGIN = "LoginService.asmx/Login";//登录接口
    //
    public static final String LIBRARY_PATH = "LibNote.asmx/LibInfo";//图书馆指南接口
    //
    public static int pageCount_news = 10;//首页新闻的单次加载条数
    //主界面跳转时间(单位：s)
    public static final int welcomeLimit = 5;

    //设置中心点,河北省图书馆 38.0382100000,114.5227800000
    public static final LatLng centerLatLng = new LatLng(38.0382100000, 114.5227800000);

}
