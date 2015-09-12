package halin.me.testapp.DataBinding.DataObjects;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import halin.me.testapp.DataBinding.DataObjects.Model.ObservableObjectModel;
import halin.me.testapp.ObservableObjectBinding;
import halin.me.testapp.R;

/**
 *
 * 监听内容
 *
 * Created by halin on 9/12/15.
 */
public class DataBindingObservableObjectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //通过DataBinding设置ContentView,并得到绑定模型
        ObservableObjectBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_observable_object);
        final ObservableObjectModel object = new ObservableObjectModel();
        dataBinding.setObservableObject(object);


        //直接对binding的某个field的子field赋值,view能收到更新,
        object.setFirstName("First Name");
        object.setLastName("Last Name");


        //延迟,修改值,ui随之修改
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                object.setFirstName("First Name 2");
                object.setLastName("Last Name 2");
            }
        }, 5000);
    }
}
