package me.halin.testapp.databinding.AdvancedBinding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.halin.testapp.R;

/**
 *
 * 使用setVariable方法使两个xml layout公用一个变量名,具体示例在Adapter中
 *
 * Created by halin on 9/13/15.
 */
public class DataBindingAdvancedBindingActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_advanced_binding);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new DataBindingAdvancedBindingRecycleViewAdapter(new String[]{"a", "b", "c"});
        mRecyclerView.setAdapter(mAdapter);
    }
}
