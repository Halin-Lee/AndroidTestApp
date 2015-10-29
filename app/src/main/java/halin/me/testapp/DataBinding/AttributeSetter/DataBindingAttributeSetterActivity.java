package halin.me.testapp.DataBinding.AttributeSetter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import halin.me.testapp.AttributeSetterBinding;
import halin.me.testapp.R;

/**
 * Created by halin on 10/29/15.
 */
public class DataBindingAttributeSetterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //通过DataBinding设置ContentView,并得到绑定模型
        AttributeSetterBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_attribute_setter);

        //构造模型并设置到绑定模型中

        dataBinding.setString("Yes I am!");
    }
}
