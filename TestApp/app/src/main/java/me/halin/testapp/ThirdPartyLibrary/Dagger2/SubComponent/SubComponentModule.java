package me.halin.testapp.ThirdPartyLibrary.Dagger2.SubComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by halin on 3/1/17.
 */
@Module
public class SubComponentModule {

    @Provides
    String provideString() {
        return "100";
    }

//
//    @Provides
//    SubComponentSubComponent subComponent() {
//        return
//    }

    @Provides
    DemoObject demoObject(SubComponentComponent subComponentComponent) {
        DemoObject demoObject = new DemoObject();
        subComponentComponent.subComponent().subComponent().inject(demoObject);
        return demoObject;

    }
}
