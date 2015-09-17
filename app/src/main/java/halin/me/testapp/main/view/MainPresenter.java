package halin.me.testapp.main.view;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import halin.me.testapp.R;
import halin.me.testapp.base.BasePresenter;
import halin.me.testapp.base.BasePresenterListModel;


/**
 *
 * 做数据绑定工作
 *
 * Created by halin on 8/15/15.
 */
public class MainPresenter extends BasePresenter implements AdapterView.OnItemClickListener {

    private BasePresenterListModel<String> mListModel;
    private ListView mListView;

    public MainPresenter(Activity context, BasePresenterListModel<String> listModel) {
        super(context);
        mListModel = listModel;

    }

    @Override
    public void init() {
        super.init();
        mListView = (ListView) getContext().findViewById(R.id.main_list);
        MainAdapter adapter = new MainAdapter(mListModel.getListItems(),getLayoutInflater());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);

    }

    @Override
    public int getActivityLayoutID() {
        return R.layout.activity_main;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mListModel.getListItemListener().itemCallback( mListModel.getListItems().get(position),position);
    }
}
