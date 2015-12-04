package halin.me.testapp.testdemo.base;

import java.util.List;

/**
 *
 * List绑定模型
 *
 * Created by halin on 8/15/15.
 */
public class BasePresenterListModel<T> {

    private ListItemListener<T> mListItemListener;
    private List<T>  mListItems;


    public BasePresenterListModel(List<T> mListItems ,ListItemListener<T> mListItemListener) {
        this.mListItemListener = mListItemListener;
        this.mListItems = mListItems;
    }

    public ListItemListener<T> getListItemListener() {
        return mListItemListener;
    }

    public List<T> getListItems() {
        return mListItems;
    }
}
