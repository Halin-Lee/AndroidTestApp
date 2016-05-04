package me.halin.daggerstudy.Dagger2.Named;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by Halin on 5/4/16.
 */
@Component(modules = {NamedSubModule.class})
public interface NamedSubComponent {

    @Named("NamedSubModuleString")
    String provideNamedSubModuleString();

}
