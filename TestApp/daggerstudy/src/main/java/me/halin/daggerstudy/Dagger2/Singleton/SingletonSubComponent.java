package me.halin.daggerstudy.Dagger2.Singleton;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Halin on 5/5/16.
 */
@Component(modules = {SingletonSubModule.class})
public interface SingletonSubComponent {

    String subString();

}
