package yqtrack.app.androiduidemo.main;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import yqtrack.app.androiduidemo.R;
import yqtrack.app.androiduidemo.main.model.TestBuilder;
import yqtrack.app.androiduidemo.main.model.TestItem;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements MainViewModel.ItemClickListener {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ObservableList<TestItem> items = new ObservableArrayList<>();

        final MainViewModel viewModel = new MainViewModel();
        viewModel.itemClickListener.set(this);

        viewModel.testList.addAll(new TestBuilder().build());
        mRecyclerView.setAdapter(new MainRecycleAdapter(viewModel));
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));


    }



    @Override
    public void onItemClick(TestItem item) {
        Intent intent = new Intent(this, item.activityClass);
        startActivity(intent);
    }
}
