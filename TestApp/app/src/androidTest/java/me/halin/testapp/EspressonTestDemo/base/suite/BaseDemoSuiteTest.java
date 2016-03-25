package me.halin.testapp.EspressonTestDemo.base.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import static org.junit.Assert.assertTrue;


/**
 * 测试用例Demo
 * <p/>
 * Created by halin on 11/24/15.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({BaseDemoSuiteSingleTest.class})
public class BaseDemoSuiteTest {

    //测试用例相关资料
    //http://developer.android.com/tools/testing-support-library/index.html#AndroidJUnitRunner


   /* @Test
    public void exampleFailTest(){

       assertTrue(false);

    }*/

    @Test
    public void exampleSuccessTest() {

        assertTrue(true);

    }

}
