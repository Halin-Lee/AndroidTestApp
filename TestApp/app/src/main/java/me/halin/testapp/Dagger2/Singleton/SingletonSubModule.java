package me.halin.testapp.Dagger2.Singleton;

import dagger.Module;
import dagger.Provides;
import me.halin.testapp.main.LogStringBaseActivity;

/**
 * Created by Halin on 5/5/16.
 */
@Module
public class SingletonSubModule {


    private LogStringBaseActivity activity;

    SingletonSubModule(LogStringBaseActivity activity) {
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
