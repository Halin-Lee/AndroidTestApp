package me.halin.testapp.testdemo.mock;


/**
 * Created by halin on 12/1/15.
 */

public class MockDemoObject extends TestObject {


    /**
     * deliver是否被调用
     */
    private boolean isDeliverCalled = false;


    @Override
    public void start() {
        //mock掉原本的start方法,同步执行doSomething;
        doSomething();
    }

    @Override
    protected void deliver() {
        //mock掉原本的deliver方法,确认deliver调用没
        isDeliverCalled = true;
    }


    public boolean isDeliverCalled() {
        return isDeliverCalled;
    }

}
