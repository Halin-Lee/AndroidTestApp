package me.halin.testapp.main.Model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import me.halin.testapp.Account.AccountDemoActivity;
import me.halin.testapp.AutoEventTracking.Demo.AutoEventTrackingDemoActivity;
import me.halin.testapp.AutoEventTracking.Demo.AutoEventTrackingFragmentDemoActivity;
import me.halin.testapp.EspressonTestDemo.espresso.example.EspressoTestActivity;
import me.halin.testapp.FragmentDemo.FragmentTestActivity;
import me.halin.testapp.ModelExtensionDemo.ModelExtensionDemoActivity;
import me.halin.testapp.MonkeyRunner.MonkeyRunnerDemoActivity;
import me.halin.testapp.RequestSimulator.RequestSimulatorActivity;
import me.halin.testapp.SystemUI.DrawerLayout.DrawerLayoutDemoActivity;
import me.halin.testapp.SystemUI.RecycleView.RecycleViewBaseActivity;
import me.halin.testapp.SystemUI.databinding.AdvancedBinding.DataBindingAdvancedBindingActivity;
import me.halin.testapp.SystemUI.databinding.AttributeSetter.DataBindingAttributeSetterActivity;
import me.halin.testapp.SystemUI.databinding.Base.DataBindingBaseActivity;
import me.halin.testapp.SystemUI.databinding.BindingAdapter.DataBindingBindingAdapterActivity;
import me.halin.testapp.SystemUI.databinding.Custom.DataBindingCustomActivity;
import me.halin.testapp.SystemUI.databinding.DataObjects.DataBindingObservableCollectionActivity;
import me.halin.testapp.SystemUI.databinding.DataObjects.DataBindingObservableFieldActivity;
import me.halin.testapp.SystemUI.databinding.DataObjects.DataBindingObservableObjectActivity;
import me.halin.testapp.SystemUI.databinding.DemoList.DataBindingDemoListActivity;
import me.halin.testapp.SystemUI.databinding.Event.DataBindingEventActivity;
import me.halin.testapp.SystemUI.databinding.Expression.DataBindingExpressionActivity;
import me.halin.testapp.SystemUI.databinding.GeneratedBinding.DataBindingGeneratedBindingActivity;
import me.halin.testapp.SystemUI.databinding.Import.DataBindingImportActivity;
import me.halin.testapp.SystemUI.databinding.Include.DataBindingIncludeActivity;
import me.halin.testapp.SystemUI.databinding.List.DataBindingListActivity;
import me.halin.testapp.SystemUI.databinding.Observable.DataBindingObservableActivity;
import me.halin.testapp.SystemUI.databinding.OnRebind.DataBindingOnRebindActivity;
import me.halin.testapp.Test.DrawableTestActivity;
import me.halin.testapp.Test.ThemeTestActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.AutoGenerate.DaggerAutoGenerateActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.Base.DaggerBaseActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.Dependencies.DaggerDependenciesActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.InjectMethod.DaggerMethodInjectActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.InnerClass.DaggerInnerClassActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.Named.DaggerNamedActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.Singleton.DaggerSingletonActivity;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.SubComponent.SubComponentActivity;
import me.halin.testapp.ThirdPartyLibrary.WebSocket.WebSocketDemoActivity;

/**
 * /**
 * 测试参数构造
 * <p>
 * Created by halin on 9/17/15.
 */
public class TestBuilder {

    public final List<TestItem> testList = new ArrayList<>();

    public List<TestItem> build() {

        //DataBinding;
        String dataBindingTestGroupName = "DataBinding测试";
        add(dataBindingTestGroupName, "DataBinder 测试", DataBindingBaseActivity.class);
        add(dataBindingTestGroupName, "DataBindingBindingAdapterActivity 测试", DataBindingBindingAdapterActivity.class);
        add(dataBindingTestGroupName, "DataBinderList 测试", DataBindingListActivity.class);
        add(dataBindingTestGroupName, "DataBinder 事件绑定测试", DataBindingEventActivity.class);
        add(dataBindingTestGroupName, "DataBinder 导入测试", DataBindingImportActivity.class);
        add(dataBindingTestGroupName, "自定义 DataBinder", DataBindingCustomActivity.class);
        add(dataBindingTestGroupName, "Include 测试", DataBindingIncludeActivity.class);
        add(dataBindingTestGroupName, "Expression 测试", DataBindingExpressionActivity.class);
        add(dataBindingTestGroupName, "ObservableObject 测试", DataBindingObservableObjectActivity.class);
        add(dataBindingTestGroupName, "ObservableField 测试", DataBindingObservableFieldActivity.class);
        add(dataBindingTestGroupName, "ObservableCollection 测试", DataBindingObservableCollectionActivity.class);
        add(dataBindingTestGroupName, "GeneratedBinding 绑定测试", DataBindingGeneratedBindingActivity.class);
        add(dataBindingTestGroupName, "AdvancedBinding 动态绑定测试", DataBindingAdvancedBindingActivity.class);
        add(dataBindingTestGroupName, "DataBinding Demo", DataBindingDemoListActivity.class);
        add(dataBindingTestGroupName, "Observable 测试", DataBindingObservableActivity.class);
        add(dataBindingTestGroupName, "DataBinding Attribute Setter", DataBindingAttributeSetterActivity.class);
        add(dataBindingTestGroupName, "On Rebind", DataBindingOnRebindActivity.class);

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
        add(dagger2Test, "SubComponent", SubComponentActivity.class);
        add(dagger2Test, "Component自动生成Module", DaggerAutoGenerateActivity.class);
        add(dagger2Test, "Named注解使用", DaggerNamedActivity.class);
        add(dagger2Test, "Singleton注解使用", DaggerSingletonActivity.class);
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

        String modelExtensionGroupName = "Model Extension Demo";
        add(modelExtensionGroupName, modelExtensionGroupName, ModelExtensionDemoActivity.class);

        String drawerLayoutDemoGroupName = "Drawer Layout Demo";
        add(drawerLayoutDemoGroupName, drawerLayoutDemoGroupName, DrawerLayoutDemoActivity.class);

        String drawableTestGroupName = "Drawable Test";
        add(drawableTestGroupName, drawableTestGroupName, DrawableTestActivity.class);

        String themeTestGroupName = "Theme Test";
        add(themeTestGroupName, themeTestGroupName, ThemeTestActivity.class);

        return testList;
    }


    protected void add(String groupName, String testName, Class<? extends Activity> clazz) {
        TestItem testItem = new TestItem(groupName, testName, clazz);
        testList.add(testItem);
    }

}
