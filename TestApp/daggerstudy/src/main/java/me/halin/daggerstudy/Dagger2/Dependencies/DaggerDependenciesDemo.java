package me.halin.daggerstudy.Dagger2.Dependencies;

import javax.inject.Inject;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Dagger Component依赖Component的测试
 * <p/>
 * Created by Halin on 5/4/16.
 */
public class DaggerDependenciesDemo {

    public static final void test() {

        DependenciesSubComponent subComponent = DaggerDependenciesSubComponent.builder().dependenciesSubModule(new DependenciesSubModule()).build();

        //为DependenciesComponent注入module及其需要的subComponent
        DependenciesComponent component = DaggerDependenciesComponent.builder().dependenciesModule(new DependenciesModule()).dependenciesSubComponent(subComponent).build();
        DaggerDependenciesDemo demo = new DaggerDependenciesDemo();
        component.inject(demo);
        Logger.debug("注入文本:%s,注入参数:%d", demo.moduleString, demo.subModuleInteger);

    }

    @Inject
    public String moduleString;

    @Inject
    public int subModuleInteger;


}
