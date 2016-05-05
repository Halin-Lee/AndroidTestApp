package me.halin.testapp.Dagger2.Singleton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.Dagger2.Dagger2BaseActivity;

/**
 * Created by Halin on 5/4/16.
 */
public class DaggerSingletonActivity extends Dagger2BaseActivity {
    @Inject
    @Named("singleton")
    //类名与注入无直接关系
            String imNotString;

    @Inject
    @Named("nonSingleton")
    //类名与注入无直接关系
            String nonSingletonString;

    @Inject
    String subString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SingletonSubComponent subComponent = DaggerSingletonSubComponent.builder().singletonSubModule(new SingletonSubModule(this)).build();

        SingletonComponent component = DaggerSingletonComponent.builder().singletonModule(new SingletonModule(this)).singletonSubComponent(subComponent).build();


        append("准备注入");
        component.dontCallMeInject(this);
        append("第一次注入完成,imNotString:%s ,nonSingletonString:%s ,subString:%s", this.imNotString, this.nonSingletonString, this.subString);

        append("第二次注入调用");
        component.dontCallMeInject(this);
        append("第二次注入完成,imNotString:%s ,nonSingletonString:%s ,subString:%s", this.imNotString, this.nonSingletonString, this.subString);

    }


}
