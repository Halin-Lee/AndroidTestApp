package halin.me.fundamental.LogTools;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import halin.me.fundamental.R;


/**
 * Created by halin on 10/14/15.
 */
public class LogUtilGoogle extends MeasuringUtil {


    /**
     * 设备ID
     */
    private String deviceID;


    /**
     * 谷歌分析所使用的发送器
     */
    private Tracker tracker;

    /**
     * 谷歌分析初始化方法
     */
    void setup(Application application) {
        //初始化谷歌分析

        GoogleAnalytics analytics = GoogleAnalytics.getInstance(application);
        analytics.enableAutoActivityReports(application);

        tracker = analytics.newTracker(R.xml.google_tracker);
        tracker.enableAdvertisingIdCollection(true);

    }

    @Override
    void log(String message) {
        //谷歌分析不处理普通级别日志
    }

    @Override
    void logE(String message) {
        String logStr = String.format("%s | %s", deviceID, message);
        tracker.send(new HitBuilders.ExceptionBuilder().setDescription(logStr).setFatal(true).build());
    }

    @Override
    void trackDimension(int index, String message) {
        tracker.send(new HitBuilders.EventBuilder()
                        .setCustomDimension(index, message)
                        .build()
        );

    }

    @Override
    void trackMetric(int index, float message) {
        tracker.send(new HitBuilders.EventBuilder()
                        .setCustomMetric(index, message)
                        .build()
        );
    }

    @Override
    void trackEvent(String Category, String Action, String Label, long value) {
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(Category)
                .setAction(Action)
                .setLabel(Label)
                .setValue(value)
                .build());
    }
}
