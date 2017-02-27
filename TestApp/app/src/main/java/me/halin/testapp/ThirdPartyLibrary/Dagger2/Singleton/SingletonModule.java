package me.halin.testapp.ThirdPartyLibrary.Dagger2.Singleton;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.halin.testapp.main.LogStringBaseActivity;

/**
 * Created by Halin on 5/4/16.
 */
@Module
public class SingletonModule {

    private LogStringBaseActivity activity;

    SingletonModule(LogStringBaseActivity activity) {
        this.activity = activity;
    }

    private int singletonCount = 0;

    @Provides
    @Named("singleton")
    @Singleton
        //方法名称与注入无关
    String donotCallMeString() {
        singletonCount++;
        activity.append("dontCallMeString第%d次调用", singletonCount);
        return "dontCallMeString调用次数" + singletonCount;
    }


    private int nonSingletonCount = 0;

    @Provides
    @Named("nonSingleton")
        //方法名称与注入无关
    String nonSingletonString() {
        nonSingletonCount++;
        activity.append("nonSingletonString第%d次调用", nonSingletonCount);
        return "nonSingletonString调用次数" + nonSingletonCount;
    }

}
