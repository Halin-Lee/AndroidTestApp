package me.halin.uiframework.mvp.weakness;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by halin on 4/17/17.
 */

public class ListViewAdapter extends BaseAdapter {

    private List<String> items;

    public List<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<String> nicknames) {

        //接收模型，UI显示操作
        this.nicknames = nicknames;
        this.notifyDataSetChanged();
    }

    private List<String> nicknames;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {

        //接收模型，UI显示操作
        this.items = items;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = (TextView) convertView;
        if (textView == null) {
            textView = new TextView(parent.getContext());
        }

        String nickname = nicknames == null ? "" : nicknames.get(position);
        textView.setText(items.get(position) + nickname);

        return textView;
    }
}
