package me.halin.testapp.SystemUI.databinding.OnRebind;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Observable;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.R;
import me.halin.testapp.databinding.ActivityDataBindingOnRebindBinding;

public class DataBindingOnRebindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_on_rebind);

        final ActivityDataBindingOnRebindBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_on_rebind);
        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                Logger.debug("onPreBind");
                return super.onPreBind(binding);
            }

            @Override
            public void onCanceled(ViewDataBinding binding) {
                Logger.debug("onCanceled");
                super.onCanceled(binding);
            }

            @Override
            public void onBound(ViewDataBinding binding) {
                Logger.debug("onBound");
                super.onBound(binding);
            }
        });

        final ViewModel viewModel = new ViewModel();
        binding.setBindModel(viewModel);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModel.observableString.set("Str");
            }
        }, 3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.setBindModel(new ViewModel());
            }
        }, 6000);


    }


    public static class ViewModel {
        public final ObservableField<String> observableString = new ObservableField<>();
    }

}
