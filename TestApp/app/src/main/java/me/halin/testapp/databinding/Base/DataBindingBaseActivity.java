package me.halin.testapp.databinding.Base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import me.halin.testapp.BaseBinding;
import me.halin.testapp.databinding.Base.Model.BindModel;
import me.halin.testapp.R;

/**
 * dataBinding基本使用
 * <p/>
 * <p/>
 * 一个View  对应 一个dataBinding
 * <p/>
 * Created by halin on 8/15/15.
 */
public class DataBindingBaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //通过DataBinding设置ContentView,并得到绑定模型
        BaseBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_base);

        //构造模型并设置到绑定模型中
        BindModel model = new BindModel();
        model.stringToShow = "Yes!";
        model.setPrivateString("Private String");
        dataBinding.setBindModel(model);
    }


}
