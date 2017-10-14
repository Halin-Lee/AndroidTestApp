package me.halin.android;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by halin on 4/10/17.
 */

public class ApplicationUIServiceSample implements Application.ActivityLifecycleCallbacks {

    Application application;
    String tag;

    public void register(Application application,String tag) {
        this.application =application;
        this.tag = tag;
        application.registerActivityLifecycleCallbacks(this);
    }

    public void unregister(){}

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {







    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
