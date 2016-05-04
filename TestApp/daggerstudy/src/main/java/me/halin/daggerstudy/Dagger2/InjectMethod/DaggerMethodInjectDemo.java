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

        //对象的构造函数会被调用两次,但是是同一个对象?
        Logger.debug("对象注入前 %s", demo);
        daggerMethodInjectComponent.inject(demo);
        Logger.debug("对象注入后 %s", demo);
    }

    @Inject
    void DaggerMethodInjectDemo(String moduleStr) {

        Logger.debug("对象构造函数 %s", this);
        Logger.debug("DaggerMethodInjectDemo构造函数被注入内容:%s", moduleStr);
    }


    @Inject
    void moduleString(String moduleStr) {
        Logger.debug("DaggerMethodInjectDemo方法被注入内容:%s", moduleStr);
    }
}
