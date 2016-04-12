package me.halin.fundamental.LogUtil;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;


/**
 * Created by halin on 10/14/15.
 */
public class LogUtilGoogle extends MeasuringUtil {


    private static final String GOOGLE_ANALYTICS_KEY_SCREEN_NAME = "&cd";

    /**
     * 设备ID
     */
    private String userID;


    /**
     * 谷歌分析所使用的发送器
     */
    private Tracker tracker;


    /**
     * 最后一个呈现的页面
     */
    private String latestScreen;
    

    /**
     * 谷歌分析初始化方法
     */
    public LogUtilGoogle(Application application, int trackID, String uid) {
        //初始化谷歌分析
//        Application application = context;

        GoogleAnalytics analytics = GoogleAnalytics.getInstance(application);
        analytics.enableAutoActivityReports(application);

        tracker = analytics.newTracker(trackID);
        tracker.enableAdvertisingIdCollection(true);

        //设置自定义的错误打印方法
        ExceptionReporter exceptionDetailReporter = new ExceptionReporter(
                tracker,
                Thread.getDefaultUncaughtExceptionHandler(),
                application);
        exceptionDetailReporter.setExceptionParser(new ExceptionDetailParser(application, new ArrayList()));
        Thread.setDefaultUncaughtExceptionHandler(exceptionDetailReporter);

        //设置deviceID
        userID = uid;
    }

    @Override
    void log(String message) {
        //谷歌分析不处理普通级别日志
    }

    @Override
    void logE(String message) {
        String logStr = String.format(Locale.ENGLISH, "%s | %s", userID, message);
        tracker.send(new HitBuilders.ExceptionBuilder().setDescription(logStr).setFatal(true).build());
    }

    @Override
    void trackDimension(int index, String message) {
        tracker.send(new HitBuilders.ScreenViewBuilder()
                        .setCustomDimension(index, message)
                        .build()
        );

    }

    @Override
    void trackMetric(int index, float message) {
        tracker.send(new HitBuilders.ScreenViewBuilder()
                        .setCustomMetric(index, message)
                        .build()
        );
    }

    @Override
    void trackEvent(String Category, String Action, String Label, long value) {


        String localScreenName = tracker.get(GOOGLE_ANALYTICS_KEY_SCREEN_NAME);
     /*   if (latestScreen != localScreenName) {
            //当前屏幕名称与之前名称不同,该事件为新页面第一次点击事件,这部分统计有个不准确的地方,
            // 1.当用户跳转到其他页面但是没有触发任何事件的时候,回到之前屏幕的事件不会当做第一事件
            // 2.当用户跳转并触发事件的时候,回到之前页面的事件会当成第一事件
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory(LoggerConstant.LOGGER_EVENT_CATEGORY_FIRST_EVENT)
                    .setAction(Action)
                    .setLabel(localScreenName)
                    .setValue(value)
                    .build());

            latestScreen = localScreenName;
        }*/

        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(Category)
                .setAction(Action)
                .setLabel(Label)
                .setValue(value)
                .build());
    }

    @Override
    void trackTiming(String category, String variable, String label, long value) {

        tracker.send(new HitBuilders.TimingBuilder()
                .setCategory(category)
                .setValue(value)
                .setVariable(variable)
                .setLabel(label)
                .build());

    }


    public class ExceptionDetailParser extends StandardExceptionParser {

        public ExceptionDetailParser(Context context, Collection<String> additionalPackages) {
            super(context, additionalPackages);
        }

        @Override
        public String getDescription(String s, Throwable throwable) {

            //获得原本日志
            String standardDescription = super.getDescription(s, throwable);

            //获得堆栈信息
            String stack = StackUtil.readThrowableStackTrace(throwable);

            String exceptionDescription = String.format(Locale.ENGLISH, "%s | 程序崩溃: %s  | %s", userID, standardDescription, stack);

            //拼接打印文本,谷歌限制上报信息只能有150个字符
//            if (exceptionDescription.length() > 150)
//                exceptionDescription = exceptionDescription.substring(0, 149);

            return exceptionDescription;
        }
    }


}

