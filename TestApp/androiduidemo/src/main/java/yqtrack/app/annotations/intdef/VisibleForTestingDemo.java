package yqtrack.app.annotations.intdef;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

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
