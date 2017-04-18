package me.halin.uiframework.mvp.weakness;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟另一个相关业务
 * Created by halin on 4/17/17.
 */
public class NicknameModel {

    public void getNickname(final Callback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ArrayList<String> nicknames = new ArrayList<>();

                nicknames.add("");
                nicknames.add("");
                nicknames.add("nickname");
                nicknames.add("");
                nicknames.add("");

                callback.nicknames(nicknames);
            }
        }, 5000);
    }

    public interface Callback {
        void nicknames(List<String> list);
    }
}
