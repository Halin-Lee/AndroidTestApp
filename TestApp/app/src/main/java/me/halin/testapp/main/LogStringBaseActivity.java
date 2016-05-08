package me.halin.testapp.main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.R;

/**
 * 实现日志显示的Activity
 * <p>
 * Created by Halin on 5/5/16.
 */
public class LogStringBaseActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_base_activity);
        textView = (TextView) findViewById(R.id.log_text);
        if (textView != null) {
            textView.setText("/*-------------测试开始---------------*/\n");
        }
    }


    public void append(String format, Object... args) {
        String formatStr = String.format(Locale.ENGLISH, format, args);
        textView.append(formatStr + "\n");
        Logger.debug(formatStr);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
