package me.halin.daggerstudy.Dagger2;

import android.content.Context;


import me.halin.daggerstudy.Dagger2.Base.DaggerBaseDemo;
import me.halin.daggerstudy.Dagger2.InjectMethod.DaggerMethodInjectDemo;


/**
 * Created by 17track on 3/25/16.
 */

public class Dagger2Demo {

    public static void test(Context context) {
//         DaggerBaseDemo.test(context);
        DaggerMethodInjectDemo.test();
    }
}
