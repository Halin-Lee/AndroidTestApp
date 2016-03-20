package me.halin.testapp.ModelConverter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Created by halin on 12/21/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface ModelConverterAnnotationB {
    ModelConverterDeclareB value();


    enum ModelConverterDeclareB {
        FIELD1,
        FIELD2
    }

}
