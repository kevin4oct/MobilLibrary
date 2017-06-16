package com.hebth.mobilelibrary.utils;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import com.hebth.mobilelibrary.MyApplication;
import com.orhanobut.logger.Logger;

import java.io.File;

/**
 * Created by hebth on 2017-06-15.
 * 电子书存储的工具类
 */

public class FileUtils {
    public static final String TAG = FileUtils.class.getSimpleName();

    /**
     * 文件在SD卡中存储的根路径
     */
    public static final File EBOOKFILE = MyApplication.getContext()
            .getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + File.separator + "ebooks");

    /**
     * 文件在SD卡中存储的根路径
     */
    public static final String SDCARDPATH = EBOOKFILE.getAbsolutePath();

    /**
     * SD卡的状态
     */
    public static final String SDCARDSTATE = Environment.getExternalStorageState();

    /**
     * 获得sd卡剩余容量，即可用大小
     *
     * @return
     */
    public static long getSDAvailableSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return blockSize * availableBlocks;
    }

    /**
     * 获取sd卡目录下是否包含该文件
     */
    public static boolean getFiles(String fileName) {

        Logger.e(TAG, "要查询的书名 " + fileName);
        String[] list = EBOOKFILE.list();
        for (String s : list) {
            if (fileName.equals(s)) {
                Log.e(TAG, "要查询的书名: " + fileName + ",找到该书：" + s);
                return true;
            }
        }
        Log.e(TAG, "要查询的书名: " + fileName + ",没有找到");
        return false;
    }


}
