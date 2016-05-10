package me.halin.testapp.FragmentDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.R;

/**
 * Created by Halin on 5/9/16.
 */
public class FragmentTestActivity extends AppCompatActivity {
    FragmentManager fragmentManger;
    TestFragmentA testFragmentA = new TestFragmentA();
    TestFragmentB testFragmentB = new TestFragmentB();

    boolean state = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        fragmentManger = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
        fragmentTransaction.add(R.id.fragment_frame, testFragmentA);
        fragmentTransaction.commit();
    }

    public void replace(View v) {
        Logger.debug("显示FragmentA");
        if (state) {

            final FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.anim_scale_in, R.anim.anim_scale_out);
//            fragmentTransaction.hide(testFragmentA);
            fragmentTransaction.remove(testFragmentA);
            fragmentTransaction.commit();
//            fragmentTransaction = fragmentManger.beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.anim_scale_out, R.anim.anim_scale_in);
//            fragmentTransaction.add(R.id.fragment_frame, testFragmentB);
//            fragmentTransaction.commit();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Logger.debug("显示FragmentB" + fragmentManger.getFragments());
//                    FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
//                    fragmentTransaction.remove(testFragmentB);
//                    fragmentTransaction.setCustomAnimations(R.anim.anim_scale_in, R.anim.anim_scale_out);
//                    fragmentTransaction.commit();
//                    TestFragmentA testFragmentA = new TestFragmentA();
                    FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.anim_scale_out, R.anim.anim_scale_in);
                    fragmentTransaction.add(R.id.fragment_frame, testFragmentA);
//                    fragmentTransaction.show(testFragmentA);
                    fragmentTransaction.commit();
                }
            });
        } else {

        }
        state = !state;
    }
}
