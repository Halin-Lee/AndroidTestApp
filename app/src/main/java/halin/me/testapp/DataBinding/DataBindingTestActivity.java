package halin.me.testapp.DataBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import halin.me.testapp.BindTestData;
import halin.me.testapp.DataBinding.view.BindModel;
import halin.me.testapp.R;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BindTestData dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_test);
        BindModel model = new BindModel();
        model.stringToShow = "Yes!";
        dataBinding.setBindModel(model);
    }


}
