package me.halin.testapp.Dagger2.InnerClass;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import me.halin.testapp.Dagger2.Dagger2BaseActivity;

/**
 * Created by Halin on 5/6/16.
 */
public class DaggerInnerClassActivity extends Dagger2BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //内部类Component命名会比较奇怪
        InnerClass.InnerComponent innerComponent = DaggerDaggerInnerClassActivity_InnerClass_InnerComponent.create();

        InnerClass innerClass = innerComponent.innerClass();
        append("内部类注入内容:%s", innerClass.injectString);
    }


    static class InnerClass {

        @Inject
        String injectString;

        @Inject
        InnerClass() {
        }

        @Component(modules = {InnerModule.class})
        interface InnerComponent {
            InnerClass innerClass();

            String provideString();
        }
    }

    @Module
    static class InnerModule {

        @Provides
        String provideString() {
            return "innerModuleString";
        }

    }

}
