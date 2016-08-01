package me.halin.testapp.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.XC_MethodHook;

import me.halin.fundamental.LogUtil.LogUtilTestIn;
import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.UserCenter.SignInRequest;

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

        if (DexposedBridge.canDexposed(this)) {
            DexposedBridge.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    super.beforeHookedMethod(param);
                }
            });

        }

        instance = this;

//        Logger.setup(new LogUtilTestIn(this), true);

//        XStreamDemo.test(this);
//        ModuleLoader.getInstance().loadModule(this, GlobalConfiguration.getInstance(), DemoModuleDeclaration.class, "AppEnvironmentConfig.xml", null);


    }
}
