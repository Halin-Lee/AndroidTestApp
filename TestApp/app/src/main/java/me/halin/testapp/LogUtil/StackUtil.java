package me.halin.testapp.LogUtil;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * 堆栈打印工具
 * <p/>
 * Created by halin on 2/1/16.
 */
public class StackUtil {

    //region logger辅助方法

    /**
     * 获得Throwable堆栈
     */
    public static String readThrowableStackTrace(Throwable throwable) {
        StringWriter errors = new StringWriter();
        throwable.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

    /**
     * 获得Throwable堆栈
     */
    public static String readCurrentStackTrace() {
        return Arrays.toString(Thread.currentThread().getStackTrace());
    }


    //endregion
}
