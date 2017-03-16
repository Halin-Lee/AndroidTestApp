package me.halin.android.ui.inputtextlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.halin.android.R;


public class TextInputLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_text_layout);

        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.text_input_layout);

        //显示输入数量
        textInputLayout.setCounterEnabled(true);
        //限制输入数量，需要和setCounterEnabled配合
        textInputLayout.setCounterMaxLength(50);
        //允许错误
//        textInputLayout.setErrorEnabled(true);
//        textInputLayout.setError("Error");

        textInputLayout.setHint("Hint");
        textInputLayout.setPasswordVisibilityToggleContentDescription("Password");
        textInputLayout.setPasswordVisibilityToggleEnabled(true);
    }

}
