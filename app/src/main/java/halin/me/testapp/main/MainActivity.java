package halin.me.testapp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.Arrays;
import java.util.List;

import halin.me.testapp.DataBinding.Base.DataBindingBaseActivity;
import halin.me.testapp.DataBinding.Custom.DataBindingCustomActivity;
import halin.me.testapp.DataBinding.Event.DataBindingEventActivity;
import halin.me.testapp.DataBinding.Expression.DataBindingExpressionActivity;
import halin.me.testapp.DataBinding.Import.DataBindingImportActivity;
import halin.me.testapp.DataBinding.Include.DataBindingIncludeActivity;
import halin.me.testapp.DataBinding.List.DataBindingListActivity;
import halin.me.testapp.base.BasePresenterListModel;
import halin.me.testapp.base.ListItemListener;
import halin.me.testapp.main.view.MainPresenter;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static String[] NAME_ARRAY = new String[]{
            "DataBinder测试",
            "DataBinderList测试",
            "DataBinder事件绑定测试",
            "DataBinder导入测试",
            "自定义DataBinder",
            "Include测试",
            "Expression测试"};



    private static Class[] CLASS_ARRAY = new Class[]{
            DataBindingBaseActivity.class,
            DataBindingListActivity.class,
            DataBindingEventActivity.class,
            DataBindingImportActivity.class,
            DataBindingCustomActivity.class,
            DataBindingIncludeActivity.class,
            DataBindingExpressionActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> nameList = Arrays.asList(NAME_ARRAY);
        BasePresenterListModel<String> listModel = new BasePresenterListModel<>(nameList, new ListItemListener<String>() {
            @Override
            public void itemCallback(String s, int position) {
                Intent intent = new Intent(MainActivity.this, CLASS_ARRAY[position]);
                MainActivity.this.startActivity(intent);
            }
        });

        new MainPresenter(this, listModel).init();


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    //region adapter继承

    //endregion
}
