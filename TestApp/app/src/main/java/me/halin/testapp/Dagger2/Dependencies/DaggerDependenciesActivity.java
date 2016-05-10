package me.halin.testapp.Dagger2.Dependencies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.main.LogStringBaseActivity;

/**
 * Dagger Component依赖Component的测试
 * <p/>
 * Created by Halin on 5/4/16.
 */
public class DaggerDependenciesActivity extends LogStringBaseActivity {


    @Inject
    public String moduleString;

    @Inject
    public int subModuleInteger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DependenciesSubComponent subComponent = DaggerDependenciesSubComponent.builder().dependenciesSubModule(new DependenciesSubModule()).build();

        //为DependenciesComponent注入module及其需要的subComponent
        DependenciesComponent component = DaggerDependenciesComponent.builder().dependenciesModule(new DependenciesModule()).dependenciesSubComponent(subComponent).build();

        component.inject(this);
        append("注入文本:%s,注入参数:%d", this.moduleString, this.subModuleInteger);
    }


}
