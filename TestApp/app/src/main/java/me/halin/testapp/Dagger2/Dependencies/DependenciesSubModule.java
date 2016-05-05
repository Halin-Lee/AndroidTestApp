package me.halin.testapp.Dagger2.Dependencies;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Halin on 5/4/16.
 */
@Module
public class DependenciesSubModule {
    @Provides
    public int subModuleInteger() {
        return 100;
    }
}
