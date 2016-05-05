package me.halin.testapp.Dagger2.Base;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 声明提供的对象,
 * <p/>
 * Created by 17track on 4/8/16.
 */

@Module
public class DaggerBaseModule {
    Context context;

    public DaggerBaseModule(Context context) {
        this.context = context;
    }

    /**
     * 晟敏提供的对象
     */
    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }


}
