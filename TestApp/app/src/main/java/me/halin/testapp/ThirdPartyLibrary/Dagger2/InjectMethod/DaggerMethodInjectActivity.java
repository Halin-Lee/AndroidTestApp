package me.halin.testapp.ThirdPartyLibrary.Dagger2.InjectMethod;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import me.halin.testapp.main.LogStringBaseActivity;

/**
 * Created by Halin on 5/4/16.
 */
public class DaggerMethodInjectActivity extends LogStringBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMethodInjectComponent daggerMethodInjectComponent = DaggerDaggerMethodInjectComponent.builder().daggerMethodInjectModule(new DaggerMethodInjectModule("测试文本")).build();

        //对象的构造函数会被调用两次,但是是同一个对象?
        append("对象注入前 %s", this);
        daggerMethodInjectComponent.inject(this);
        append("对象注入后 %s", this);

        DaggerMethodInjectDemo demo = daggerMethodInjectComponent.getDemo();
        append("构造函数Inject String:%s", demo.getString());
    }

    @Inject
    void moduleString(String moduleStr) {
        append("DaggerMethodInjectDemo方法被注入内容:%s", moduleStr);
    }

}
