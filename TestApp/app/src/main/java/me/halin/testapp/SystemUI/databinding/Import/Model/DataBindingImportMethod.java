package me.halin.testapp.SystemUI.databinding.Import.Model;

/**
 *
 * 方法使用
 *
 * Created by halin on 8/15/15.
 */
public class DataBindingImportMethod {

    //提供一个静态方法
    public static String staticMethod(String string){
        return "static method :" + string;
    }

    //提供一个方法
    public String method(String string){
        return "method :" + string;
    }
}
