package me.halin.fundamental.LogUtil;

/**
 * 日志工具抽象类
 * <p/>
 * Created by halin on 10/14/15.
 */
public abstract class LogUtil {


    /**
     * 普通级别日志
     */
    abstract void log(String message);

    /***
     * 异常级别日志
     */
    abstract void logE(String message);


}
