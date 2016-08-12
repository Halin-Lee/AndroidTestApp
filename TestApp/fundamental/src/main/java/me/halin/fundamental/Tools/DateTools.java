package me.halin.fundamental.Tools;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.fundamental.LogUtil.StackUtil;


/**
 * Created by halin on 1/12/16.
 */
public class DateTools {

    public static final String SERVER_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String parseDateToString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    public static Date parseStringToDate(String string) {
        return parseStringToDateWithPattern(string, "yyyy-MM-dd HH:mm");
    }

    public static Date parseStringToDateWithPattern(String string, String pattern) {

        if (TextUtils.isEmpty(string)) {
            String stack = StackUtil.readCurrentStackTrace();
            Logger.logE(DateTools.class.getName(), "输入时间格式为空,格式:%s,堆栈:%s", pattern, stack);
            return new Date();
        }

        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = new Date();
        try {
            date = formatter.parse(string);
        } catch (ParseException e) {
            String stack = StackUtil.readCurrentStackTrace();
            Logger.logE(DateTools.class.getName(), "时间格式转换失败,输入:%s,格式:%s,堆栈:%s", string, pattern, stack);
        } finally {
            return date;
        }
    }


}
