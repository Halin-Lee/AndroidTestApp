package yqtrack.app.androiduidemo.main.model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import yqtrack.app.androiduidemo.coordinatorlayout.CoordinatorLayoutAppBarLayoutActivity;
import yqtrack.app.androiduidemo.coordinatorlayout.CoordinatorLayoutCollapsingToolbarLayoutActivity;
import yqtrack.app.androiduidemo.coordinatorlayout.CoordinatorLayoutSnackbarActivity;
import yqtrack.app.androiduidemo.drawerlayout.DrawerLayoutActivity;
import yqtrack.app.androiduidemo.navigationview.NavigationViewActivity;
import yqtrack.app.androiduidemo.toolbar.ToolbarActivity;

/**
 * /**
 * 测试参数构造
 * <p>
 * Created by halin on 9/17/15.
 */
public class TestBuilder {

    public final List<TestItem> testList = new ArrayList<>();

    public List<TestItem> build() {


        String drawerTestGroupName = "Drawer Layout Test";
        add(drawerTestGroupName, drawerTestGroupName, DrawerLayoutActivity.class);

        String toolBarGroupName = "Tool Bar Test";
        add(toolBarGroupName, toolBarGroupName, ToolbarActivity.class);

        String navigationViewGroupName = "Navigation View Test";
        add(navigationViewGroupName, navigationViewGroupName, NavigationViewActivity.class);


        String coordinatorLayoutGroupName = "Coordinator Layout Test";
        add(coordinatorLayoutGroupName, "Snackbar", CoordinatorLayoutSnackbarActivity.class);
        add(coordinatorLayoutGroupName, "App Bar Layout", CoordinatorLayoutAppBarLayoutActivity.class);
        add(coordinatorLayoutGroupName, "Collapsing Toolbar", CoordinatorLayoutCollapsingToolbarLayoutActivity.class);
        return testList;
    }


    protected void add(String groupName, String testName, Class<? extends Activity> clazz) {
        TestItem testItem = new TestItem(groupName, testName, clazz);
        testList.add(testItem);
    }

}
