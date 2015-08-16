package halin.me.testapp.DataBinding.Import;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import halin.me.testapp.DataBinding.Import.Model.DataBindingImportMethod;
import halin.me.testapp.DataBinding.Import.Model.DataBindingImportModel;
import halin.me.testapp.DataBinding.Import.Model.DataBindingImportSubModel;
import halin.me.testapp.R;
import halin.me.testapp.databinding.ActivityDataBindingImportBinding;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingImportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingImportBinding bindingEventBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_import);


        //构造List模型
        List<DataBindingImportModel> list = new ArrayList<>();
        DataBindingImportModel model = new DataBindingImportModel();
        model.string = "1";
        list.add(model);

        model = new DataBindingImportModel();
        model.string = "2";
        list.add(model);
        bindingEventBinding.setModelList(list);

        DataBindingImportSubModel subModel = new DataBindingImportSubModel();
        subModel.string = "3";
        subModel.subString = "3 类型强转";
        list.add(subModel);

        bindingEventBinding.setModelList(list);


        //构造method模型,供调用
        DataBindingImportMethod method = new DataBindingImportMethod();
        bindingEventBinding.setMethodModel(method);

    }
}
