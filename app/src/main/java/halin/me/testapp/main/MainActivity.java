package halin.me.testapp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import halin.me.testapp.DataBinding.DataBindingTestActivity;
import halin.me.testapp.DataBindingEvent.DataBindingEventActivity;
import halin.me.testapp.DataBindingList.DataBindingListActivity;
import halin.me.testapp.R;
import halin.me.testapp.base.BasePresenterListModel;
import halin.me.testapp.base.ListItemListener;
import halin.me.testapp.main.view.MainAdapter;
import halin.me.testapp.main.view.MainPresenter;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static String[] NAME_ARRAY = new String[]{"DataBinder测试","DataBinderList测试","DataBinder事件绑定测试"};
    private static Class[] CLASS_ARRAY = new Class[]{DataBindingTestActivity.class,DataBindingListActivity.class,DataBindingEventActivity.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> nameList =         Arrays.asList(NAME_ARRAY);
        BasePresenterListModel<String> listModel =  new BasePresenterListModel<>(nameList, new ListItemListener<String>() {
            @Override
            public void itemCallback(String s, int position) {
                Intent intent = new Intent(MainActivity.this,CLASS_ARRAY[position]);
                MainActivity.this.startActivity(intent);
            }
        });

        new MainPresenter(this,listModel).init();


    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    //region adapter继承

    //endregion
}
