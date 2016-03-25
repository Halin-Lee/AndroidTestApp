package me.halin.testapp.main.Model;

import java.util.ArrayList;
import java.util.List;

import me.halin.testapp.databinding.AdvancedBinding.DataBindingAdvancedBindingActivity;
import me.halin.testapp.databinding.AttributeSetter.DataBindingAttributeSetterActivity;
import me.halin.testapp.databinding.Base.DataBindingBaseActivity;
import me.halin.testapp.databinding.Custom.DataBindingCustomActivity;
import me.halin.testapp.databinding.DataObjects.DataBindingObservableCollectionActivity;
import me.halin.testapp.databinding.DataObjects.DataBindingObservableFieldActivity;
import me.halin.testapp.databinding.DataObjects.DataBindingObservableObjectActivity;
import me.halin.testapp.databinding.DemoList.DataBindingDemoListActivity;
import me.halin.testapp.databinding.Event.DataBindingEventActivity;
import me.halin.testapp.databinding.Expression.DataBindingExpressionActivity;
import me.halin.testapp.databinding.GeneratedBinding.DataBindingGeneratedBindingActivity;
import me.halin.testapp.databinding.Import.DataBindingImportActivity;
import me.halin.testapp.databinding.Include.DataBindingIncludeActivity;
import me.halin.testapp.databinding.List.DataBindingListActivity;
import me.halin.testapp.databinding.Observable.DataBindingObservableActivity;

import me.halin.testapp.RecycleView.Base.RecycleViewBaseActivity;
import me.halin.testapp.EspressonTestDemo.espresso.example.EspressoTestActivity;

/**

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
