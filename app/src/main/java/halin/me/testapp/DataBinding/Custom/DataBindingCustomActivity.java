package halin.me.testapp.DataBinding.Custom;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import halin.me.testapp.DataBinding.Custom.Model.DataBindingCustomBinder;
import halin.me.testapp.R;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingCustomActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //通过DataBinding设置ContentView,并得到绑定模型
        DataBindingCustomBinder dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_custom);

        //打出binder类型 variable无法使用自己类型作为参数,即type为halin.me.testapp.DataBinding.Custom.Model.DataBindingCustomBinder
        dataBinding.setBinder(dataBinding.getClass().getName());
    }
}
