package com.hebth.mobilelibrary.base;

/**
 * Created by hebth on 2017-06-09.
 * 应用程序的常量
 */

public class AppConstant {
    public static final String RESOURCESTR = "http://101.201.114.210/591/ebooks/";

    public static final String HOST = "http://www.thyhapp.com:8091";//主机名
    public static final String NEWS_PATH = "News.asmx/GetNews";//首页新闻
    public static final String OPAC_PATH = "BookInfoService.asmx/GetBookInfo";//opac搜索
    public static final String RECOMMEND_PATH = "BookInfoService.asmx/NewBookRecommend";//新书推荐


    public static int pageCoount_news = 10;//首页新闻的单次加载条数

}
