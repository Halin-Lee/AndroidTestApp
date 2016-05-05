package me.halin.daggerstudy.Dagger2.Singleton;

import javax.inject.Inject;
import javax.inject.Named;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by Halin on 5/4/16.
 */
public class DaggerSingletonDemo {

    public static void test() {

        SingletonSubComponent subComponent = DaggerSingletonSubComponent.builder().singletonSubModule(new SingletonSubModule()).build();

        SingletonComponent component = DaggerSingletonComponent.builder().singletonModule(new SingletonModule()).singletonSubComponent(subComponent).build();

        DaggerSingletonDemo demo = new DaggerSingletonDemo();
        Logger.debug("准备注入");
        component.dontCallMeInject(demo);
        Logger.debug("第一次注入完成,imNotString:%s ,nonSingletonString:%s ,subString:%s", demo.imNotString, demo.nonSingletonString, demo.subString);

        Logger.debug("第二次注入调用");
        demo = new DaggerSingletonDemo();
        component.dontCallMeInject(demo);
        Logger.debug("第二次注入完成,imNotString:%s ,nonSingletonString:%s ,subString:%s", demo.imNotString, demo.nonSingletonString, demo.subString);

    }

    @Inject
    @Named("singleton")
    //类名与注入无直接关系
            String imNotString;

    @Inject
    @Named("nonSingleton")
    //类名与注入无直接关系
            String nonSingletonString;

    @Inject
    String subString;
}
