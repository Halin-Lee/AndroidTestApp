package me.halin.fundamental.Tools;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Printer;

import java.util.Arrays;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by Halin on 8/12/16.
 */
public class WatchDogService implements Printer, Runnable {
    public static final String TAG = WatchDogService.class.getName();
    public static final boolean DEBUG = false;

    private static final WatchDogService instance = new WatchDogService();

    public static WatchDogService getInstance() {
        return instance;
    }

    private WatchDogService() {

    }

    private static final int DEFAULT_TIME_OUT = 500;
    private Thread watchDogThread;
    private Looper watchDogLooper;
    private Handler watchDogHandler;
    private boolean isInMessage = false;
    /**
     * 事件超时时间
     */
    private long timeout = DEFAULT_TIME_OUT;

    public void setup() {
        if (watchDogThread != null) {
            Logger.logE(TAG, "看门狗程序已初始化");
        } else {
            watchDogThread = new Thread() {
                @Override
                public void run() {
                    Looper.prepare();
                    watchDogLooper = Looper.myLooper();
                    watchDogHandler = new Handler(watchDogLooper);
                    Looper.loop();
                }
            };
            watchDogThread.start();

            Looper.getMainLooper().setMessageLogging(this);
            Logger.log(TAG, "看门狗程序初始化完成");
        }
    }


    @Override
    public void println(String x) {
        if (x.contains("Dispatching")) {
            if (isInMessage) {
                Logger.logE(TAG, "连续收到两次进入 Message 事件");
                return;
            }
            isInMessage = true;
            watchDogHandler.removeCallbacks(this);
            watchDogHandler.postDelayed(this, timeout);
            if (DEBUG)
                Logger.log(TAG, "进入 Message");
        } else if (x.contains("Finished")) {
            isInMessage = false;
            watchDogHandler.removeCallbacks(this);
            if (DEBUG)
                Logger.log(TAG, "退出 Message");
        } else {
            Logger.logE(TAG, "收到未能识别的事件");
            quit();
        }
    }

    @Override
    public void run() {
        String stack = Arrays.toString(ThreadTools.getMainThread().getStackTrace());
        Logger.logE(TAG, "超过 %d 秒主线程无响应,堆栈:%s", timeout, stack);
    }

    public void quit() {
        Looper.getMainLooper().setMessageLogging(null);
        watchDogLooper.quit();
    }


    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
