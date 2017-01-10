package me.halin.testapp.Test;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.halin.testapp.R;

public class DrawableTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_test);
    }


    public void playTransition(View view) {
        TransitionDrawable drawable = ((TransitionDrawable) view.getBackground());
        drawable.setCrossFadeEnabled(true);
        drawable.reverseTransition(3000);
    }


    public void playClip(View view) {

        ClipDrawable clipDrawable = (ClipDrawable) view.getBackground();
        int level = clipDrawable.getLevel();
        if (level > 9000)
            clipDrawable.setLevel(0);
        else {
            clipDrawable.setLevel(level + 1000);
        }
    }

    public void playScale(View view) {
        ScaleDrawable scaleDrawable = (ScaleDrawable) view.getBackground();
        int level = scaleDrawable.getLevel();
        if (level > 9000)
            scaleDrawable.setLevel(0);
        else {
            scaleDrawable.setLevel(level + 1000);
        }
    }

    public void playRipple(View view) {
    }
}
