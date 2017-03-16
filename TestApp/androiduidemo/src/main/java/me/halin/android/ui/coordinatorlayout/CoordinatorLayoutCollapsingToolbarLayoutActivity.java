package me.halin.android.ui.coordinatorlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import me.halin.android.R;


public class CoordinatorLayoutCollapsingToolbarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_collapsing_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //允许navigation左上角点击
        getSupportActionBar().setHomeButtonEnabled(true);
        //home按键是否允许回退(如果允许显示回退,则无法自定义NavigationIcon)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
