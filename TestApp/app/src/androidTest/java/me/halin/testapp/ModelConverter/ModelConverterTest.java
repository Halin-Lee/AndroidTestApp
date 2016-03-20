package halin.me.testapp.ModelConverter;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by halin on 12/21/15.
 */
public class ModelConverterTest {

    @Test
    public void testConvert() throws Exception {
        ModelConverter<ModelConverterObjectA, ModelConverterObjectB> converterAB = new ModelConverter<>(ModelConverterObjectA.class, ModelConverterObjectB.class);

        ModelConverterObjectA a = new ModelConverterObjectA();
        ModelConverterObjectB b;
        ModelConverterObjectC c;
        DataBindingConvertModel d;

        a.setField1("a");
        a.setField2("b");
        a.setField3("c");
        a.setField4("d");

        b = new ModelConverterObjectB();
        b = converterAB.convert(a, b);
        assertThat(b.getField1(), is(a.getField1()));
        assertThat(b.getField2(), is(a.getField2()));
        assertThat(b.getField3(), is(a.getField3()));
        assertThat(b.getField4(), is(a.getField4()));

        b = converterAB.convert(a);
        assertThat(b.getField1(), is(a.getField1()));
        assertThat(b.getField2(), is(a.getField2()));
        assertThat(b.getField3(), is(a.getField3()));
        assertThat(b.getField4(), is(a.getField4()));

        ModelConverter<ModelConverterObjectA, ModelConverterObjectC> converterAC = new ModelConverter<>(ModelConverterObjectA.class, ModelConverterObjectC.class);
        c = new ModelConverterObjectC();
        c = converterAC.convert(a, c);
        assertThat(c.getField1(), is(a.getField1()));
        assertThat(c.getField2(), is(a.getField2()));
        assertThat(c.getField3(), is(a.getField3()));
        assertThat(c.getField4(), is(a.getField4()));


        ModelConverter<ModelConverterObjectA, DataBindingConvertModel> converterAD = new ModelConverter<>(ModelConverterObjectA.class, DataBindingConvertModel.class);
        d = new DataBindingConvertModel();
        d = converterAD.convert(a, d);
        assertThat(d.getField2(), is(a.getField2()));


    }


}