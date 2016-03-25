package me.halin.testapp.EspressonTestDemo.mock;

/**
 * Created by halin on 12/1/15.
 */
public class TestObject {


    private Runnable callback;

    private boolean isCanceled = false;

    public void cancel() {
        isCanceled = true;
    }

    public Runnable getCallback() {
        return callback;
    }

    public void setCallback(Runnable callback) {
        this.callback = callback;
    }

    protected void deliver() {

        callback.run();
    }

    public void start() {
        //执行一次异步请求,完成后调用回调

        new Thread() {

            @Override
            public void run() {
                doSomething();
            }
        }.start();
    }

    protected void doSomething() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isCanceled != true) {
            deliver();
        }
    }


}
