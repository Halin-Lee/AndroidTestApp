package me.halin.testapp.ThirdPartyLibrary.Dagger2.Base;

import android.content.Context;
import android.os.Bundle;

import javax.inject.Inject;

import me.halin.testapp.main.LogStringBaseActivity;

/**
 * Created by 17track on 4/8/16.
 */
public class DaggerBaseActivity extends LogStringBaseActivity {

    /**
     * @Inject 声明被注入的对象
     */
    @Inject
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //构造注入器,为注入器添加module
        DaggerBaseComponent component = DaggerDaggerBaseComponent.builder().daggerBaseModule(new DaggerBaseModule(getApplicationContext())).build();

        component.inject(this);
        append("注入%s context %s", this.context == null ? "失败" : "成功", this.context);
    }


}
