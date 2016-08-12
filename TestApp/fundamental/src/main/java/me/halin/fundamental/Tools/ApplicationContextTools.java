package me.halin.fundamental.Tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by halin on 1/12/16.
 */
public class ApplicationContextTools {

    private static final String TAG = ApplicationContextTools.class.getName();

    private static Context applicationContext;

    private static String sVersionName;
    private static int sVersionCode;

    /**
     * 是否是低端设备
     */
    private static boolean isLowEndDevice;


    /***/
    @VisibleForTesting
    public static void setup(Context context) {
        setup(context, "1", 1);
    }

    public static void setup(Context context, String versionName, int versionCode) {

        applicationContext = context;
        sVersionName = versionName;
        sVersionCode = versionCode;

        ThreadTools.setup(context);

        long totalMemory = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityManager actManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
            actManager.getMemoryInfo(memInfo);
            totalMemory = memInfo.totalMem;
            if (totalMemory < 600 * 1000 * 1000)    //600M
                isLowEndDevice = true;
        } else {
            isLowEndDevice = true; //4.1一下默认当做低端设备
        }

        Log.i(TAG, "设备信息初始化完成 总内存大小:" + totalMemory + ", 低端设备:" + isLowEndDevice);
    }

    public static Context getApplicationContext() {
        return applicationContext;
    }


    public static PackageInfo getPackageInfo() {
        PackageInfo pi = null;

        try {
            PackageManager pm = getApplicationContext().getPackageManager();
            pi = pm.getPackageInfo(getApplicationContext().getPackageName(),
                    0);
            return pi;
        } catch (Exception e) {
            Logger.logE(TAG, "获得PackageInfo失败 %s", e);
        }

        return pi;
    }

    /**
     * 版本号
     */
    public static int getVersionCode() {
        return sVersionCode;
    }

    /**
     * 版本名称
     */
    public static String getVersionName() {
        return sVersionName;
    }

    /**
     * 是否是低端设备
     */
    public static boolean isLowEndDevice() {
        return isLowEndDevice;
    }




}
