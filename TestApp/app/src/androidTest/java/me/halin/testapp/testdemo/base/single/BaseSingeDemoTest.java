package me.halin.testapp.testdemo.base.single;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * 基础测试demo
 * <p/>
 * Created by halin on 12/1/15.
 */
@RunWith(AndroidJUnit4.class)
public class BaseSingeDemoTest {


    @Test
    public void exampleSuccessTest() {
        assertTrue(true);
    }

    @Test
    public void exampleFailTest() {
        assertTrue(false);
    }


    /**
     * 超时测试
     */
    @Test(timeout = 1000)
    public void exampleTimeoutTest() throws InterruptedException {
        Thread.sleep(2000);


    }
}
