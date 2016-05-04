package me.halin.testapp.databinding.Include;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import me.halin.testapp.R;
import me.halin.testapp.databinding.ActivityDataBindingIncludeBinding;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingIncludeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //通过DataBinding设置ContentView,并得到绑定模型
        ActivityDataBindingIncludeBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_include);
//        通过主layout和subLayout共享实现binding
//        dataBinding.setString("Here is a string from DataBindingIncludeActivity");
//        setContentView(R.layout.activity_data_binding_include_sub);
    }
}
