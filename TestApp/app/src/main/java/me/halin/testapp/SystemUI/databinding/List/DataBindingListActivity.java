package me.halin.testapp.SystemUI.databinding.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import me.halin.testapp.SystemUI.databinding.List.View.DataBindingListAdapter;
import me.halin.testapp.R;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingListActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_data_binding_list);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new DataBindingListAdapter(getLayoutInflater()));

    }
}
