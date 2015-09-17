package halin.me.testapp.main.Model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**测试组*/
public class TestGroup {

    public final String groupName;
    public final List<TestItem> items = new ArrayList<>();

    public TestGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(String itemName, Class<? extends Activity> clazz) {
        items.add(new TestItem(itemName, clazz));
    }
}
