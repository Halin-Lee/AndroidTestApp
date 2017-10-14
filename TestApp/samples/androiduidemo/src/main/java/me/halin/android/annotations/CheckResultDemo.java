package me.halin.android.annotations;

import android.support.annotation.CheckResult;

/**
 * Created by halin on 3/16/17.
 */

public class CheckResultDemo {

    public void test() {
        //checkResult注解用于默写结果被忽略的方法，比如，String.trim() 的方法，使用者可能以为trim了后，原本的string就去调空格了，这时候就可以使用 CheckResult 提醒开发者
        this.checkResultMothod();
    }

    @CheckResult
    public int checkResultMothod() {
        return 1;
    }
}
