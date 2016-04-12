package me.halin.daggerstudy.main;

import me.halin.daggerstudy.Dagger2.Dagger2Demo;
import me.halin.fundamental.LogUtil.LogUtilTestIn;
import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by halin on 11/24/15.
 */
public class DaggerStudyApplication extends android.app.Application {

    public static final String TAG = DaggerStudyApplication.class.getName();

    private static DaggerStudyApplication instance;

    public static DaggerStudyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        Logger.setup(new LogUtilTestIn(this), true);

//        XStreamDemo.test(this);
//        ModuleLoader.getInstance().loadModule(this, GlobalConfiguration.getInstance(), DemoModuleDeclaration.class, "AppEnvironmentConfig.xml", null);
        Dagger2Demo.test(this);

        Logger.debug("Test Start");
    }
}
