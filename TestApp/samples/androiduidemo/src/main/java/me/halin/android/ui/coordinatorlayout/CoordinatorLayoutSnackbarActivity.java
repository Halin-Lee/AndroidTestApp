package me.halin.android.ui.coordinatorlayout;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.halin.android.R;


public class CoordinatorLayoutSnackbarActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_snackbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar 只在 CoordinatorLayout 下起作用
                Snackbar.make(coordinatorLayout,
                        "This is a simple Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("CLOSE", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Custom action
                            }
                        }).show();
            }
        });
    }


    //这是一个Bug 在xml中定义onClick已经无用 https://code.google.com/p/android/issues/detail?id=174871
    public void broken(View view) {
    }
}
