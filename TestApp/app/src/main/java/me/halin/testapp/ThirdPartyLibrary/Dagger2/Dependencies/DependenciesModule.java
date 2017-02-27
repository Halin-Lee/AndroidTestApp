package me.halin.testapp.ThirdPartyLibrary.Dagger2.Dependencies;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Halin on 5/4/16.
 */
@Module
public class DependenciesModule {

    @Provides
    //依赖于SubModule提供的integer
    public String moduleString(int subModuleInteger) {
        return this.getClass().getName() + " subModuleInteger:" + subModuleInteger;
    }
}
