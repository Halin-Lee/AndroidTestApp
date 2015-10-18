package halin.me.testapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import halin.me.testapp.main.Model.TestBuilder;
import halin.me.testapp.main.Model.TestItem;
import halin.me.testapp.main.view.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainDataHolder.ItemClickListener {


    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final MainDataHolder dataHolder = new MainDataHolder();
        dataHolder.itemClickListener.set(this);

        dataHolder.testList.addAll(new TestBuilder().build());
        new MainPresenter(this,dataHolder).init();


        //用于测试dataHolder数据改变对view的影响
/*        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<TestItem> list = dataHolder.testList;
                list.remove(list.size()-1);
                Log.e(TAG,"Change");
            }
        },2000);*/

    }

    @Override
    public void onItemClick(TestItem item) {
        Intent intent = new Intent(this,item.activityClass);
        startActivity(intent);
    }

}
