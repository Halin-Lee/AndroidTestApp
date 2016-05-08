package me.halin.testapp.Dagger2.StaticInject;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import me.halin.testapp.Dagger2.Dagger2BaseActivity;

/**
 * Created by Halin on 5/6/16.
 */
public class DaggerStaticInjectActivity extends Dagger2BaseActivity {

    @Inject
    public static String staticField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StaticInjectComponent staticInjectComponent = DaggerStaticInjectComponent.builder().build();
        staticInjectComponent.inject(this);

        append("静态注入文本:%s",staticField);
    }
}
