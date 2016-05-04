package me.halin.daggerstudy.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.halin.daggerstudy.Dagger2.Dagger2Demo;


/**
 * 主启动Activity
 */
public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();


    static {
        Log.e(TAG, "初始化");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Dagger2Demo.test(this);
    }


}
