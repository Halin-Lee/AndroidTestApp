package halin.me.fundamental.LogTools;

import android.app.Application;

import com.testin.agent.TestinAgent;


/**
 * 云测测试工具
 * <p/>
 * Created by halin on 10/14/15.
 */
public class LogUtilTestIn extends LogUtil {

    private static final String TestInKey = "a67471dacdc567298f9d526628979629";
    private Application application;

    @Override
    void setup(Application application) {
        this.application = application;
        TestinAgent.init(application, TestInKey);
        TestinAgent.setLocalDebug(true);
    }

    @Override
    void log(String message) {
        TestinAgent.leaveBreadcrumb(message);

    }

    @Override
    void logE(String message) {
        TestinAgent.uploadException(application, message, new Exception(message));
    }
}
