package me.halin.testapp.ModelConverter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * 声明该类所接受的转换Annotation类
 * <p/>
 * Created by halin on 12/21/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE})
public @interface ModelConvertClass {
    /**
     * 声明该类所接受的转换Annotation类
     */
    Class[] value();
}
