package halin.me.fundamental.LogTools;

/**
 * 日志常量
 * <p/>
 * Created by halin on 10/14/15.
 */
public class LoggerConstant {

    /**
     * 是否开启调试模式
     */
    static final boolean DEBUG = false;

    /**
     * 事件统计,类别,点击事件
     */
    public static final String EVENT_CATEGORY_CLICK_EVENT = "CLICK_EVENT";

    /**
     * 事件统计,事件,过滤单号点击
     */
    public static final String EVENT_ACTION_FILTER_TRACK_NO_CLICK = "EVENT_ACTION_FILTER_TRACK_NO_CLICK";

    /**
     * 事件统计,类别,异常
     */
    public static final String EVENT_CATEGORY_ERROR = "ERROR";

    /**
     * 事件统计,事件,翻译失败
     */
    public static final String EVENT_ACTION_TRANSLATE_ERROR = "EVENT_ACTION_TRANSLATE_ERROR";

    /**
     * 事件统计,事件,查询失败
     */
    public static final String EVENT_ACTION_TRACK_ERROR = "EVENT_ACTION_TRACK_ERROR";

    /**
     * 事件统计,标签,网络失败
     */
    public static final String EVENT_LABEL_NETWORK_ERROR = "EVENT_LABEL_NETWORK_ERROR";

    /**
     * 事件统计,标签,服务器返回异常
     */
    public static final String EVENT_LABEL_SERVER_ERROR = "EVENT_LABEL_SERVER_ERROR";

    /**
     * 事件统计,标签,服务器返回异常
     */
    public static final String EVENT_LABEL_UNKNOWN_HOST = "EVENT_LABEL_UNKNOWN_HOST";

    /**
     * 事件统计,事件,后台服务失败
     */
    public static final String EVENT_ACTION_BACKEND_SERVICE_ERROR = "EVENT_ACTION_BACKEND_SERVICE_ERROR";
}
