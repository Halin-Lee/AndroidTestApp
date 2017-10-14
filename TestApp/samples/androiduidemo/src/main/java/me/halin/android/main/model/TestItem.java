package me.halin.android.main.model;

import android.app.Activity;

/**
 * 测试内容
 */
public class TestItem {

    public final String testName;
    public final String testGroup;
    public final Class<? extends Activity> activityClass;

    public TestItem(String testGroup, String testName, Class<? extends Activity> activityClass) {
        this.testName = testName;
        this.testGroup = testGroup;
        this.activityClass = activityClass;
    }


}
