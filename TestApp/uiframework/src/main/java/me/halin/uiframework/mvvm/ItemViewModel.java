package me.halin.uiframework.mvvm;

import android.databinding.ObservableField;

/**
 * 子ViewModel，对应列表的每一个项
 * Created by halin on 4/17/17.
 */

public class ItemViewModel {

    public final ObservableField<String> item = new ObservableField<>();
    public final ObservableField<String> nickname = new ObservableField<>();

    ItemViewModel() {
        nickname.set("");
    }
}
