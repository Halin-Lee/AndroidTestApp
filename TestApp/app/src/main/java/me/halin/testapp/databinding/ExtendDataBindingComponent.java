package me.halin.testapp.databinding;

import android.databinding.DataBindingComponent;

import dagger.Component;

/**
 * DataBinding与Dagger2冲突,需要自定义一个component
 * <p/>
 * Created by Halin on 5/5/16.
 */
@Component
public interface ExtendDataBindingComponent extends android.databinding.DataBindingComponent {
}
