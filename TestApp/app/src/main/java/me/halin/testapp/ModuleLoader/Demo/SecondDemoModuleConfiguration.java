package me.halin.testapp.ModuleLoader.Demo;

import me.halin.testapp.ModuleLoader.ConfigField;
import me.halin.testapp.ModuleLoader.ConfigurableInterface;

/**
 * Created by 17track on 3/26/16.
 */
public class SecondDemoModuleConfiguration implements ConfigurableInterface {
    @ConfigField("firstParam")
    private int firstParam;

    @ConfigField("secondParam")
    private float secondParam;

    @Override
    public String toString() {
        return "FirstDemoModuleConfiguration " + firstParam + " " + secondParam;
    }

    @Override
    public void resetToDefaultValue() {

    }
}
