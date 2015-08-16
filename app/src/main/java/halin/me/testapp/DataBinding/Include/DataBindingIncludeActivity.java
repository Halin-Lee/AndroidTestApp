package halin.me.testapp.DataBinding.Include;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import halin.me.testapp.BaseBinding;
import halin.me.testapp.R;
import halin.me.testapp.databinding.ActivityDataBindingIncludeBinding;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingIncludeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //通过DataBinding设置ContentView,并得到绑定模型
        ActivityDataBindingIncludeBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_include);
        dataBinding.setString("Here is a string from DataBindingIncludeActivity");
//        setContentView(R.layout.activity_data_binding_include_sub);
    }
}
