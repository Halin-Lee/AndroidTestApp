package me.halin.testapp.AutoEventTracking.Demo;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import me.halin.testapp.LogUtil.Logger;
import me.halin.testapp.R;

/**
 * Created by 17track on 3/25/16.
 */
public class AutoEventTrackingDemoAdapter extends PagerAdapter {


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());

        View view = layoutInflater.inflate(R.layout.event_tracking_demo_item, null);
        //id默认为0,必须添加前缀避开0这个id
        view.setId(10000 + position);
//        TextView textView = new TextView(container.getContext());
//        textView.setText("View:" + position);
        Logger.debug("container:" + container + " containerid:" + container.getId());
        container.addView(view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
