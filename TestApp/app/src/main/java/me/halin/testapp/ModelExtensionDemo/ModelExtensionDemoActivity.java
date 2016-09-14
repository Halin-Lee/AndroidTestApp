package me.halin.testapp.ModelExtensionDemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.halin.testapp.R;
import me.halin.testapp.databinding.ActivityModelExtensionDemoBinding;

/**
 * Created by Halin on 9/14/16.
 */
public class ModelExtensionDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityModelExtensionDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_model_extension_demo);
        ModelExtensionDBModel dbModel = new ModelExtensionDBModel();
        dbModel.setAge(11);
        ModelExtensionUIModel uiModel = new ModelExtensionUIModel(dbModel);
        binding.setUiModel(uiModel);

    }
}
