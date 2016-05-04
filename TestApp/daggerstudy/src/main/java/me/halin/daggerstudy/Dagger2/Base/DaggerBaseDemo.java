package me.halin.daggerstudy.Dagger2.Base;

import android.content.Context;

import javax.inject.Inject;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by 17track on 4/8/16.
 */
public class DaggerBaseDemo {


    public static void test(Context context) {


        //构造注入器,为注入器添加module
        DaggerBaseComponent component = DaggerDaggerBaseComponent.builder().daggerBaseModule(new DaggerBaseModule(context)).build();

        DaggerBaseDemo baseDemo = new DaggerBaseDemo();
        component.inject(baseDemo);
        Logger.debug("注入%s context %s", baseDemo.context == null ? "失败" : "成功", baseDemo.context);
    }

    /**
     * @Inject 声明被注入的对象
     */
    @Inject
    Context context;

    private DaggerBaseDemo() {

    }


}
