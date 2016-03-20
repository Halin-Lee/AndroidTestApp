package me.halin.testapp.databinding.DataObjects;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableList;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.os.Handler;

import me.halin.testapp.ObservableCollectionBinding;
import me.halin.testapp.R;

/**
 * Created by halin on 9/12/15.
 */
public class DataBindingObservableCollectionActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //通过DataBinding设置ContentView,并得到绑定模型
        final ObservableCollectionBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_observable_collection);

        final ObservableList<String> list = new ObservableArrayList<String>();
        dataBinding.setObservableList(list);
        dataBinding.setIndex(2);

        //直接对binding的某个field的子field赋值,view能收到更新,
        list.add("abc");
        list.add("def");
        list.add("ghi");

        //延迟,修改值,ui随之修改
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.clear();
                list.add("ghi");
                list.add("def");
                list.add("abc");

                //TODO:关于DataBinding下ListView的猜想:
                //  如果把要显示的List,以及List的index 给子View,子View是否可以自行显示需要显示的内容?
                dataBinding.setIndex(1);
            }
        }, 5000);


        final ObservableMap<String,Object> map = new ObservableArrayMap<>();
        dataBinding.setObservableMap(map);
        dataBinding.setKey("objectB");

        map.put("objectA", new Object() {
            @Override
            public String toString() {
                return "ObjectA";
            }
        });
        map.put("objectB",new Object(){
            @Override
            public String toString() {
                return "ObjectB";
            }
        });


        //延迟,修改值,ui随之修改
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                map.put("objectA",new Object(){
                    @Override
                    public String toString() {
                        return "ObjectC";
                    }
                });

                map.put("objectB",new Object(){
                    @Override
                    public String toString() {
                        return "ObjectD";
                    }
                });

                dataBinding.setKey("objectA");

            }
        }, 5000);



    }
}
