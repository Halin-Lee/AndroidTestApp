package me.halin.uiframework.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import me.halin.uiframework.R;
import me.halin.uiframework.databinding.MvvmItemBinding;

/**
 * Created by halin on 4/17/17.
 */

public class ListViewAdapter extends BaseAdapter {

    private final MainViewModel mainViewModel;

    public ListViewAdapter(MainViewModel mainViewModel) {
        //接收到ViewModel并绑定事件
        this.mainViewModel = mainViewModel;
        this.mainViewModel.items.addOnMapChangedCallback(new ObservableMap.OnMapChangedCallback<ObservableMap<Integer, ItemViewModel>, Integer, ItemViewModel>() {
            @Override
            public void onMapChanged(ObservableMap<Integer, ItemViewModel> integerItemViewModelObservableMap, Integer integer) {
                //一旦ViewModel有位置更新，自行刷新
                ListViewAdapter.this.notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getCount() {
        return mainViewModel.items.size();
    }

    @Override
    public Object getItem(int position) {
        return mainViewModel.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = (TextView) convertView;

        MvvmItemBinding binding;
        if (textView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.mvvm_item, parent, false);
            textView = (TextView) binding.getRoot();
        } else {
            binding = DataBindingUtil.getBinding(textView);
        }
        binding.setViewModel(mainViewModel.items.get(position));
        return textView;
    }
}
