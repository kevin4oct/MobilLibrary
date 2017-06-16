package com.hebth.mobilelibrary.utils;

/**
 * Created by hebth on 2017-06-15.
 * 存储文件的工具类
 */

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;

import com.hebth.mobilelibrary.MyApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class mFileUtils {

    /**
     * SD卡的状态
     */
    public static final String SDCARDSTATE = Environment.getExternalStorageState();

    /**
     * 文件在SD卡中存储的根路径
     */
//    public static final String SDCARDPATH = Environment.getExternalStorageDirectory().getPath();
    public static final String SDCARDPATH = MyApplication.getContext()
            .getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + File.separator + "ebooks")
            .getAbsolutePath();

    /**
     * 获取包名下files的路径
     *
     * @param context
     * @return 包名/files
     */
    public static String getFilePath(Context context) {
        return context.getApplicationContext().getFilesDir().getPath();
    }

    public static String getCahePath(Context context) {
        return context.getApplicationContext().getCacheDir().getPath();
    }

    /**
     * 保存文件
     *
     * @param data     数据内容
     * @param path     绝对路径
     * @param fileName 文件名
     * @return true 保存成功，false 保存失败
     */
    public static boolean saveFile(String data, String path, String fileName) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(file, fileName);
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write(data.getBytes());
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 读取文件
     *
     * @param path
     * @return
     */
    public static String readFile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            try {
                throw new Exception("it's not a file,please check!");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream in = new FileInputStream(file);
            byte[] b = new byte[in.available()];
            int read = in.read(b);
            while (read != -1) {
                sb.append(new String(b));
                read = in.read(b);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }


    /**
     * 删除路径下的：文件和文件夹，包括当前文件夹
     *
     * @param absoluteFilePath ：绝对路径
     * @return true:删除成功，false：删除失败
     * 注意：当前路径不存在时，也返回true
     */
    public static boolean deletFile(String absoluteFilePath) {
        File file = new File(absoluteFilePath);
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isFile()) {
                file.delete();
                return true;
            }
            if (!absoluteFilePath.endsWith(File.separator)) {
                absoluteFilePath = absoluteFilePath + File.separator;
            }
            if (file.isDirectory()) {
                if (file.listFiles().length == 0) {
                    file.delete();
                } else {
                    File[] files = file.listFiles();
                    for (File dirFile : files) {
                        deletFile(dirFile.getAbsolutePath());
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean saveToCahe(String data, String dir, String fileName, Context context) {
        String path = getCahePath(context) + dir;
        return saveFile(data, path, fileName);
    }

    public static String readFromCahe(String dir, Context context) {
        String path = getCahePath(context) + dir;
        return readFile(path);
    }

    public static boolean deletInCahe(String dir, Context context) {
        String path = getCahePath(context) + dir;
        return deletFile(path);
    }

    public static boolean clearCahe(Context context) {
        return deletFile(getCahePath(context));
    }

    /**
     * 将文件保存到应用包名/files目录下
     *
     * @param data     要保存的内容
     * @param dir      保存的相对路径，不包括文件名："/myproject/function1/aa"
     * @param fileName 文件名称："1.txt"
     * @return
     */
    public static boolean saveToFile(String data, String dir, String fileName, Context context) {
        String path = getFilePath(context) + dir;
        return saveFile(data, path, fileName);
    }

    /**
     * 从应用包名/files目录下读取文件
     *
     * @param dir     ："/dd/1.txt"
     * @param context
     * @return
     */
    public static String readFromFile(String dir, Context context) {
        String path = getFilePath(context) + dir;
        return readFile(path);
    }

    public static boolean deletInFile(String dir, Context context) {
        String path = getFilePath(context) + dir;
        return deletFile(path);
    }

    /**
     * 保存数据到SD卡上，
     *
     * @param data：要保存的数据内容
     * @param dir：文件的相对路径,"/aa/bb"
     * @param fileName：文件名,"1.txt"
     * @return boolean 是否保存成功，true保存成功，false保存失败
     */
    public static boolean saveToSDCard(String data, String dir, String fileName) {
        if (!Environment.MEDIA_MOUNTED.equals(SDCARDSTATE)) {
            try {
                throw new Exception("SDCard state error");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return saveFile(data, SDCARDPATH + dir, fileName);
    }

    /**
     * @param relativePath 文件r在sd卡中的路径："/bb/dd/1.txt"
     * @return String 文件内容
     */
    public static String getFromSDCard(String relativePath) {
        String path = SDCARDPATH + relativePath;
        return readFile(path);
    }

    /**
     * 从SD卡上删除文件
     *
     * @param path
     * @return 是否删除文件成功
     */
    public static boolean deletFileInSDCard(String path) {
        return deletFile(SDCARDPATH + path);
    }

    /**
     * 获得SD卡总大小
     *
     * @return
     */
    public static String getSDTotalSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return Formatter.formatFileSize(MyApplication.getContext(), blockSize * totalBlocks);
    }

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
//        return Formatter.formatFileSize(MyApplication.getContext(), blockSize * availableBlocks);
    }

    /**
     * 获得机身内存总大小
     *
     * @return
     */
    public static String getRomTotalSize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return Formatter.formatFileSize(MyApplication.getContext(), blockSize * totalBlocks);
    }

    /**
     * 获得机身可用内存
     *
     * @return
     */
    public String getRomAvailableSize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return Formatter.formatFileSize(MyApplication.getContext(), blockSize * availableBlocks);
    }

}
