package me.halin.android.main.model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import me.halin.android.parentactivity.ParentActivity;
import me.halin.android.ui.cardview.CardViewActivity;
import me.halin.android.ui.coordinatorlayout.CoordinatorLayoutAppBarLayoutActivity;
import me.halin.android.ui.coordinatorlayout.CoordinatorLayoutCollapsingToolbarLayoutActivity;
import me.halin.android.ui.coordinatorlayout.CoordinatorLayoutSnackbarActivity;
import me.halin.android.ui.drawerlayout.DrawerLayoutActivity;
import me.halin.android.ui.inputtextlayout.TextInputLayoutActivity;
import me.halin.android.ui.navigationview.NavigationViewActivity;
import me.halin.android.ui.toolbar.ToolbarActivity;

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

        String textInputLayoutGroupName = "Text Input Layout Test";
        add(textInputLayoutGroupName, "Text Input Layout", TextInputLayoutActivity.class);

        String cardViewGroupName = "Card View Test";
        add(cardViewGroupName, "Card View", CardViewActivity.class);

        String parentActivityGroupName = "Parent Activity Test";
        add(parentActivityGroupName, parentActivityGroupName, ParentActivity.class);
        return testList;
    }


    protected void add(String groupName, String testName, Class<? extends Activity> clazz) {
        TestItem testItem = new TestItem(groupName, testName, clazz);
        testList.add(testItem);
    }

}
