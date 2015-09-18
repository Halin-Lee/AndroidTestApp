package halin.me.testapp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.Arrays;
import java.util.List;

import halin.me.testapp.DataBinding.AdvancedBinding.DataBindingAdvancedBindingActivity;
import halin.me.testapp.DataBinding.Base.DataBindingBaseActivity;
import halin.me.testapp.DataBinding.Custom.DataBindingCustomActivity;
import halin.me.testapp.DataBinding.DataObjects.DataBindingObservableCollectionActivity;
import halin.me.testapp.DataBinding.DataObjects.DataBindingObservableFieldActivity;
import halin.me.testapp.DataBinding.DemoList.DataBindingDemoListActivity;
import halin.me.testapp.DataBinding.Event.DataBindingEventActivity;
import halin.me.testapp.DataBinding.Expression.DataBindingExpressionActivity;
import halin.me.testapp.DataBinding.GeneratedBinding.DataBindingGeneratedBindingActivity;
import halin.me.testapp.DataBinding.Import.DataBindingImportActivity;
import halin.me.testapp.DataBinding.Include.DataBindingIncludeActivity;
import halin.me.testapp.DataBinding.List.DataBindingListActivity;
import halin.me.testapp.DataBinding.DataObjects.DataBindingObservableObjectActivity;
import halin.me.testapp.DataBinding.Observable.DataBindingObservableActivity;
import halin.me.testapp.RecycleView.Base.RecycleViewBaseActivity;
import halin.me.testapp.base.BasePresenterListModel;
import halin.me.testapp.base.ListItemListener;
import halin.me.testapp.main.Model.TestBuilder;
import halin.me.testapp.main.view.MainPresenter;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MainDataHolder dataHolder = new MainDataHolder();

        dataHolder.setTestList(new TestBuilder().build());
        new MainPresenter(this,dataHolder).init();


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    //region adapter继承

    //endregion
}
