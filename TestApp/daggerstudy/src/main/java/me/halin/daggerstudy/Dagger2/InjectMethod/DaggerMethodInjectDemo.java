package me.halin.daggerstudy.Dagger2.InjectMethod;

import javax.inject.Inject;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by Halin on 5/4/16.
 */
public class DaggerMethodInjectDemo {


    public static void test() {
        DaggerMethodInjectComponent daggerMethodInjectComponent = DaggerDaggerMethodInjectComponent.builder().daggerMethodInjectModule(new DaggerMethodInjectModule("测试文本")).build();
        DaggerMethodInjectDemo demo = new DaggerMethodInjectDemo();
        daggerMethodInjectComponent.inject(demo);
    }

    @Inject
    void DaggerMethodInjectDemo(String moduleStr) {
        Logger.debug("DaggerMethodInjectDemo被注入内容:%s", moduleStr);
    }
}
