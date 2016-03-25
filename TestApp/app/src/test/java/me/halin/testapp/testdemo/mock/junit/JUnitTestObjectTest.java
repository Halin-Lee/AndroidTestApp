package me.halin.testapp.EspressonTestDemo.mock.junit;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by halin on 12/4/15.
 */
@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class JUnitTestObjectTest {

    /**
     * mock掉的返回值
     */
    public static final String MOCK_STRING = "Mock Return";

    @Mock
    private JUnitMockObject mockObject;


    @Before
    public void setUp() throws Exception {
        mockObject = Mockito.mock(JUnitMockObject.class);
        when(mockObject.getABC()).thenReturn(MOCK_STRING);
    }


    @Test
    public void testGetString() throws Exception {
        JUnitTestObject testObject = new JUnitTestObject(mockObject);
        String str = testObject.getMockObjectABC();
        //因为返回被mock掉了...所以得到的文本不再是ABC
        assertThat(str, is("ABC"));
    }


}