package me.halin.testapp.AutoEventTracking;

import android.app.Activity;

import java.util.List;

/**
 * Created by Halin on 4/6/16.
 */
public class TrackPageInfo {

    private Class<? extends Activity> activityClass;
    private String name;
    private List<TrackEventItem> eventList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Class<? extends Activity> activityClass) {
        this.activityClass = activityClass;
    }
}
