package me.halin.testapp.ModuleLoader;

import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 在模块表(ModuleDeclaration)中,指明模块对应的类的声明,
 * 该注解对应的Module必须为类,如
 *
 * @ModuleName("DemoModuleConfiguration")
 * <p>
 * public static final Class demoModuleConfiguration = DemoModuleConfiguration.class;
 * <p>
 * Created by 17track on 3/27/16.
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface ModuleName {
    @NonNull String value();
}
