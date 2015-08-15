package halin.me.testapp.DataBindingEvent;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import halin.me.testapp.R;
import halin.me.testapp.databinding.ActivityDataBindingEventBinding;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingEventBinding bindingEventBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_event);
        bindingEventBinding.setActivity(this);
    }

    public void onCancelClick(View view){
        Toast.makeText(this,"onCancelClick",Toast.LENGTH_SHORT).show();

    }

    public void onStartClick(View view){
        Toast.makeText(this,"onStartClick",Toast.LENGTH_SHORT).show();
    }
}
