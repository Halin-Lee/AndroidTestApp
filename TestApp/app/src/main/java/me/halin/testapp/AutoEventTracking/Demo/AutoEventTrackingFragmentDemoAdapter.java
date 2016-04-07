package me.halin.testapp.AutoEventTracking.Demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 17track on 4/6/16.
 */
public class AutoEventTrackingFragmentDemoAdapter extends FragmentStatePagerAdapter {

    public AutoEventTrackingFragmentDemoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new AutoEventTrackingFragmentDemoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", 10000 + position);
        fragment.setArguments(bundle);
        return fragment;
    }
}
