package halin.me.testapp.testdemo.mock.junit;

import halin.me.testapp.testdemo.mock.TestObject;

/**
 * Created by halin on 12/7/15.
 */
public class InjectTestObject {


    public String test() {
        JUnitMockObject testObject = new JUnitMockObject();
        return testObject.getABC();

    }
}
