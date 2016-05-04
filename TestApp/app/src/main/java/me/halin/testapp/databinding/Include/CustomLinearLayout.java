package me.halin.testapp.databinding.Include;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import me.halin.testapp.databinding.ActivityDataBindingIncludeSubBinding;


/**
 * Created by 17track on 4/18/16.
 */
public class CustomLinearLayout extends LinearLayout {

    public static final String TAG = "TAG";

    public CustomLinearLayout(Context context) {
        this(context, null);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Log.e(TAG, "child " + getChildCount() + "tag " + this.getTag());
        post(new Runnable() {
            @Override
            public void run() {
                ActivityDataBindingIncludeSubBinding binding = DataBindingUtil.bind(CustomLinearLayout.this);
                binding.setSubString("OK");
            }
        });

    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        Log.e(TAG, "child " + getChildCount() + "tag " + this.getTag());
        //使用post,可以在include的layout里面修改binding,但是写法很奇怪也不安全,不建议
        post(new Runnable() {
            @Override
            public void run() {
                ActivityDataBindingIncludeSubBinding binding = DataBindingUtil.bind(CustomLinearLayout.this);
                binding.setSubString("OK");
            }
        });
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }
}
