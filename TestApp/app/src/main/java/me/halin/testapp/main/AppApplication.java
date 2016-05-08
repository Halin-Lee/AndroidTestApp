package me.halin.testapp.main;

import me.halin.fundamental.LogUtil.LogUtilTestIn;
import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by halin on 11/24/15.
 */
public class AppApplication extends android.app.Application {

    public static final String TAG = AppApplication.class.getName();

    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

//        Logger.setup(new LogUtilTestIn(this), true);

//        XStreamDemo.test(this);
//        ModuleLoader.getInstance().loadModule(this, GlobalConfiguration.getInstance(), DemoModuleDeclaration.class, "AppEnvironmentConfig.xml", null);


    }
}
