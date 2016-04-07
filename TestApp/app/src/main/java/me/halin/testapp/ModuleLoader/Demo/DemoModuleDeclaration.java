package me.halin.testapp.ModuleLoader.Demo;

import me.halin.testapp.ModuleLoader.ModuleName;

/**
 * Created by 17track on 3/27/16.
 */

public class DemoModuleDeclaration {

    @ModuleName("SecondDemoModuleConfiguration")
    public static final Class secondDemoModuleConfiguration = SecondDemoModuleConfiguration.class;

    @ModuleName("FirstDemoModuleConfiguration")
    public static final Class firstDemoModuleConfiguration = FirstDemoModuleConfiguration.class;

}
