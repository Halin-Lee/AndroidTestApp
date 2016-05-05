package me.halin.testapp.Dagger2.AutoGenerate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.Dagger2.Dagger2BaseActivity;

/**
 * Created by Halin on 5/5/16.
 */
public class DaggerAutoGenerateActivity extends Dagger2BaseActivity {

    @Inject
    long currentTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AutoGenerateComponent不设置一个AutoGenerateModule对象,该对象由DaggerAutoGenerateComponent调用AutoGenerateModule的无参构造函数自动生成
        AutoGenerateComponent autoGenerateComponent = DaggerAutoGenerateComponent.builder().build();
        autoGenerateComponent.inject(this);
        append("当前时间:%d", this.currentTime);
    }
}
