package me.halin.uiframework.mvp.weakness.base;

import java.util.ArrayList;
import java.util.List;

import me.halin.uiframework.SampleModel;

/**
 * Created by halin on 4/6/17.
 */

public class Presenter {

    private ViewInterface view;

    public Presenter(ViewInterface view) {
        this.view = view;
    }

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
