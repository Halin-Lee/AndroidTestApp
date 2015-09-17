package halin.me.testapp.main.Model;

import android.app.Activity;

/**测试内容*/
public class TestItem {

    public final String testName;
    public final Class<? extends Activity> activityClass;

    public TestItem(String testName, Class<? extends Activity> activityClass) {
        this.testName = testName;
        this.activityClass = activityClass;
    }


}
