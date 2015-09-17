package halin.me.testapp.main.Model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import halin.me.testapp.DataBinding.AdvancedBinding.DataBindingAdvancedBindingActivity;
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

/**
 * Created by halin on 9/17/15.
 */
public class TestBuilder {

    public final List<TestGroup> testGroupList = new ArrayList<>();

    public List<TestGroup> build() {

        //DataBinding;
        TestGroup dataBindingGroup = new TestGroup("DataBinding测试");
        dataBindingGroup.add("DataBinder测试", DataBindingBaseActivity.class);
        dataBindingGroup.add("DataBinderList测试", DataBindingListActivity.class);
        dataBindingGroup.add("DataBinder事件绑定测试", DataBindingEventActivity.class);
        dataBindingGroup.add("DataBinder导入测试", DataBindingImportActivity.class);
        dataBindingGroup.add("自定义DataBinder", DataBindingCustomActivity.class);
        dataBindingGroup.add("Include测试", DataBindingIncludeActivity.class);
        dataBindingGroup.add("Expression测试", DataBindingExpressionActivity.class);
        dataBindingGroup.add("ObservableObject测试", DataBindingObservableObjectActivity.class);
        dataBindingGroup.add("ObservableField测试", DataBindingObservableFieldActivity.class);
        dataBindingGroup.add("ObservableCollection测试", DataBindingObservableCollectionActivity.class);
        dataBindingGroup.add("GeneratedBinding绑定测试", DataBindingGeneratedBindingActivity.class);
        dataBindingGroup.add("AdvancedBinding动态绑定测试", DataBindingAdvancedBindingActivity.class);
        dataBindingGroup.add("DataBinding Demo", DataBindingDemoListActivity.class);
        dataBindingGroup.add("Observable测试", DataBindingObservableActivity.class);
        testGroupList.add(dataBindingGroup);

        //recycleView
        TestGroup recycleViewGroup = new TestGroup("RecycleView测试");
        recycleViewGroup.add("RecycleViewBase测试", RecycleViewBaseActivity.class);
        testGroupList.add(recycleViewGroup);


        return testGroupList;
    }


}
