package me.halin.testapp.AutoEventTracking;

import android.content.Context;
import android.test.InstrumentationTestCase;


import java.util.List;

import me.halin.testapp.test.R;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Halin on 4/6/16.
 */
public class AutoEventTrackerXMLLoaderTest extends InstrumentationTestCase {

    public void testLoadFromXml() throws Exception {
        Context context = getInstrumentation().getContext();

        AutoEventTrackerXMLLoader loader = AutoEventTrackerXMLLoader.getInstance();
        loader.loadFromXml(context, R.xml.event_tracker_test_list);
        String activity = "me.halin.testapp.AutoEventTracking.Demo.AutoEventTrackingDemoActivity";
        List<TrackEventItem> itemList = loader.getItemForActivity(activity);
        TrackEventItem item = itemList.get(0);
        assertThat(item.getId(), is(R.id.test_id_1));
        assertThat(item.getType(), is(TrackEventItem.TYPE_TAP));
    }
}