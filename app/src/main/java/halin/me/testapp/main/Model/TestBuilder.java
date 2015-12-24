package halin.me.testapp.main.Model;

import java.util.ArrayList;
import java.util.List;

import halin.me.testapp.DataBinding.AdvancedBinding.DataBindingAdvancedBindingActivity;
import halin.me.testapp.DataBinding.AttributeSetter.DataBindingAttributeSetterActivity;
import halin.me.testapp.DataBinding.Base.DataBindingBaseActivity;
import halin.me.testapp.DataBinding.Custom.DataBindingCustomActivity;
import halin.me.testapp.DataBinding.DataObjects.DataBindingObservableCollectionActivity;
import halin.me.testapp.DataBinding.DataObjects.DataBindingObservableFieldActivity;
import halin.me.testapp.DataBinding.DataObjects.DataBindingObservableObjectActivity;
import halin.me.testapp.DataBinding.DemoList.DataBindingDemoListActivity;
import halin.me.testapp.DataBinding.Event.DataBindingEventActivity;
import halin.me.testapp.DataBinding.Expression.DataBindingExpressionActivity;
import halin.me.testapp.DataBinding.GeneratedBinding.DataBindingGeneratedBindingActivity;
import halin.me.testapp.DataBinding.Import.DataBindingImportActivity;
import halin.me.testapp.DataBinding.Include.DataBindingIncludeActivity;
import halin.me.testapp.DataBinding.List.DataBindingListActivity;
import halin.me.testapp.DataBinding.Observable.DataBindingObservableActivity;
import halin.me.testapp.RecycleView.Base.RecycleViewBaseActivity;
import halin.me.testapp.testdemo.espresso.example.EspressoTestActivity;

/**
 * 测试参数构造
 * <p/>
 * Created by halin on 9/17/15.
 */
public class TestBuilder {

    public final List<TestItem> testList = new ArrayList<>();

    public List<TestItem> build() {

        //DataBinding;
        String dataBindingTestGroupName = "DataBinding测试";
        add(dataBindingTestGroupName, "DataBinder测试", DataBindingBaseActivity.class);
        add(dataBindingTestGroupName, "DataBinderList测试", DataBindingListActivity.class);
        add(dataBindingTestGroupName, "DataBinder事件绑定测试", DataBindingEventActivity.class);
        add(dataBindingTestGroupName, "DataBinder导入测试", DataBindingImportActivity.class);
        add(dataBindingTestGroupName, "自定义DataBinder", DataBindingCustomActivity.class);
        add(dataBindingTestGroupName, "Include测试", DataBindingIncludeActivity.class);
        add(dataBindingTestGroupName, "Expression测试", DataBindingExpressionActivity.class);
        add(dataBindingTestGroupName, "ObservableObject测试", DataBindingObservableObjectActivity.class);
        add(dataBindingTestGroupName, "ObservableField测试", DataBindingObservableFieldActivity.class);
        add(dataBindingTestGroupName, "ObservableCollection测试", DataBindingObservableCollectionActivity.class);
        add(dataBindingTestGroupName, "GeneratedBinding绑定测试", DataBindingGeneratedBindingActivity.class);
        add(dataBindingTestGroupName, "AdvancedBinding动态绑定测试", DataBindingAdvancedBindingActivity.class);
        add(dataBindingTestGroupName, "DataBinding Demo", DataBindingDemoListActivity.class);
        add(dataBindingTestGroupName, "Observable测试", DataBindingObservableActivity.class);
        add(dataBindingTestGroupName, "DataBinding Attribute Setter", DataBindingAttributeSetterActivity.class);

        //recycleView
        String recycleViewTestGroupName = "RecycleView测试";
        add(recycleViewTestGroupName, "RecycleViewBase测试", RecycleViewBaseActivity.class);

        //testDemo
        String testDemoGroupName = "测试用例编写";
        add(testDemoGroupName, "Espresso测试", EspressoTestActivity.class);

        return testList;
    }


    public List<TestItem> build2() {

        //DataBinding;
        String dataBindingTestGroupName = "DataBinding测试";
        add(dataBindingTestGroupName, "DataBinder测试", DataBindingBaseActivity.class);
        add(dataBindingTestGroupName, "DataBinderList测试", DataBindingListActivity.class);
        add(dataBindingTestGroupName, "DataBinder事件绑定测试", DataBindingEventActivity.class);
        add(dataBindingTestGroupName, "DataBinder导入测试", DataBindingImportActivity.class);
        add(dataBindingTestGroupName, "自定义DataBinder", DataBindingCustomActivity.class);
        add(dataBindingTestGroupName, "Include测试", DataBindingIncludeActivity.class);
        add(dataBindingTestGroupName, "Expression测试", DataBindingExpressionActivity.class);
        add(dataBindingTestGroupName, "ObservableObject测试", DataBindingObservableObjectActivity.class);
        add(dataBindingTestGroupName, "ObservableField测试", DataBindingObservableFieldActivity.class);
        add(dataBindingTestGroupName, "ObservableCollection测试", DataBindingObservableCollectionActivity.class);
        add(dataBindingTestGroupName, "GeneratedBinding绑定测试", DataBindingGeneratedBindingActivity.class);
        add(dataBindingTestGroupName, "AdvancedBinding动态绑定测试", DataBindingAdvancedBindingActivity.class);
        add(dataBindingTestGroupName, "DataBinding Demo", DataBindingDemoListActivity.class);
        add(dataBindingTestGroupName, "Observable测试", DataBindingObservableActivity.class);

        //recycleView
        String recycleViewTestGroupName = "RecycleView测试";
        add(recycleViewTestGroupName, "RecycleViewBase测试", RecycleViewBaseActivity.class);


        return testList;
    }

    protected void add(String groupName, String testName, Class clazz) {
        TestItem testItem = new TestItem(groupName, testName, clazz);
        testList.add(testItem);
    }

}
