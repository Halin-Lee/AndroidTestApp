package me.halin.testapp.AutoEventTracking.Demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.halin.testapp.AutoEventTracking.AutoEventTracker;
import me.halin.testapp.AutoEventTracking.AutoEventTrackerXMLLoader;
import me.halin.testapp.R;

/**
 * Created by 17track on 3/25/16.
 */
public class AutoEventTrackingDemoActivity extends Activity {

    private static final String TAG = AutoEventTrackingDemoActivity.class.getName();

    private AutoEventTracker tracker;

    private TextView clickableTextView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_event_tracking_demo);
        clickableTextView = (TextView) findViewById(R.id.auto_event_tracking_demo_view_with_click_event);
        clickableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastString = String.format("View:%s  onClick", v);
                Toast.makeText(AutoEventTrackingDemoActivity.this, toastString, Toast.LENGTH_SHORT).show();
            }
        });


        viewPager = (ViewPager) findViewById(R.id.auto_event_tracking_demo_view_pager);
        viewPager.setAdapter(new AutoEventTrackingDemoAdapter());


        AutoEventTrackerXMLLoader.getInstance().loadFromXml(this, R.xml.event_tracker_demo_list);
        tracker = new AutoEventTracker(this);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        tracker.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }


}
