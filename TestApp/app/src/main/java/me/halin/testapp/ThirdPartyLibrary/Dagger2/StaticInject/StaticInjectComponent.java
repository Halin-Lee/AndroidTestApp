package me.halin.testapp.ThirdPartyLibrary.Dagger2.StaticInject;

import dagger.Component;

/**
 * Created by Halin on 5/6/16.
 */
@Component(modules = {StaticInjectModule.class})
public interface StaticInjectComponent {
    String setStaticField();

    void inject(DaggerStaticInjectActivity activity);
}
