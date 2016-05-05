package me.halin.testapp.Dagger2.Named;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Halin on 5/4/16.
 */
@Module
public class NamedModule {

    @Provides
    @Named("NamedModuleString")
        //添加Named标签,标明提供的String类别
    String provideNamedModuleString() {
        return this.getClass().getName();
    }
}
