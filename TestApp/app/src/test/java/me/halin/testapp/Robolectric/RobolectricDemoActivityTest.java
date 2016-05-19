package me.halin.testapp.Robolectric;

import android.os.Build;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import me.halin.testapp.BuildConfig;

/**
 * Created by Halin on 5/18/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,sdk = Build.VERSION_CODES.LOLLIPOP)
public class RobolectricDemoActivityTest extends TestCase {

    @Test
    public void testOnCreate() throws Exception {
        RobolectricDemoActivity activity = Robolectric.setupActivity(RobolectricDemoActivity.class);
        assertTrue(activity.getTitle().equals("RobolectricDemo"));
    }
}