package halin.me.testapp.DataBinding.Base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import halin.me.testapp.BaseBinding;
import halin.me.testapp.DataBinding.Base.view.BindModel;
import halin.me.testapp.R;

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
        dataBinding.setBindModel(model);
    }


}
