package me.halin.android.annotations;

import android.support.annotation.ColorRes;
import android.support.annotation.VisibleForTesting;

/**
 * Created by halin on 3/16/17.
 */

public class ResDemo {

@VisibleForTesting
    public void test() {
        //声明接受颜色资源
        getRes(1);
        getRes(android.R.color.background_dark);

    }


    public void getRes(@ColorRes int res) {
    }
}
