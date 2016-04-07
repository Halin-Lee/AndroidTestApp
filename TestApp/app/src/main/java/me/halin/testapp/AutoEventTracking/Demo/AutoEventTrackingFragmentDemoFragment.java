package me.halin.testapp.AutoEventTracking.Demo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.halin.testapp.LogUtil.Logger;
import me.halin.testapp.R;


/**
 * Created by 17track on 4/6/16.
 */
public class AutoEventTrackingFragmentDemoFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auto_event_tracking_fragment_demo, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.debug("onResume" + getArguments().getInt("id"));


    }
}
