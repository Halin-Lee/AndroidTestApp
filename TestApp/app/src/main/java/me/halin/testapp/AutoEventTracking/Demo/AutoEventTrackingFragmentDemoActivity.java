package me.halin.testapp.AutoEventTracking.Demo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toolbar;

import java.util.Locale;

import me.halin.testapp.AutoEventTracking.AutoEventTracker;
import me.halin.testapp.AutoEventTracking.AutoEventTrackerXMLLoader;
import me.halin.testapp.AutoEventTracking.EventTrackerCallback;
import me.halin.testapp.AutoEventTracking.EventTrackerDefaultCallback;
import me.halin.testapp.AutoEventTracking.TrackEventItem;
import me.halin.testapp.R;


/**
 * Created by 17track on 4/6/16.
 */
public class AutoEventTrackingFragmentDemoActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = AutoEventTrackingFragmentDemoActivity.class.getName();


    private AutoEventTracker tracker;
    private ViewPager viewPager;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
        }

        setContentView(R.layout.activity_auto_event_tracking_demo);
        viewPager = (ViewPager) findViewById(R.id.auto_event_tracking_demo_view_pager);
        viewPager.setAdapter(new AutoEventTrackingFragmentDemoAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);


        AutoEventTrackerXMLLoader.getInstance().loadFromXml(this, R.xml.event_tracker_demo_list);
        tracker = new AutoEventTracker(this, new EventTrackerDefaultCallback() {
            @Override
            public void callback(String page, String prefix, TrackEventItem item, String name) {
                if (item != null && item.getTag().equalsIgnoreCase("add page index")) {
                    name += "当前页面" + currentPage;
                }

                super.callback(page, prefix, item, name);
            }
        });
        currentPage = 0;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPage = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        tracker.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
