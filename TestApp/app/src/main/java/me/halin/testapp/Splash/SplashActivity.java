package me.halin.testapp.Splash;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

import me.halin.testapp.main.MainActivity;
import me.halin.testapp.databinding.Base.DataBindingBaseActivity;

/**
 * Created by Halin on 3/21/16.
 */
public class SplashActivity extends Activity {

    public static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent mainIntent = new Intent(this, MainActivity.class);
//        Intent dataBindingIntent = new Intent(this, DataBindingBaseActivity.class);
//        Intent[] intents = new Intent[]{mainIntent, dataBindingIntent};
//        startActivities(intents);

        startActivity(mainIntent);
//        startActivity(dataBindingIntent);
        this.finish();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


}
