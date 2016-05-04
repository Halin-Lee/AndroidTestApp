package me.halin.daggerstudy.Dagger2.InjectMethod;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Halin on 5/4/16.
 */
@Module
public class DaggerMethodInjectModule {

    private String string;

    public DaggerMethodInjectModule(String string) {
        this.string = string;
    }

    @Provides
    String provideString() {
        return string;
    }
}
