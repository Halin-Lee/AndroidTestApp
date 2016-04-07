package me.halin.testapp.AutoEventTracking;

import me.halin.testapp.LogUtil.Logger;

/**
 * Created by 17track on 4/7/16.
 */
public class EventTrackerDefaultCallback implements EventTrackerCallback {
    @Override
    public void callback(String page, String prefix, TrackEventItem item, String name) {
        Logger.debug("页面:%s %s 事件:%s", page, prefix, name);
    }
}
