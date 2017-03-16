package me.halin.android.annotations;

import android.support.annotation.IntDef;

public class IntDefDemo {

    public static final int RET_SUCCEED = 0x01;
    public static final int RET_ERROR = 0x02;

    private int ret;
    private int flagRet;

    public void test() {

        //设置一个非定义的量，会有代码提示
        this.setRet(1);
        this.setRet(RET_ERROR | RET_SUCCEED);
        //设置 flag 为 true 后，允许或，且 等操作
        this.setFlagRet(RET_ERROR | RET_SUCCEED);
    }


    /**
     * 声明一个类型，制定这个类型包含的数值
     */
    @IntDef({RET_SUCCEED, RET_ERROR})
    public @interface Ret {
    }

    /**
     * 声明一个类型，制定这个类型包含的数值
     */
    @IntDef(flag = true, value = {RET_SUCCEED, RET_ERROR})
    public @interface FlagableRet {
    }

    /**
     * 声明这个方法返回的类型
     */
    @Ret
    public int getRet() {
        return ret;
    }


    /**
     * 声明这个参数接受的类型
     */
    public void setRet(@Ret int ret) {
        this.ret = ret;
    }

    @FlagableRet
    public int getFlagRet() {
        return flagRet;
    }


    public void setFlagRet(@FlagableRet int flagRet) {
        this.flagRet = flagRet;
    }

}
