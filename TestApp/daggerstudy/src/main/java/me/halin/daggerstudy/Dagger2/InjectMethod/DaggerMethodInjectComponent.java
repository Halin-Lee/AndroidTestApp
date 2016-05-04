package me.halin.daggerstudy.Dagger2.InjectMethod;

import dagger.Component;

/**
 * Created by Halin on 5/4/16.
 */
@Component(modules = {DaggerMethodInjectModule.class})
public interface DaggerMethodInjectComponent {

    String getString();

    void inject(DaggerMethodInjectDemo demo);
}
