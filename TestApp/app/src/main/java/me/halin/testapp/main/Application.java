package me.halin.testapp.main;

import java.net.URI;
import java.net.URISyntaxException;

import me.halin.testapp.LogUtil.LogUtilTestIn;
import me.halin.testapp.LogUtil.Logger;

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

        Logger.setup(new LogUtilTestIn(this), true);

//        XStreamDemo.test(this);
//        ModuleLoader.getInstance().loadModule(this, GlobalConfiguration.getInstance(), DemoModuleDeclaration.class, "AppEnvironmentConfig.xml", null);

        try {
            URI url = new URI("Halin://host:4800/input");
            URI newUrl = url.resolve("output");
            Logger.debug("new url" + newUrl.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }
}
