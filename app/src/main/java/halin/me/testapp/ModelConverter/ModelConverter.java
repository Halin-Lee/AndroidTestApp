package halin.me.testapp.ModelConverter;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by halin on 12/21/15.
 */
public class ModelConverter<T, E> {

    /**
     * 两个类转换所涉及的类
     */
    public Set<Class> convertClasses = new HashSet<>();

    public Map<Enum, Field> tConvertField = new HashMap<>();

    public Map<Enum, Field> eConvertField = new HashMap<>();

    public Map<Field, Field> convertMap = new HashMap<>();


    private Class<T> tClass;
    private Class<E> eClass;

    public ModelConverter(Class<T> tClass, Class<E> eClass) {
        this(tClass, eClass, null);
    }

    public ModelConverter(Class<T> tClass, Class<E> eClass, Set<Class> classes) {


        this.tClass = tClass;
        this.eClass = eClass;

        if (classes != null && classes.size() != 0) {
            //有指定转换类型,使用指定转换类型
            convertClasses.addAll(classes);
        } else {
            //没有指定转换类型,自动搜索转换类型
            getConvertClass();
        }


        Field[] tFields = tClass.getDeclaredFields();
        Field[] eFields = eClass.getDeclaredFields();

        for (Class clazz : convertClasses) {
            getAnnotationField(tFields, clazz, tConvertField);
            getAnnotationField(eFields, clazz, eConvertField);
        }

        for (Enum e : eConvertField.keySet()) {

            Field tField = tConvertField.get(e);
            Field eField = eConvertField.get(e);
            if (tField != null && eField != null) {
                convertMap.put(tField, eField);
            }
        }


    }

    /**
     * 获得
     */
    public void getConvertClass() {

        ModelConvertClass tClassAnnotation = tClass.getAnnotation(ModelConvertClass.class);
        //获得t所有指明可以转换的类
        Set<Class> tAnnotationClassesSet = new HashSet<>();
        Collections.addAll(tAnnotationClassesSet, tClassAnnotation.value());

        ModelConvertClass eClassAnnotation = eClass.getAnnotation(ModelConvertClass.class);
        Class[] eAnnotationClasses = eClassAnnotation.value();
        for (Class clazz : eAnnotationClasses) {
            if (tAnnotationClassesSet.contains(clazz)) {
                convertClasses.add(clazz);
            }
        }
    }

    /**
     * 遍历field,找出所有带clazz的Annotation,插入到map中
     */
    private void getAnnotationField(Field[] fields, Class<Annotation> clazz, Map<Enum, Field> map) {
        for (Field field : fields) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(clazz);
            if (annotation != null) {
                try {
                    Method method = annotation.getClass().getMethod("value");
                    if (method != null) {
                        Enum key = (Enum) method.invoke(annotation);
                        if (key != null) {
                            map.put(key, field);
                        }
                    }

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public <I, O> O convert(@NonNull I i, O o) {
        Class iClass = i.getClass();
        Class oClass = o.getClass();
        if (iClass == tClass && oClass == eClass) {
            for (Map.Entry<Field, Field> entry : convertMap.entrySet()) {
                Field tField = entry.getKey();
                Field eField = entry.getValue();
                try {
                    Object obj = tField.get(i);
                    eField.set(o, obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        } else if (iClass == eClass && oClass == iClass) {
            for (Map.Entry<Field, Field> entry : convertMap.entrySet()) {
                Field tField = entry.getKey();
                Field eField = entry.getValue();
                try {
                    Object obj = eField.get(i);
                    tField.set(o, obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } else {
            String detailStr = String.format("Invalid input type receive:%s %s", iClass, oClass);
            throw new IllegalArgumentException(detailStr);
        }
        return o;
    }


    public <I, O> O convert(I i) {
        Class iClass = i.getClass();
        O o = null;
        if (iClass == tClass) {

            try {
                o = (O) eClass.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("类型实例获取错误", e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("类型实例获取错误", e);
            }

            for (Map.Entry<Field, Field> entry : convertMap.entrySet()) {
                Field tField = entry.getKey();
                Field eField = entry.getValue();
                try {
                    Object obj = tField.get(i);
                    eField.set(o, obj);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("参数设置错误", e);
                }
            }

        } else if (iClass == eClass) {

            try {
                o = (O) tClass.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("类型实例获取错误", e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("类型实例获取错误", e);
            }

            for (Map.Entry<Field, Field> entry : convertMap.entrySet()) {
                Field tField = entry.getKey();
                Field eField = entry.getValue();
                try {
                    Object obj = eField.get(i);
                    tField.set(o, obj);
                } catch (IllegalAccessException e) {

                    throw new RuntimeException("参数设置错误", e);
                }
            }
        } else {
            String detailStr = String.format("Invalid input type receive:%s ", iClass);
            throw new IllegalArgumentException(detailStr);
        }
        return o;
    }
}
