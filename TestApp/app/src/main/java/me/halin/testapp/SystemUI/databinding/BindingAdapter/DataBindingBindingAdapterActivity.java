package me.halin.testapp.SystemUI.databinding.BindingAdapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import me.halin.testapp.R;
import me.halin.testapp.databinding.ActivityDataBindingBindingAdapterBinding;

public class DataBindingBindingAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //通过DataBinding设置ContentView,并得到绑定模型
        final ActivityDataBindingBindingAdapterBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_binding_adapter);

        //构造模型并设置到绑定模型中
        BindModel model = new BindModel();
        model.stringToShow = "Yes!";
        model.setPrivateString("Private String");
        dataBinding.setBindModel(model);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataBinding.setBindModel(new BindModel());
            }
        }, 3000);

    }


    @BindingAdapter("custom:event_here")
    public static void setSwipeRefreshLayoutOnRefreshListener(TextView view,
                                                              final BindModel bindModel) {
        count++;
        view.setText("count" + count + bindModel.getPrivateString());
    }

    private static int count = 0;
}
