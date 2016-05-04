package me.halin.testapp.XStream;

import android.content.Context;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.IOException;
import java.io.InputStream;

import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by Halin on 3/26/16.
 */

@XStreamAlias("Demo")
public class XStreamDemo {

    private static final String TAG = XStreamDemo.class.getName();

    @XStreamAsAttribute
    @XStreamAlias("attribute")
    private String string;


    @XStreamAlias("item")
    private String item;

    private String nonuse;

    public static void test(Context context) {
        XStream xStream = new XStream();

        xStream.setMode(XStream.NO_REFERENCES);
        xStream.processAnnotations(new Class[]{XStreamDemo.class});

        try {
            InputStream inputStream = context.getAssets().open("XStreamDemo.xml");
            XStreamDemo demo = (XStreamDemo) xStream.fromXML(inputStream);
            Logger.log(TAG, "解析完成,string:%s,item:%s,non-use:%s", demo.string, demo.item, demo.nonuse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
