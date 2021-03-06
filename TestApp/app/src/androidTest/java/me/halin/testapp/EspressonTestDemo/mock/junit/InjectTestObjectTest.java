package me.halin.testapp.EspressonTestDemo.mock.junit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by halin on 12/7/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class InjectTestObjectTest {

    /**
     * mock掉的返回值
     */
    public static final String MOCK_STRING = "Mock Return";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    public InjectTestObject injectTestObject;

    @Mock
    public JUnitMockObject mockObject;


    @Before
    public void setUp() throws Exception {
//        mockObject = Mockito.mock(JUnitMockObject.class);
//        when(mockObject.getABC()).thenReturn(MOCK_STRING);
    }

    @Test
    public void testTest() throws Exception {
        String str = injectTestObject.test();
        assertThat(str, is("ABC"));
    }
}