package me.halin.daggerstudy.Dagger2.Singleton;

import dagger.Module;
import dagger.Provides;
import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by Halin on 5/5/16.
 */
@Module
public class SingletonSubModule {
    private int subStringCount = 0;

    @Provides
    String subString() {
        subStringCount++;
        Logger.debug("subString第%d次调用", subStringCount);
        return "subString调用次数" + subStringCount;
    }
}
