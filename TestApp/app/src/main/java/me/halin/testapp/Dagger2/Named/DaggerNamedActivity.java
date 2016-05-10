package me.halin.testapp.Dagger2.Named;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.main.LogStringBaseActivity;

/**
 * Created by Halin on 5/4/16.
 */
public class DaggerNamedActivity extends LogStringBaseActivity {


    @Inject
    //添加Named标签,标明接受的String类别
    @Named("NamedModuleString")
    String namedModuleString;

    @Inject
    //添加Named标签,标明接受的String类别
    @Named("NamedSubModuleString")
    String namedSubModuleString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NamedSubComponent subComponent = DaggerNamedSubComponent.builder().namedSubModule(new NamedSubModule()).build();
        NamedComponent namedComponent = DaggerNamedComponent.builder().namedModule(new NamedModule()).namedSubComponent(subComponent).build();

        namedComponent.inject(this);
        append("注入内容,NamedModuleString:%s,NamedSubModuleString:%s", this.namedModuleString, this.namedSubModuleString);


    }


}
