package me.halin.testapp.Dagger2.AutoGenerate;

import dagger.Module;
import dagger.Provides;
import me.halin.fundamental.LogUtil.Logger;

/**
 * Created by Halin on 5/5/16.
 */
@Module
public class AutoGenerateModule {

    AutoGenerateModule() {
        Logger.debug("AutoGenerateModule默认构造函数调用");
    }

    @Provides
    long currentTime() {
        return System.currentTimeMillis();
    }
}
