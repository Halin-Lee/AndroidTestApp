package me.halin.daggerstudy.Dagger2.Dependencies;

import dagger.Component;

/**
 * Created by Halin on 5/4/16.
 */
@Component(modules = {DependenciesSubModule.class})
public interface DependenciesSubComponent {

    int provideSubInteger();
}
