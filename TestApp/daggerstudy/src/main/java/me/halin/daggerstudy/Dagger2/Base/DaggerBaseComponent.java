package me.halin.daggerstudy.Dagger2.Base;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 *
 *
 * Created by 17track on 4/8/16.
 */
@Singleton
@Component(modules = {DaggerBaseModule.class})
public interface DaggerBaseComponent {

    Context getContext();

    void inject(DaggerBaseDemo activity);
}
