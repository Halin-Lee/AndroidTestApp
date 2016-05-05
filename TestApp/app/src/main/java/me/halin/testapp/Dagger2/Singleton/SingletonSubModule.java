package me.halin.testapp.Dagger2.Singleton;

import dagger.Module;
import dagger.Provides;
import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.Dagger2.Dagger2BaseActivity;

/**
 * Created by Halin on 5/5/16.
 */
@Module
public class SingletonSubModule {


    private Dagger2BaseActivity activity;

    SingletonSubModule(Dagger2BaseActivity activity) {
        this.activity = activity;
    }

    private int subStringCount = 0;

    @Provides
    String subString() {
        subStringCount++;
        activity.append("subString第%d次调用", subStringCount);
        return "subString调用次数" + subStringCount;
    }
}
