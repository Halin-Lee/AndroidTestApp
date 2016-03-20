package me.halin.testapp.databinding.List.View;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import me.halin.testapp.ListBinding;
import me.halin.testapp.R;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    public DataBindingListAdapter(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }



    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //通过layoutInflate获得绑定
        ListBinding dataBinding =  DataBindingUtil.inflate(mInflater, R.layout.data_binding_list_item, parent, false);
        //设置绑定参数
        dataBinding.setBindListModel("Yes");
        //通过dataBinding获得对应的view
        return dataBinding.getRoot();
    }
}
