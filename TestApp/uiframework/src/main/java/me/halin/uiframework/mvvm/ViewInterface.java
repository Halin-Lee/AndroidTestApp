package me.halin.uiframework.mvvm;

import java.util.List;

/**
 * View接口，通过定义接口，可以方便mock实现
 * Created by halin on 4/6/17.
 */

public interface ViewInterface {
    void onResult(List<String> list);

    void onNicknameResult(List<String> list);
}
