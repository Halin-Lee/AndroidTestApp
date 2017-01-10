package me.halin.testapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.halin.testapp.main.Model.TestBuilder;
import me.halin.testapp.main.Model.TestItem;
import me.halin.testapp.main.view.MainPresenter;


/**
 * 主启动Activity
 */
public class MainActivity extends AppCompatActivity implements MainDataHolder.ItemClickListener {


    public static final String TAG = MainActivity.class.getSimpleName();


    static {
        Log.e(TAG, "初始化");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MainDataHolder dataHolder = new MainDataHolder();
        dataHolder.itemClickListener.set(this);

        dataHolder.testList.addAll(new TestBuilder().build());
        new MainPresenter(this, dataHolder).init();


    }

    @Override
    public void onItemClick(TestItem item) {
        Intent intent = new Intent(this, item.activityClass);
        startActivity(intent);
    }


}
