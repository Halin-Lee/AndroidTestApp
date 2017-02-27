package me.halin.testapp.ThirdPartyLibrary.Dagger2.Named;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by Halin on 5/4/16.
 */
@Component(modules = {NamedModule.class}, dependencies = {NamedSubComponent.class})
public interface NamedComponent {

    void inject(DaggerNamedActivity demo);

    @Named("NamedModuleString")
        //添加Named标签,标明提供的String类别
    String provideNamedModuleString();

    @Named("NamedSubModuleString")
        //添加Named标签,标明提供的String类别
    String provideNamedSubModuleString();
}
