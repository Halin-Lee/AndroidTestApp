package halin.me.fundamental.LogTools;

/**
 * Created by halin on 10/14/15.
 */
public enum LoggerType {

    //使用LogUtilGetter是一种妥协的做法,
    //避免LoggerType在构造的时候将所有的LogUtil初始化,

    /**
     * 谷歌分析日志
     */
    LoggerTypeGoogle(
            new LogUtilGetter() {
                @Override
                public LogUtil getLogUtil() {
                    return new LogUtilGoogle();
                }
            }
    ),

    /**
     * 云测分析
     */
    LoggerTypeTestIn(new LogUtilGetter() {
        @Override
        public LogUtil getLogUtil() {
            return new LogUtilTestIn();
        }
    }
    );


    private LogUtilGetter logUtilGetter;

    LoggerType(LogUtilGetter logUtilGetter) {
        this.logUtilGetter = logUtilGetter;
    }

    public LogUtil getLogUtil() {
        return logUtilGetter.getLogUtil();
    }


    interface LogUtilGetter {
        LogUtil getLogUtil();
    }


}
