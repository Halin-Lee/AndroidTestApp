package me.halin.testapp.ThirdPartyLibrary.Dagger2.InjectMethod;

import javax.inject.Inject;

/**
 * Created by Halin on 5/5/16.
 */
public class DaggerMethodInjectDemo {

    private String string;

    @Inject
    public DaggerMethodInjectDemo(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
