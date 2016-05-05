package me.halin.testapp.Dagger2.Singleton;

import dagger.Component;

/**
 * Created by Halin on 5/5/16.
 */
@Component(modules = {SingletonSubModule.class})
public interface SingletonSubComponent {

    String subString();

}
