package me.halin.testapp.ModuleLoader;

/**
 * Created by Halin on 3/26/16.
 */
public class GlobalConfiguration implements ConfigurableInterface {

    public static GlobalConfiguration getInstance() {
        return instance;
    }

    private static final GlobalConfiguration instance = new GlobalConfiguration();

    private GlobalConfiguration() {
    }


    @ConfigField("testStringValue")
    private String testStringValue;

    @ConfigField("testIntegerValue")
    private int testIntegerValue;

    @ConfigField("testFloatValue")
    private float testFloatValue;

    public String getTestStringValue() {
        return testStringValue;
    }

    public void setTestStringValue(String testStringValue) {
        this.testStringValue = testStringValue;
    }

    public int getTestIntegerValue() {
        return testIntegerValue;
    }

    public void setTestIntegerValue(int testIntegerValue) {
        this.testIntegerValue = testIntegerValue;
    }

    public float getTestFloatValue() {
        return testFloatValue;
    }

    public void setTestFloatValue(float testFloatValue) {
        this.testFloatValue = testFloatValue;
    }


    @Override
    public void resetToDefaultValue() {

    }
}
