package yqtrack.app.androiduidemo.main;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import yqtrack.app.androiduidemo.main.model.TestItem;


/**
 * Holder,所有Activity涉及到的模型及回调都在这里
 * <p>
 * Created by halin on 9/17/15.
 */
public class MainViewModel {

    /**
     * 测试清单
     */
    public final ObservableArrayList<TestItem> testList = new ObservableArrayList<>();
    /**
     * 点击回调
     */
    public final ObservableField<ItemClickListener> itemClickListener = new ObservableField<>();

    /**
     * 测试点击
     */
    public interface ItemClickListener {
        void onItemClick(TestItem item);
    }


}
