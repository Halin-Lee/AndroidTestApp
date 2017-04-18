package me.halin.uiframework;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by halin on 4/6/17.
 */

public class SampleModel {

    public void start(final List<String> lists, final Callback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ArrayList<String> outputList = new ArrayList<>();
                for (String string : lists) {
                    outputList.add(string + " finished");
                    outputList.add(string + " finished");
                    outputList.add(string + " finished");
                    outputList.add(string + " finished");
                    outputList.add(string + " finished");
                }

                callback.callback(outputList);
            }
        }, 5000);
    }


    public interface Callback {
         void callback(List<String> list);
    }
}
