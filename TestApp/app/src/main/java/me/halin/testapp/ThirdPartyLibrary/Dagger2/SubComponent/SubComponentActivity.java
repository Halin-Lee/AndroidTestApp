package me.halin.testapp.ThirdPartyLibrary.Dagger2.SubComponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import me.halin.testapp.R;
import me.halin.testapp.main.LogStringBaseActivity;

public class SubComponentActivity extends LogStringBaseActivity {

    @Inject
    DemoObject demoObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSubComponentComponent.builder().build().subComponent().inject(this);


        append("注入文本:%s,注入参数:%d", this.demoObject.string, this.demoObject.num);
    }

    public class InnerObject {


    }
}
