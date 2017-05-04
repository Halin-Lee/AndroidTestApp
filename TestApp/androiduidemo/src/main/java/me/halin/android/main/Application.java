package me.halin.android.main;

import me.halin.android.ApplicationUIServiceSample;

/**
 * Created by halin on 4/10/17.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new ApplicationUIServiceSample().register(this, "");

    }
}
