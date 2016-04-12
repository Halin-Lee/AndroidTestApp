package me.halin.fundamental.LogUtil;

import android.util.Log;

import java.util.Locale;

/**
 * @Title: Logger
 * @Copyright: © Copyright 2010-2015 17track Rights Reserved
 * @Description: Logger工具类 用于打印上传log,
 * @author: YAOZHONGWU
 * @data: 2015/7/10 9:37
 * @version: V1.0
 */
public class Logger {

    public static final String TAG = Logger.class.getName();

    /**
     * 调试日志TAG
     */
    public static final String DEBUG = "DEBUG";

    /**
     * 运行日志TAG
     */
    public static final String LOG = "LOG";

    /**
     * 单例懒加载模式
     */
    private static final Logger mInstance = new Logger();

    private Logger() {
        logUtil = new LogUtil() {
            @Override
            void log(String message) {
                Log.e(LOG, message);
            }

            @Override
            void logE(String message) {
                Log.e(LOG, message);
            }
        };
    }

    /**
     * 日志工具
     */
    private LogUtil logUtil;

    public static boolean isDebug() {
        return mInstance.isDebug;
    }

    private static boolean isDebug;

    public static void setup(LogUtil logUtil, boolean isDebug) {
        mInstance.logUtil = logUtil;
        mInstance.isDebug = isDebug;
        Logger.log(TAG, "日志工具 %s 初始化完成", logUtil.getClass().getName());

    }

    /**
     * 调试日志,临时调试用,正式发布需删除
     */
    public static void debug(String format, Object... args) {
        String formatStr;
        formatStr = String.format(Locale.ENGLISH, format, args);
        Log.i(DEBUG, formatStr);
    }

    /**
     * 格式化普通日志
     *
     * @param tag 标签
     */
    public static void log(String tag, String format, Object... args) {
        String formatStr;
        if (args == null || args.length == 0) {
            //当没有附加参数时不格式化
            formatStr = format;
        } else {
            formatStr = String.format(Locale.ENGLISH, format, args);
        }
        String logStr = String.format(Locale.ENGLISH, "%s |  %s", tag, formatStr);
        if (isDebug) {
            Log.i(LOG, logStr);
        }
        mInstance.logUtil.log(logStr);
    }

    /**
     * 异常级别日志
     *
     * @param tag 标签
     */
    public static void logE(String tag, String format, Object... args) {
        String formatStr;
        if (args == null || args.length == 0) {
            //当没有附加参数时不格式化
            formatStr = format;
        } else {
            formatStr = String.format(Locale.ENGLISH, format, args);
        }
        if (isDebug) {
            Log.e(tag, formatStr);
        }

        String logStr = String.format(Locale.ENGLISH, "%s | %s", tag, formatStr);
        mInstance.logUtil.logE(logStr);
    }

    /**
     * 上传维度
     *
     * @param index 维度
     * @param value 值
     */
    public static void trackDimension(int index, String value) {
        if (isDebug) {
            Log.i(LOG, "上传维度 :" + index + " ,数值:" + value);
        }
        if (mInstance.logUtil instanceof MeasuringUtil) {
            //分析工具,上报分析
            ((MeasuringUtil) mInstance.logUtil).trackDimension(index, value);
        }
    }

    /**
     * 上传指标
     *
     * @param index 指标
     * @param value 值
     */
    public static void trackMetric(int index, float value) {
        if (isDebug) {
            Log.d(LOG, "上传指标 :" + index + " ,数值:" + value);
        }
        if (mInstance.logUtil instanceof MeasuringUtil) {
            //分析工具,上报分析
            ((MeasuringUtil) mInstance.logUtil).trackMetric(index, value);
        }
    }

    /**
     * 上传事件
     *
     * @param category 分类
     * @param action   动作
     * @param label    标签
     * @param value    值
     */
    public static void trackEvent(String category, String action, String label, long value) {
        if (isDebug) {
            String logStr = String.format(Locale.ENGLISH, "上传事件 类别:%s 事件:%s 标签:%s 数值%d", category, action, label, value);
            Log.d(LOG, logStr);
        }
        if (mInstance.logUtil instanceof MeasuringUtil) {
            //分析工具,上报分析
            ((MeasuringUtil) mInstance.logUtil).trackEvent(category, action, label, value);
        }
    }

    /**
     * 统计时间
     * 注:此部分有两种做法,当Volley的Request复写时,直接由VolleyRequest上报,否则由调用者上报
     *
     * @param category      分类
     * @param variable      动作
     * @param label         标签
     * @param timeConsuming 值
     */
    public static void trackTiming(String category, String variable, String label, long timeConsuming) {

        if (isDebug) {
            String logStr = String.format(Locale.ENGLISH, "统计耗时 类别:%s 事件:%s 标签:%s  时间:%d毫秒", category, variable, label, timeConsuming);
            Log.d(LOG, logStr);
        }
        if (mInstance.logUtil instanceof MeasuringUtil) {
            //分析工具,上报分析
            ((MeasuringUtil) mInstance.logUtil).trackTiming(category, variable, label, timeConsuming);
        }

    }


}
