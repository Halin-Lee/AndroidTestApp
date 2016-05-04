package me.halin.testapp.main.view;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import me.halin.testapp.R;
import me.halin.testapp.EspressonTestDemo.base.BasePresenter;
import me.halin.testapp.main.MainDataHolder;


/**
 * 做数据绑定工作
 * <p/>
 * Created by halin on 8/15/15.
 */
public class MainPresenter extends BasePresenter {

    private MainDataHolder mDataHolder;
    private RecyclerView mRecyclerView;

    public MainPresenter(Activity context, MainDataHolder dataHolder) {
        super(context);
        mDataHolder = dataHolder;

    }

    @Override
    public void init() {
        super.init();
        mRecyclerView = (RecyclerView) getContext().findViewById(R.id.recycler_view);
        MainRecycleAdapter adapter = new MainRecycleAdapter(mDataHolder);
        mRecyclerView.setAdapter(adapter);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
    }

    @Override
    public int getActivityLayoutID() {
        return R.layout.activity_main;
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//        mListModel.getListItemListener().itemCallback( mListModel.getListItems().getABC(position),position)
    }
}
