package com.hebth.mobilelibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.hebth.mobilelibrary.MyApplication;

/**
 * Created by hebth on 2017-07-27.
 * 保存共享参数工具类
 */

public class SharedPreferenceUtil {

    private static Context context = MyApplication.getContext();

    /**
     * 保存String类型的共享参数
     *
     * @param key   保存信息的名称
     * @param value 保存信息的值
     */
    public static void putSharePreferenceString(String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    /**
     * 获取保存的共享参数
     *
     * @param key 保存的信息的名称
     * @return
     */
    public static String getSharePreferencesString(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, "");
    }

    /**
     * 保存登录信息
     *
     * @param username 登录名
     * @param password 密码
     */
    public static void saveLoginInfo(String username, String password) {
        putSharePreferenceString("username", username);
        putSharePreferenceString("password", password);
    }

    /**
     * 清空登录信息
     */
    public static void cleanLoginInfo() {
        putSharePreferenceString("username", "");
        putSharePreferenceString("password", "");
    }

    /**
     * 获取登录名
     *
     * @return
     */
    public static String getUsername() {
        return getSharePreferencesString("username");
    }

    /**
     * 获取登录密码
     *
     * @return
     */
    public static String getPassword() {
        return getSharePreferencesString("password");
    }
}
