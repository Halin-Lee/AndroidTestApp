package me.halin.testapp.Robolectric;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.halin.testapp.R;

/**
 * Created by Halin on 5/18/16.
 */
public class RobolectricDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robolectric_demo);
        setTitle("RobolectricDemo");
    }
}
