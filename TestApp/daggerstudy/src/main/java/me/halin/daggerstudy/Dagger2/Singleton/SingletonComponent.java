package me.halin.daggerstudy.Dagger2.Singleton;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Halin on 5/4/16.
 */
@Singleton
@Component(modules = {SingletonModule.class}, dependencies = {SingletonSubComponent.class})
public interface SingletonComponent {

    //注入方法可随意命名
    void dontCallMeInject(DaggerSingletonDemo demo);

    @Named("singleton")
    String string();


    @Named("nonSingleton")
    String nonSingletonString();
}
