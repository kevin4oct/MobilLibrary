package com.hebth.mobilelibrary.utils;

import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hebth.mobilelibrary.MyApplication;

import java.io.File;

/**
 * Created by hebth on 2017-06-15.
 * 电子书存储的工具类
 */

public class FileUtils {
    public static final String TAG = FileUtils.class.getSimpleName();

    public static final int COVER = 0x100;
    public static final int EBOOK = 0x200;

    /**
     * 文件在SD卡中存储的根路径
     */
    public static final File EBOOKFILE = MyApplication.getContext()
            .getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + File.separator + "ebooks");
    /**
     * 电子书封面在SD卡中存储的根路径
     */
    public static final File EBOOKCOVERFILE = MyApplication.getContext()
            .getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + File.separator + "cover");

    /**
     * 文件在SD卡中存储的根路径
     */
    public static final String EBOOK_PATH = EBOOKFILE.getAbsolutePath();

    /**
     * 文件在SD卡中存储的根路径
     */
    public static final String COVER_PATH = EBOOKCOVERFILE.getAbsolutePath();

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
    public static boolean isInclude(int type,String fileName) {
        for (String s : getFiles(type)) {
            if (fileName.equals(s)) {
                Log.e(TAG, "要查询的文件名: " + fileName + ",找到该书：" + s);
                return true;
            }
        }
        Log.e(TAG, "要查询的书名: " + fileName + ",没有找到");
        return false;
    }

    /**
     * 获取存储目录下的文件列表
     *
     * @return
     */
    public static String[] getFiles(int type) {

        switch (type) {
            case COVER:
                return EBOOKCOVERFILE.list();
            case EBOOK:
                return EBOOKFILE.list();
        }
        return null;
    }

}
