package me.halin.uiframework.mvp;

import java.util.ArrayList;
import java.util.List;

import me.halin.uiframework.SampleModel;

/**
 * 业务事件封装
 * Created by halin on 4/6/17.
 */

public class Presenter {

    private ViewInterface view;

    public Presenter(ViewInterface view) {
        this.view = view;
    }

    //接受页面业务事件
    public void start(String text) {
        List<String> list = new ArrayList();
        list.add(text);
        new SampleModel().start(list, new SampleModel.Callback() {
            @Override
            public void callback(List<String> list) {
                view.onResult(list);
            }
        });
    }
}
