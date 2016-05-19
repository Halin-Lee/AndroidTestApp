package me.halin.testapp.main;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.UserCenter.SignInRequest;
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
        SignInRequest.test();

        final MainDataHolder dataHolder = new MainDataHolder();
        dataHolder.itemClickListener.set(this);

        dataHolder.testList.addAll(new TestBuilder().build());
        new MainPresenter(this, dataHolder).init();


        //用于测试dataHolder数据改变对view的影响
/*        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<TestItem> list = dataHolder.testList;
                list.remove(list.size()-1);
                Log.e(TAG,"Change");
            }
        },2000);*/

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    @Override
    public void onItemClick(TestItem item) {
        Intent intent = new Intent(this, item.activityClass);
        startActivity(intent);
    }


}
