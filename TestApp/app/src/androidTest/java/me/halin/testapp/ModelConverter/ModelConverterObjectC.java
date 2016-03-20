package me.halin.testapp.ModelConverter;

/**
 * Created by halin on 12/21/15.
 */
@ModelConvertClass({ModelConverterAnnotationA.class})
public class ModelConverterObjectC {


    @ModelConverterAnnotationA(ModelConverterAnnotationA.ModelConverterDeclareA.FIELD1)
    private String field1;

    @ModelConverterAnnotationA(ModelConverterAnnotationA.ModelConverterDeclareA.FIELD2)
    private String field2;


    @ModelConverterAnnotationB(ModelConverterAnnotationB.ModelConverterDeclareB.FIELD1)
    private String field3;

    @ModelConverterAnnotationB(ModelConverterAnnotationB.ModelConverterDeclareB.FIELD2)
    private String field4;


    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField4() {
        return field4;
    }
}
