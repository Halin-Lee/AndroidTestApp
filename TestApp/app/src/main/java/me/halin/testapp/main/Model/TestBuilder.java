package me.halin.testapp.main.Model;

import java.util.ArrayList;
import java.util.List;

import me.halin.testapp.Account.AccountDemoActivity;
import me.halin.testapp.AutoEventTracking.Demo.AutoEventTrackingDemoActivity;
import me.halin.testapp.AutoEventTracking.Demo.AutoEventTrackingFragmentDemoActivity;
import me.halin.testapp.Dagger2.AutoGenerate.DaggerAutoGenerateActivity;
import me.halin.testapp.Dagger2.Base.DaggerBaseActivity;
import me.halin.testapp.Dagger2.Dependencies.DaggerDependenciesActivity;
import me.halin.testapp.Dagger2.InjectMethod.DaggerMethodInjectActivity;
import me.halin.testapp.Dagger2.InnerClass.DaggerInnerClassActivity;
import me.halin.testapp.Dagger2.Named.DaggerNamedActivity;
import me.halin.testapp.Dagger2.Singleton.DaggerSingletonActivity;
import me.halin.testapp.Dagger2.StaticInject.DaggerStaticInjectActivity;
import me.halin.testapp.EspressonTestDemo.espresso.example.EspressoTestActivity;
import me.halin.testapp.FragmentDemo.FragmentTestActivity;
import me.halin.testapp.MonkeyRunner.MonkeyRunnerDemoActivity;
import me.halin.testapp.RecycleView.Base.RecycleViewBaseActivity;
import me.halin.testapp.RequestSimulator.RequestSimulatorActivity;
import me.halin.testapp.WebSocket.WebSocketDemoActivity;
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

/**
 * /**
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

        //自动化埋点
        String autoEventTracking = "自动化埋点";
        add(autoEventTracking, "自动化埋点", AutoEventTrackingDemoActivity.class);
        add(autoEventTracking, "自动化埋点,Fragment", AutoEventTrackingFragmentDemoActivity.class);

        //account测试
        String accountTest = " 原生第三方登录授权测试";
        add(accountTest, accountTest, AccountDemoActivity.class);

        //Dagger2测试
        String dagger2Test = "Dagger2 测试";
        add(dagger2Test, "基本使用", DaggerBaseActivity.class);
        add(dagger2Test, "方法注入", DaggerMethodInjectActivity.class);
        add(dagger2Test, "Component依赖", DaggerDependenciesActivity.class);
        add(dagger2Test, "Component自动生成Module", DaggerAutoGenerateActivity.class);
        add(dagger2Test, "Named注解使用", DaggerNamedActivity.class);
        add(dagger2Test, "Singleton注解使用", DaggerSingletonActivity.class);
        add(dagger2Test, "静态注入", DaggerStaticInjectActivity.class);
        add(dagger2Test, "内部类注入", DaggerInnerClassActivity.class);

        String fragmentTest = "Fragment 测试";
        add(fragmentTest, fragmentTest, FragmentTestActivity.class);

        String requestSimulatorTest = "请求模拟";
        add(requestSimulatorTest, requestSimulatorTest, RequestSimulatorActivity.class);

        String monkeyRunnerTest = "monkeyRunnerTest测试";
        add(monkeyRunnerTest, monkeyRunnerTest, MonkeyRunnerDemoActivity.class);

        //webSocket
        String webSocketTestGroupName = "WebSocket测试";
        add(webSocketTestGroupName, "WebSocket测试", WebSocketDemoActivity.class);

        return testList;
    }


    protected void add(String groupName, String testName, Class clazz) {
        TestItem testItem = new TestItem(groupName, testName, clazz);
        testList.add(testItem);
    }

}
