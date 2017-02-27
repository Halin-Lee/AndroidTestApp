package me.halin.testapp.ThirdPartyLibrary.Dagger2.Dependencies;

import dagger.Component;

/**
 * 一个依赖与DependenciesSubComponent的Component
 * Created by Halin on 5/4/16.
 */
//指明这个注入器需要提供依赖的DependenciesModule,以及需要DependenciesSubComponent为他注入
@Component(modules = {DependenciesModule.class}, dependencies = {DependenciesSubComponent.class})
public interface DependenciesComponent {

    String provideString();

    void inject(DaggerDependenciesActivity demo);

    /**
     * 将SubComponent的内容提供出来
     */
    int provideSubInteger();

}
