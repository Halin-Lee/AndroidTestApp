package me.halin.testapp.ModuleLoader;

import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 声明在Configuration中,Field在AppEnvironmentConfig中所对应的名词,如
 *
 * @ConfigField("testStringValue") private String testStringValue;
 * <p>
 * 对应xml
 * <string androidName="testStringValue">stringValue</string>
 * <p>
 * <p>
 * Created by Halin on 3/26/16.
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface ConfigField {

    @NonNull String value();

}
