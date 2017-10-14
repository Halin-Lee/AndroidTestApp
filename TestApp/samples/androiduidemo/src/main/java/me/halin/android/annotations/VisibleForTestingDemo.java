package me.halin.android.annotations;

import android.support.annotation.VisibleForTesting;

/**
 * Created by halin on 3/16/17.
 */

public class VisibleForTestingDemo {


    public void test() {
        //工程代码调用会报错
        visibleForTest();
    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    public void visibleForTest() {
    }
}
