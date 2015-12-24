package halin.me.testapp.testdemo.mock.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by halin on 12/7/15.
 */
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
        assertThat(str, is(MOCK_STRING));
    }

}