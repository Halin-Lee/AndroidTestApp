package me.halin.android.ui.transitionmanager;

import android.support.annotation.NonNull;
import android.support.design.internal.TextScale;
import android.support.transition.Fade;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import me.halin.android.R;
import me.halin.android.parentactivity.ParentActivity;

public class TransitionManagerActivity extends AppCompatActivity {

    View animationView;
    ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_manager);
        rootView = (ViewGroup) findViewById(R.id.content);
        animationView = findViewById(R.id.animation_view);
        findViewById(R.id.begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition transition = new Fade();
                transition.setStartDelay(2000);

                TransitionManager.beginDelayedTransition(rootView, transition);
                animationView.setVisibility(View.GONE == animationView.getVisibility() ? View.VISIBLE : View.GONE);
            }
        });
    }
}
