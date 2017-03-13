package me.halin.testapp.ThirdPartyLibrary.Dagger2.SubComponent;

import dagger.Subcomponent;

/**
 * Created by halin on 3/1/17.
 */
@Subcomponent(modules = SubComponentSubModule.class)
public interface SubComponentSubComponent {

    /**
     * 将SubComponent的内容提供出来
     */
    int provideSubInteger();

    void inject(SubComponentActivity demo);

    SubComponentSubComponent.SubComponent subComponent();

    @Subcomponent
    interface SubComponent {

        void inject(DemoObject demo);
    }
}
