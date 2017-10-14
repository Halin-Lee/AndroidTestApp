package me.halin.android.ui.fragmentretaininstance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import me.halin.android.R;
import me.halin.android.main.MainActivity;

/**
 * 证明Fragment的Retain是会随Activity的回收被回收的，Retain主要用户转屏
 */
public class FragmentRetainInstanceActivity extends AppCompatActivity {

    public static final String TAG = FragmentRetainInstanceActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_retain_instance);


        RetainFragment retainFragment = (RetainFragment) getSupportFragmentManager().findFragmentByTag(TAG);

        if (retainFragment != null && retainFragment.getString() != null) {
            Log.e(TAG, "找到 Fragment " + retainFragment.getString());
        } else {
            Log.e(TAG, "创建 Fragment ");
            retainFragment = new RetainFragment();
            retainFragment.setString("Reuse");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(retainFragment, TAG);
            transaction.commit();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FragmentRetainInstanceActivity.this, MainActivity.class));
            }
        }, 5000);


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment dialogFragment = new DialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "");
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
