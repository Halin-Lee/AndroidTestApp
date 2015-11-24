package halin.me.fundamental.LogTools;

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
     * @param Category 分类
     * @param Action   动作
     * @param Label    标签
     * @param value    值
     */
    abstract void trackEvent(String Category, String Action, String Label, long value);
}
