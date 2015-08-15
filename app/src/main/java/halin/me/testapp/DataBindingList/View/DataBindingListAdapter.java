package halin.me.testapp.DataBindingList.View;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import halin.me.testapp.R;

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

        halin.me.testapp.BindListData dataBinding =  DataBindingUtil.inflate(mInflater, R.layout.data_binding_list_item, parent, false);
        dataBinding.setBindListModel("Yes");
        return dataBinding.getRoot();
    }
}
