package halin.me.testapp.main;

import java.util.ArrayList;
import java.util.Arrays;

import halin.me.fundamental.LogTools.Logger;

/**
 * Created by halin on 11/24/15.
 */
public class Application extends android.app.Application {

    private static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        Logger.init(this);

        Arrays.asList(new ArrayList<>());
    }
}
