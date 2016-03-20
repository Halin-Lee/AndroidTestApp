package me.halin.testapp.ModelConverter;

import android.databinding.ObservableField;

/**
 * Created by halin on 12/24/15.
 */
@ModelConvertClass({ModelConverterAnnotationA.class, ModelConverterAnnotationB.class})
public class DataBindingConvertModel {

    public String getField2() {
        return field2.get();
    }

    @ModelConverterAnnotationB(ModelConverterAnnotationB.ModelConverterDeclareB.FIELD2)
    public final ObservableField<String> field2 = new ObservableField<>();

    //    @ModelConverterAnnotationB(ModelConverterAnnotationB.ModelConverterDeclareB.FIELD2)
//    public final ObservableArrayList<Object> collection = new ObservableArrayList<>();

//    @ModelConverterAnnotationB(ModelConverterAnnotationB.ModelConverterDeclareB.FIELD2)
//    public final ObservableInt thirdField = new ObservableInt();
}
