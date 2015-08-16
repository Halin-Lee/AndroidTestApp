package halin.me.testapp.DataBinding.Base.view;

import android.app.Activity;

import halin.me.testapp.base.BasePresenter;

/**
 * Created by halin on 8/15/15.
 */
public class DataBindingBasePresenter extends BasePresenter {




    protected DataBindingBasePresenter(Activity context) {
        super(context);
    }

    @Override
    public int getActivityLayoutID() {
        return 0;
    }
}
