package me.halin.testapp.SystemUI.databinding.AttributeSetter.View;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by halin on 10/29/15.
 */
//将方法绑定到xml属性
@BindingMethods({
        @BindingMethod(type = TextView.class,
                attribute = "android:customAttribute",
                method = "setAttribute")
})
public class AttributeSetterView extends TextView {


    public AttributeSetterView(Context context) {
        super(context);
    }

    public AttributeSetterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AttributeSetterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AttributeSetterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void setAttribute(String string) {
        setText(string);
    }

    //将方法绑定到xml属性
    @BindingAdapter("android:customBindingAdapter")
    public static void setCustomViewText(TextView view, String string) {
        view.setText(string);
    }


    @BindingAdapter({"android:customBindingAdapterText1", "android:customBindingAdapterText2"})
    public static void setCustomViewText1(TextView view, String string1, String string2) {
        view.setText(string1 + string2);
    }


}
