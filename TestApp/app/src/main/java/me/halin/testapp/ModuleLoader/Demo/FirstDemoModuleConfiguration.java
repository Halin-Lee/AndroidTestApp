package me.halin.testapp.ModuleLoader.Demo;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.ModuleLoader.ConfigField;
import me.halin.testapp.ModuleLoader.InitializableInterface;

/**
 * Created by 17track on 3/28/16.
 */
public class FirstDemoModuleConfiguration implements InitializableInterface {
    @ConfigField("firstParam")
    private String firstParam;

    @ConfigField("secondParam")
    private String secondParam;

    @ConfigField("defaultValue")
    private String defaultValue = "defaultValue";


    @Override
    public String toString() {
        return "FirstDemoModuleConfiguration " + firstParam + " " + secondParam + " " + defaultValue;
    }

    @Override
    public void setup() {
        Logger.debug("FirstDemoModuleConfiguration setup 方法调用");
    }

    @Override
    public void resetToDefaultValue() {

    }
}
