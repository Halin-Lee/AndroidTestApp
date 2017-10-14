package me.halin.testapp.main;

import me.halin.fundamental.NetworkCommunication.VolleyController;
import me.halin.fundamental.Tools.ApplicationContextTools;
import me.halin.fundamental.Tools.WatchDogService;
import me.halin.testapp.BuildConfig;
import me.halin.testapp.Test.WebViewTest;

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

        initFundamental();

//        WatchDogService.getInstance().setup();

//        if (DexposedBridge.canDexposed(this)) {
//            DexposedBridge.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                    super.beforeHookedMethod(param);
//                }
//            });
//
//        }

        instance = this;

//        Logger.setup(new LogUtilTestIn(this), true);

//        XStreamDemo.test(this);
//        ModuleLoader.getInstance().loadModule(this, GlobalConfiguration.getInstance(), DemoModuleDeclaration.class, "AppEnvironmentConfig.xml", null);


        new WebViewTest(this);
    }

    /**
     * 初始化工具类
     */
    private void initFundamental() {

        ApplicationContextTools.setup(this, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE);
        VolleyController.getInstance().setup(this);


    }
}
