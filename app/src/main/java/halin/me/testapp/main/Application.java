package halin.me.testapp.main;

import halin.me.fundamental.LogTools.Logger;

/**
 * Created by halin on 11/24/15.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(this);
    }
}
