package me.halin.fundamental.Tools;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;

import java.util.Iterator;
import java.util.List;

import me.halin.fundamental.LogUtil.Logger;


/**
 * Created by halin on 1/13/16.
 */
public class ThreadTools {

    private static final String TAG = ThreadTools.class.getName();

    /**
     * 获取到主线程的handler
     */
    private static Handler sMainThreadHandler = null;


    /**
     * 获取到主线程
     */
    private static Thread sMainThread = null;
    /**
     * 获取到主线程的id
     */
    private static int sMainThreadID;


    /**
     * 是否在主进程
     */
    private static boolean isInMainProcess;


    /**
     * 检查是否是主进程
     */
    public static void setup(Context context) {
        sMainThreadHandler = new Handler(Looper.getMainLooper());
        sMainThread = Thread.currentThread();
        sMainThreadID = android.os.Process.myTid();

        //检查Process
        int myPid = android.os.Process.myPid();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List runningAppProcesses = am.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            //在App清除数据后,点击小插件会导致RunningAppProcesses为空
            isInMainProcess = true;
            return;
        }


        Iterator i = runningAppProcesses.iterator();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == myPid) {
                    if (info.processName.equals(context.getPackageName())) {
                        isInMainProcess = true;
                        return;
                    }
                }
            } catch (Exception e) {
            }
        }
        isInMainProcess = false;
        Logger.log(TAG, "Process 初始化完成 pid:" + myPid + ", isMainProcess:" + isInMainProcess);
    }


    /**
     * 获取到主线程的handler的get方法
     *
     * @return
     */
    public static Handler getMainThreadHandler() {
        return sMainThreadHandler;
    }


    /**
     * 获取到主线程的get方法
     *
     * @return
     */
    public static Thread getMainThread() {
        return sMainThread;
    }

    /**
     * 获取到主线程id的get方法
     *
     * @return
     */
    public static int getMainThreadId() {
        return sMainThreadID;
    }

    /**
     * 是否在主进程
     */
    public static boolean isInMainProcess() {
        return isInMainProcess;
    }

    /**
     * 判断当前的线程是不是在主线程
     */
    public static boolean isRunInMainThread() {
        return android.os.Process.myTid() == getMainThreadId();
    }


    /**
     * 延时在主线程执行runnable
     */
    public static boolean postDelayed(Runnable runnable, long delayMillis) {
        return sMainThreadHandler.postDelayed(runnable, delayMillis);
    }

    /**
     * 在主线程执行runnable
     */
    public static boolean post(Runnable runnable) {
        return sMainThreadHandler.post(runnable);
    }

    /**
     * 从主线程looper里面移除runnable
     */
    public static void removeCallbacks(Runnable runnable) {
        sMainThreadHandler.removeCallbacks(runnable);
    }

    /**
     * 让线程在主线程上运行
     */
    public static void runInMainThread(Runnable runnable) {
        if (isRunInMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    @VisibleForTesting
    public static void setMainThreadHandler(Handler mainThreadHandler) {
        sMainThreadHandler = mainThreadHandler;
    }

}
