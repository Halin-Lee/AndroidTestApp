package me.halin.testapp.ThirdPartyLibrary.Dagger2.SubComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by halin on 3/1/17.
 */
@Module
public class SubComponentSubModule {


    @Provides
    int provideInt(SubComponentSubComponent string) {
        return 100;
    }


}
