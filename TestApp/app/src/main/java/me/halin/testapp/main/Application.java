package me.halin.testapp.main;

/**
 * Created by halin on 11/24/15.
 */
public class Application extends android.app.Application {

    public static final String TAG = Application.class.getName();

    private static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;


    }
}
