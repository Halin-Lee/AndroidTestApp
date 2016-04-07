package me.halin.testapp.LogUtil;

import me.halin.testapp.LogUtil.LogUtil;

/**
 * Created by halin on 10/14/15.
 */
public abstract class MeasuringUtil extends LogUtil {

    /**
     * 维度统计方法
     *
     * @param index   维度
     * @param message 值
     */
    abstract void trackDimension(int index, String message);

    /**
     * 指标统计方法
     *
     * @param index   指标
     * @param message 值
     */
    abstract void trackMetric(int index, float message);

    /**
     * 事件上报方法
     *
     * @param category 分类
     * @param action   动作
     * @param label    标签
     * @param value    值
     */
    abstract void trackEvent(String category, String action, String label, long value);

    /**
     * 事件上报方法
     *
     * @param category 分类
     * @param variable 动作
     * @param label    标签
     * @param value    值
     */
    abstract void trackTiming(String category, String variable, String label, long value);


}
