package me.halin.testapp.databinding.Expression;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.halin.testapp.R;
import me.halin.testapp.databinding.ActivityDataBindingExpressionBinding;

/**
 * Created by halin on 8/16/15.
 */
public class DataBindingExpressionActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //通过DataBinding设置ContentView,并得到绑定模型
        ActivityDataBindingExpressionBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_expression);

        //插入测试数据

        //表达式判断数据
        dataBinding.setString("String");
        dataBinding.setString2("String 2");


        //Collection类测试,如果collection对象为空,获取将导致程序崩溃
        //数组数据
        List<String> list  = new ArrayList<>();
        list.add("First Object");
        list.add("Second Object");
        list.add("Third Object");
        //如果不设置list,让list为空,view获取将崩溃
        dataBinding.setList(list);

        //sparse数组
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.append(4,"4th Object");
        sparseArray.append(5,"5th Object");
        sparseArray.append(6, "6th Object");
        //设置读取index
        dataBinding.setIndex(4);
        dataBinding.setSparse(sparseArray);

        Map<Object,String> map = new HashMap<>();
        //设置读取key
        Object keyObject = new Object();
        dataBinding.setKeyObject(keyObject);
        map.put(keyObject,"Value For Key Object");
        dataBinding.setMap(map);






    }
}
