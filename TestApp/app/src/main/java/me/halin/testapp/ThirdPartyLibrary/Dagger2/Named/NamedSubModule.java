package me.halin.testapp.ThirdPartyLibrary.Dagger2.Named;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Halin on 5/4/16.
 */
@Module
public class NamedSubModule {

    @Provides
    @Named("NamedSubModuleString")
    String provideNamedSubModuleString() {
        return this.getClass().getName();
    }
}
