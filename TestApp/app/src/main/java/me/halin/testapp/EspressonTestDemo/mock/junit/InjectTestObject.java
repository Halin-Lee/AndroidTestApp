package me.halin.testapp.EspressonTestDemo.mock.junit;

/**
 * Created by halin on 12/7/15.
 */
public class InjectTestObject {


    public String test() {
        JUnitMockObject testObject = new JUnitMockObject();
        return testObject.getABC();

    }
}
