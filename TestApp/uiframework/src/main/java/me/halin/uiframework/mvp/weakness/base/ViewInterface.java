package me.halin.uiframework.mvp.weakness.base;

import java.util.List;

/**
 * View接口，通过定义接口，可以方便mock实现
 * Created by halin on 4/6/17.
 */

public interface ViewInterface {
    public void onResult(List<String> list);
}
