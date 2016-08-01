package me.halin.testapp.MonkeyRunner;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Halin on 5/19/16.
 */
public class MonkeyRunnerDemoActivity extends AppCompatActivity {

    public static final String TAG = MonkeyRunnerDemoActivity.class.getName();

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        String event = String.format(Locale.ENGLISH, "点击类型:%d,x:%f,y:%f", ev.getAction(), ev.getX(), ev.getY());

        Toast.makeText(MonkeyRunnerDemoActivity.this, event, Toast.LENGTH_SHORT).show();
        Log.i(TAG, event);
        return super.dispatchTouchEvent(ev);
    }
}
