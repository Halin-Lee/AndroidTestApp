package me.halin.daggerstudy.Dagger2.Named;

import javax.inject.Inject;
import javax.inject.Named;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by Halin on 5/4/16.
 */
public class DaggerNamedDemo {

    public static void test() {

        NamedSubComponent subComponent = DaggerNamedSubComponent.builder().namedSubModule(new NamedSubModule()).build();
        NamedComponent namedComponent = DaggerNamedComponent.builder().namedModule(new NamedModule()).namedSubComponent(subComponent).build();
        DaggerNamedDemo demo = new DaggerNamedDemo();
        namedComponent.inject(demo);
        Logger.debug("注入内容,NamedModuleString:%s,NamedSubModuleString:%s", demo.namedModuleString, demo.namedSubModuleString);

    }


    @Inject
    //添加Named标签,标明接受的String类别
    @Named("NamedModuleString")
    String namedModuleString;

    @Inject
    //添加Named标签,标明接受的String类别
    @Named("NamedSubModuleString")
    String namedSubModuleString;

}
