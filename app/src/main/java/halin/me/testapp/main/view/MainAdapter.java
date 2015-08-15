package halin.me.testapp.main.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import halin.me.testapp.R;

/**
 * Created by halin on 8/15/15.
 */
public class MainAdapter extends BaseAdapter {



    private List<String> mNameList;
    private LayoutInflater mInflater;

    public MainAdapter(List<String>  mNameArray, LayoutInflater mInflater) {
        this.mNameList = mNameArray;
        this.mInflater = mInflater;
    }


    //region adapter实现
    @Override
    public int getCount() {
        return mNameList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNameList.get(position);
}

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = mInflater.inflate(R.layout.main_item,null);
            MainItemHolder holder = new MainItemHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }
        ((MainItemHolder)convertView.getTag() ).textView.setText(mNameList.get(position));
        return convertView;
    }

    //endregion

    //region getter

    public List<String> getmNameList() {
        return mNameList;
    }

    //endregion


    private class MainItemHolder{
        public TextView textView;
    }

}
