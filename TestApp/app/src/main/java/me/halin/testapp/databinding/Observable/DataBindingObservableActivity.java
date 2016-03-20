package me.halin.testapp.databinding.Observable;

import android.app.Activity;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import me.halin.testapp.R;

/**
 *
 * 自定义ObservableField监听
 *
 * Created by halin on 9/17/15.
 */
public class DataBindingObservableActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_observable);
        final TextView textView = (TextView) findViewById(R.id.text);
        final ObservableModel model = new ObservableModel();
        model.observableString.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {

                textView.setText( ((ObservableField<String>)sender).get());
            }
        });
        model.observableString.set("Start");
        Toast.makeText(this,"5秒后修改数据",Toast.LENGTH_SHORT).show();

        //5秒后修改数据
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                model.observableString.set("Changed");
            }
        },5000);

    }
}
