package me.halin.uiframework.mvvm;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;

import java.util.List;

/**
 * 主ViewModel
 * Created by halin on 4/18/17.
 */

public class MainViewModel implements ViewInterface {

    //当前页面对应的Presenter
    Presenter presenter = new Presenter(this);

    //是否正在请求
    public ObservableBoolean requesting = new ObservableBoolean();


    ObservableArrayMap<Integer, ItemViewModel> items = new ObservableArrayMap<>();

    ItemViewModel getViewModel(int index) {
        ItemViewModel viewModel = items.get(index);
        if (viewModel == null) {
            viewModel = new ItemViewModel();
            items.put(index, viewModel);
        }
        return viewModel;
    }


    @Override
    public void onResult(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            ItemViewModel viewModel = getViewModel(i);
            viewModel.item.set(list.get(i));
        }
        requesting.set(false);

    }

    @Override
    public void onNicknameResult(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            ItemViewModel viewModel = getViewModel(i);
            viewModel.nickname.set(list.get(i));
        }
    }

    public void start(String text) {
        presenter.start(text);
        requesting.set(true);
    }

    public void getNickname() {
        presenter.getNickname();
    }
}
