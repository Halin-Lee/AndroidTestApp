package halin.me.testapp.DataBinding.DemoList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import halin.me.testapp.R;
import halin.me.testapp.RecycleView.Base.RecycleViewBaseAdapter;

/**
 * Created by halin on 9/13/15.
 */
public class DataBindingDemoListActivity extends Activity{

    private RecyclerView mRecyclerView;
    private DataBindingDemoListAdapter mAdapter;
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
        mAdapter = new DataBindingDemoListAdapter();
        mRecyclerView.setAdapter(mAdapter);


        List<String> string = new ArrayList<>();
        string.add("a0");
        string.add("a1");
        string.add("a2");
        string.add("a3");
        string.add("a4");
        string.add("a5");
        string.add("a6");
        string.add("a7");
        string.add("a8");
        string.add("a9");
        string.add("aa");
        string.add("ab");
        string.add("ac");
        string.add("ad");
        string.add("ae");
        string.add("af");
        mAdapter.setDataList(string);


        //延迟,修改值,ui随之修改
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                List<String> string = new ArrayList<>();
                string.add("b0");
                string.add("b1");
                string.add("b2");
                string.add("b3");
                string.add("b4");
                string.add("b5");
                string.add("b6");
                string.add("b7");
                string.add("b8");
                string.add("b9");
                string.add("ba");
                string.add("bb");
                string.add("bc");
                string.add("bd");
                string.add("be");
                string.add("bf");
                mAdapter.setDataList(string);


            }
        }, 5000);


    }

}
