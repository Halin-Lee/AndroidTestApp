package me.halin.testapp.Dagger2.Dependencies;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Halin on 5/4/16.
 */
@Module
public class DependenciesModule {

    @Provides
    public String moduleString() {
        return this.getClass().getName();
    }
}
