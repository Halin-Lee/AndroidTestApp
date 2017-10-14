package me.halin.android.annotations;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by halin on 3/16/17.
 */

public class ThreadAnnotationsActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //只有在AppCompatActivity才有作用
        workerThread();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        workerThread();
    }

    public void test(Activity activity) {
        //不提示，并没有什么卵用
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                workerThread();
            }
        });

    }

    @WorkerThread
    public void workerThread() {
    }
}
