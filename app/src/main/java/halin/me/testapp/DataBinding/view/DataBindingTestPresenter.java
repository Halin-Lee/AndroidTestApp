package halin.me.testapp.DataBinding.view;

import android.app.Activity;

import halin.me.testapp.base.BasePresenter;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingTestPresenter extends BasePresenter {




    protected DataBindingTestPresenter(Activity context) {
        super(context);
    }

    @Override
    public int getActivityLayoutID() {
        return 0;
    }
}
