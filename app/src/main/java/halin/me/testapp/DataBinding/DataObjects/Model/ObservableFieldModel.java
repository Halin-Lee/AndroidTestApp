package halin.me.testapp.DataBinding.DataObjects.Model;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 *
 *  被监听的子类对象
 *
 * 通过ObservableField实现更新通知
 *
 * Created by halin on 9/12/15.
 */
public class ObservableFieldModel {
    //field不可为private
    public final ObservableField<String> firstField = new ObservableField<>();
    public final ObservableField<Object> secondField = new ObservableField<>();
    public final ObservableInt thirdField = new ObservableInt();
}
