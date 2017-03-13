package me.halin.testapp.ThirdPartyLibrary.Dagger2.SubComponent;

import javax.inject.Singleton;

import dagger.Component;
import me.halin.testapp.ThirdPartyLibrary.Dagger2.Dependencies.DaggerDependenciesActivity;

/**
 * Created by halin on 3/1/17.
 */
@Singleton
@Component(modules = SubComponentModule.class)
public interface SubComponentComponent {

    String provideString();

//    void inject(SubComponentActivity demo);

    SubComponentSubComponent subComponent();

    DemoObject demo();

}
