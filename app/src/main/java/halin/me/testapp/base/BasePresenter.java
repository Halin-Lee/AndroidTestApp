package halin.me.testapp.base;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

/**
 *
 * ui绑定工具
 *
 * Created by halin on 8/15/15.
 */
public abstract class BasePresenter {

    private LayoutInflater mLayoutInflater;
    private Activity mContext;

    protected BasePresenter(Activity context) {
        this.mContext = context;
        this.mLayoutInflater = context.getLayoutInflater();
    }


    public void init(){
        mContext.setContentView(getActivityLayoutID());
    }

    public abstract int getActivityLayoutID();

    protected LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }


    public Activity getContext() {
        return mContext;
    }
}
