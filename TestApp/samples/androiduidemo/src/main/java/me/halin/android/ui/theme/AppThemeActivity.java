package me.halin.android.ui.theme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.halin.android.R;

/**
 * 验证了selector中无法直接使用?attr方式，将颜色转换为drawable
 */
public class AppThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_theme);
    }
}
