package me.halin.testapp.EspressonTestDemo.mock.junit;

/**
 * Created by halin on 12/4/15.
 */
public class JUnitTestObject {


    private JUnitMockObject mockObject;

    public JUnitTestObject(JUnitMockObject mockObject) {
        this.mockObject = mockObject;
    }


    /**
     * 返回mockObject的abc
     */
    public String getMockObjectABC() {
        return mockObject.getABC();
    }
}
