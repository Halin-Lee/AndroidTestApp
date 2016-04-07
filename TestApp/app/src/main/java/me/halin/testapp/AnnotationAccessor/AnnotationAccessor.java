package me.halin.testapp.AnnotationAccessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import me.halin.testapp.LogUtil.Logger;

/**
 * 注解写入工具
 * <p>
 * Created by 17track on 3/27/16.
 */
public class AnnotationAccessor {

    public static final String TAG = AnnotationAccessor.class.getName();

    public Map<Object, Field> fieldMap = new HashMap<>();

    public AnnotationAccessor(Class clazz, Class<? extends Annotation> annotationClass) {

        //找到value()方法
        Method valueMethod;
        try {
            valueMethod = annotationClass.getMethod("value");
        } catch (NoSuchMethodException e) {
            Logger.logE(TAG, "找不到value方法 %s", e);
            return;
        }

        //解析field
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(annotationClass);
            if (annotation != null) {

                try {
                    Object key = valueMethod.invoke(annotation);
                    fieldMap.put(key, field);
                } catch (IllegalAccessException e) {
                    Logger.logE(TAG, "调用value方法失败 %s", e);
                } catch (InvocationTargetException e) {
                    Logger.logE(TAG, "调用value方法失败 %s", e);
                }
            }

        }
    }


    public boolean set(Object object, Object key, Object value) {

        //取出field
        Field field = fieldMap.get(key);
        if (field == null) {
            return false;
        }

        //赋值
        try {
            field.set(object, value);
            return true;
        } catch (IllegalAccessException e) {
            Logger.logE(TAG, "赋值失败 %s", e);
            return false;
        }
    }

    public Object get(Object object, Object key) {

        //取出field
        Field field = fieldMap.get(key);
        if (field == null) {
            return null;
        }

        //取值
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            Logger.logE(TAG, "取值失败 %s", e);
            return null;
        }
    }
}
