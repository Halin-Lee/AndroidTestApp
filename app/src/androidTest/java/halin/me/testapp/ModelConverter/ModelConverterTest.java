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
        ModelConverter<ModelConverterObjectA, ModelConverterObjectB> converter = new ModelConverter<>(ModelConverterObjectA.class, ModelConverterObjectB.class);

        ModelConverterObjectA a = new ModelConverterObjectA();
        ModelConverterObjectB b;
        ModelConverterObjectC c;
        a.setField1("a");
        a.setField2("b");
        a.setField3("c");
        a.setField4("d");

        b = new ModelConverterObjectB();
        b = converter.convert(a, b);
        assertThat(b.getField1(), is(a.getField1()));
        assertThat(b.getField2(), is(a.getField2()));
        assertThat(b.getField3(), is(a.getField3()));
        assertThat(b.getField4(), is(a.getField4()));


        b = converter.convert(a);
        assertThat(b.getField1(), is(a.getField1()));
        assertThat(b.getField2(), is(a.getField2()));
        assertThat(b.getField3(), is(a.getField3()));
        assertThat(b.getField4(), is(a.getField4()));

        c = new ModelConverterObjectC();
        c = converter.convert(a, c);
        assertThat(b.getField1(), is(a.getField1()));
        assertThat(b.getField2(), is(a.getField2()));
        assertThat(b.getField3(), is(a.getField3()));
        assertThat(b.getField4(), is(a.getField4()));


        b = converter.convert(a);
        assertThat(b.getField1(), is(a.getField1()));
        assertThat(b.getField2(), is(a.getField2()));
        assertThat(b.getField3(), is(a.getField3()));
        assertThat(b.getField4(), is(a.getField4()));
    }


}