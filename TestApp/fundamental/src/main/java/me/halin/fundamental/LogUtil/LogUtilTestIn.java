package me.halin.fundamental.LogUtil;

import android.content.Context;


/**
 * 云测测试工具
 * <p>
 * Created by halin on 10/14/15.
 */
public class LogUtilTestIn extends LogUtil {

    private static final String TestInKey = "a67471dacdc567298f9d526628979629";


    private Context mApplicationContext;

    public LogUtilTestIn(Context applicationContext) {
        mApplicationContext = applicationContext;

    }

    @Override
    void log(String message) {
    }

    @Override
    void logE(String message) {
    }
}
