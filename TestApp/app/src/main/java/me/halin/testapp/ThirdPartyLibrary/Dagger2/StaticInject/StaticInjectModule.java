package me.halin.testapp.ThirdPartyLibrary.Dagger2.StaticInject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Halin on 5/6/16.
 */
@Module
public class StaticInjectModule {

    @Provides
    String provideStaticString(){
        return "staticString";
    }
}
