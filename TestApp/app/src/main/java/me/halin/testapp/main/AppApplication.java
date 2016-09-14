package me.halin.testapp.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import android.widget.Toast;

import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.XC_MethodHook;
import com.trackandtrace.lazylist.CommonUtilities;

import java.util.Arrays;
import java.util.UUID;

import me.halin.fundamental.LogUtil.LogUtilTestIn;
import me.halin.fundamental.LogUtil.Logger;
import me.halin.fundamental.NetworkCommunication.VolleyController;
import me.halin.fundamental.Tools.ApplicationContextTools;
import me.halin.fundamental.Tools.ThreadTools;
import me.halin.fundamental.Tools.WatchDogService;
import me.halin.testapp.BuildConfig;
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
        Log.e(TAG, "TEST BEFORE");
        Log.e(TAG, "TEST:" + new CommonUtilities().getKeyHeader());
        Log.e(TAG, "TEST AFTER");
        initFundamental();

        WatchDogService.getInstance().setup();

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

    /**
     * 初始化工具类
     */
    private void initFundamental() {

        ApplicationContextTools.setup(this, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE);
        VolleyController.getInstance().setup(this);


    }
}
