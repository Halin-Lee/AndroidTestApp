package me.halin.fundamental.LogUtil;

/**
 * Created by halin on 2/17/16.
 */
public class LoggerConstant {


    /**
     * 事件统计,类别,UI事件
     */
    public static final String LOGGER_EVENT_CATEGORY_UI_EVENT = "UI事件";

    //region - 第一点击事件
    public static final String LOGGER_EVENT_CATEGORY_FIRST_EVENT = "页面第一事件";

    //endregion

    //region - 特殊事件

    public static final String LOGGER_EVENT_CATEGORY_SPECIAL_EVENT = "特殊事件";


    //endregion


    //region -  异常
    /**
     * 事件统计,类别,异常
     */
    public static final String LOGGER_EVENT_CATEGORY_ERROR = "异常";


    /**
     * 事件统计,标签,网络异常
     */
    public static final String LOGGER_EVENT_LABEL_NETWORK_ERROR = "网络异常";

    /**
     * 事件统计,标签,服务器返回异常
     */
    public static final String LOGGER_EVENT_LABEL_SERVER_ERROR = "服务器返回异常";

    /**
     * 事件统计,标签,域名无法访问
     */
    public static final String LOGGER_EVENT_LABEL_UNKNOWN_HOST = "域名无法访问";

    //endregion


    /**
     * 事件统计,类别,网络耗时
     */
    public static final String LOGGER_EVENT_CATEGORY_NETWORK_TIME_CONSUMING = "网络耗时";

}
