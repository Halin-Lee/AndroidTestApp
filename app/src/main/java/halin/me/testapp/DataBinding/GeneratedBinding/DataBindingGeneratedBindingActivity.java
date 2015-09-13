package halin.me.testapp.DataBinding.GeneratedBinding;

import android.app.ActionBar;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import halin.me.testapp.GeneratedBinding;
import halin.me.testapp.R;

/**
 * Created by halin on 9/13/15.
 */
public class DataBindingGeneratedBindingActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //构造容器(与DataBinding无关,只为了展示结果)
        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -1);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);
        setContentView(layout);


        //先绑定再设置View
        LayoutInflater inflater = LayoutInflater.from(this);
        GeneratedBinding binding = GeneratedBinding.inflate(inflater);
        layout.addView(binding.getRoot());
        binding.setString("先绑定再设置View");


        //通过bind方法绑定
        View v = inflater.inflate(R.layout.activity_data_binding_generated_binding, null);
        layout.addView(v);
        binding = GeneratedBinding.bind(v);
        binding.setString("通过bind方法绑定");


        //通过inflate方法绑定
        binding = GeneratedBinding.inflate(inflater);
        layout.addView(binding.getRoot());
        binding.setString("通过inflate方法绑定");

        //通过DataBindingUtil的bind方法绑定
        v = inflater.inflate(R.layout.activity_data_binding_generated_binding, null);
        layout.addView(v);
        binding = DataBindingUtil.bind(v);
        binding.setString("通过DataBindingUtil的bind方法绑定");

        //通过DataBindingUtil的getBinding方法绑定
        v = inflater.inflate(R.layout.activity_data_binding_generated_binding, null);
        layout.addView(v);
        DataBindingUtil.bind(v);
        binding = DataBindingUtil.getBinding(v);
        binding.setString("通过DataBindingUtil的getBinding方法绑定");

        //通过DataBindingUtil的findBinding方法绑定
        v = inflater.inflate(R.layout.activity_data_binding_generated_binding, null);
        layout.addView(v);
        DataBindingUtil.bind(v);
        binding = DataBindingUtil.findBinding(((ViewGroup)v).getChildAt(0));        //findBinding会根据view向其父view寻找binding
        binding.setString("通过DataBindingUtil的findBinding方法绑定");

        //DataBinding通过id获得view
        binding.testViewId.setTextColor(0xFF0000ff);




    }
}
