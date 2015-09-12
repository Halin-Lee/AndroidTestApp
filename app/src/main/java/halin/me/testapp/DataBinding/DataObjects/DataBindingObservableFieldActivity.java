package halin.me.testapp.DataBinding.DataObjects;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import halin.me.testapp.DataBinding.DataObjects.Model.ObservableFieldModel;
import halin.me.testapp.ObservableFieldBinding;
import halin.me.testapp.R;

/**
 * Created by halin on 9/12/15.
 */
public class DataBindingObservableFieldActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //通过DataBinding设置ContentView,并得到绑定模型
        ObservableFieldBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_observable_field);
        final ObservableFieldModel object = new ObservableFieldModel();
        dataBinding.setObservableField(object);


        //直接对binding的某个field的子field赋值,view能收到更新,
        object.firstField.set("First Name");
        object.secondField.set(new Object(){
            @Override
            public String toString() {
                return "Second Field";
            }
        });
        object.thirdField.set(10);


        //延迟,修改值,ui随之修改
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                object.firstField.set("First Name 2");
                object.secondField.set(new Object(){
                    @Override
                    public String toString() {
                        return "Second Field 2";
                    }
                });
                object.thirdField.set(22);
            }
        },5000);
    }
}

