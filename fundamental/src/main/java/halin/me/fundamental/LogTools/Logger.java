package halin.me.fundamental.LogTools;

import android.app.Application;
import android.util.Log;

/**
 * @Title: yqtrack.app.Foundamental.LogTools
 * @Copyright: © Copyright 2010-2015 17track Rights Reserved
 * @Description: Logger工具类 用于打印上传log,
 * @author: YAOZHONGWU
 * @data: 2015/7/10 9:37
 * @version: V1.0
 */
public class Logger {

    public static final String TAG = "Logger";
    /**
     * 单例懒加载模式
     */
    private static final Logger mInstance = new Logger();

    /**
     * 日志工具
     */
    private LogUtil logUtil;

    /**
     * 需要用到时才调用的初始化方法
     */
    public static void init(Application application) {
        mInstance.setup(application);
    }

    /**
     * 初始化,根据日志级别加载对应日志工具
     */
    private void setup(Application application) {
        if (LoggerConstant.DEBUG) {
            //调试使用testIn日志工具
            logUtil = LoggerType.LoggerTypeTestIn.getLogUtil();
        } else {
        }
        logUtil.setup(application);
        Logger.log("日志工具%s初始化完成", TAG);
    }

    /**
     * 调试日志,临时调试用,正式发布需删除
     */
    public static void debug(String format, Object... args) {
        Log.d("Debug", String.format(format, args));
    }


    /**
     * 格式化普通日志
     *
     * @param tag 标签
     */
    public static void log(String tag, String format, Object... args) {
        String formatStr = String.format(format, args);
        String logStr = String.format("%s |  %s", tag, formatStr);
        if (LoggerConstant.DEBUG) {
            Log.d("DebugLog", logStr);
        }
        mInstance.logUtil.log(logStr);
    }


    /**
     * 异常级别日志
     *
     * @param tag 标签
     */
    public static void logE(String tag, String format, Object... args) {
        String formatStr = String.format(format, args);
        if (LoggerConstant.DEBUG) {
            Log.e(tag, formatStr);
        }

        String logStr = String.format("%s |  %s", tag, formatStr);
        mInstance.logUtil.logE(logStr);
    }

    /**
     * 上传维度
     *
     * @param index 维度
     * @param value 值
     */
    public static void trackDimension(int index, String value) {
        if (LoggerConstant.DEBUG) {
            Log.d("DebugLog", "上传维度 :" + index + " ,数值:" + value);
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
        if (LoggerConstant.DEBUG) {
            Log.d("DebugLog", "上传指标 :" + index + " ,数值:" + value);
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
        if (LoggerConstant.DEBUG) {
            String logStr = String.format("上传时间 类别:%s 事件:%s 标签:%s 数值%d", category, action, label, value);
            Log.d("DebugLog", logStr);
        }
        if (mInstance.logUtil instanceof MeasuringUtil) {
            //分析工具,上报分析
            ((MeasuringUtil) mInstance.logUtil).trackEvent(category, action, label, value);
        }
    }
}
