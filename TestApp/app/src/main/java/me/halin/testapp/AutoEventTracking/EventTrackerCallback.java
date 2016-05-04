package me.halin.testapp.AutoEventTracking;

/**
 * 跟踪事件回调
 * Created by Halin on 4/6/16.
 */
public interface EventTrackerCallback {
    /**
     * 事件回调,
     *
     * @param page   页面名称;
     * @param prefix 页面名称前缀(用于类似webview这种,相同页面显示不同内容的)
     * @param item   跟踪项,可能为空(跟踪未添加的事件时为空)
     * @param name   项目名称
     */
    void callback(String page, String prefix, TrackEventItem item, String name);
}
