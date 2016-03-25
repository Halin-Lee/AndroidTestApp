package me.halin.testapp.EspressonTestDemo.base;

/**
 *
 * List绑定模型回调
 *
 * Created by halin on 8/15/15.
 */
public interface ListItemListener<T> {
    void itemCallback(T t,int position);
}
