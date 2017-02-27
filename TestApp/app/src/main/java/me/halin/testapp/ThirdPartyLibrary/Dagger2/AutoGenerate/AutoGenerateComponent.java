package me.halin.testapp.ThirdPartyLibrary.Dagger2.AutoGenerate;

import dagger.Component;

/**
 * Created by Halin on 5/5/16.
 */
@Component(modules = {AutoGenerateModule.class})
//正常来说,Component一般使用interface,但这里用abstract class也可以
public abstract class AutoGenerateComponent {

    abstract void inject(DaggerAutoGenerateActivity demo);

    abstract long currentTime();

}
