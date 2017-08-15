package com.hebth.mobilelibrary.utils;

/**
 * Created by hebth on 2017-07-26.
 * 通用工具类
 */

public class CommenUtils {

    /**
     * 检测字符串是否为空
     * @param str 需要检测的字符串
     * @return true表示不为空；false表示为空
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return false;
        } else {
            return true;
        }
    }
}
