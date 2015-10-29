package halin.me.testapp.DataBinding.AttributeSetter.View;

import android.content.Context;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by halin on 10/29/15.
 */
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


}
