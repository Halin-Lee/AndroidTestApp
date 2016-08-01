package me.halin.testapp.Mockito.MockitoInjectTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.when;

/**
 * Created by Halin on 6/5/16.
 */
public class MockitoInjectTest {
    @InjectMocks
    public MockitoInjectModel mockitoInjectModel;
    @Mock(name = "injectModelA")
    public MockitoInjectModel.InjectModelA injectModelA;
    @Mock
    public MockitoInjectModel.InjectModelB injectModelB;

    @Before
    public void setUp() throws Exception {
        //使用initMocks,将injectModel注入mockitoInjectModel,initMocks只会使用构造函数,setter,field注入的其中一种,如果包含两种注入,则注入失败,
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testMock() throws Exception {
        assertThat(mockitoInjectModel.getInjectModelB(), is(injectModelB));
        assertThat(mockitoInjectModel.getInjectModelA(), is(injectModelA));

        when(injectModelA.getString()).thenReturn("MockString");
        assertThat(mockitoInjectModel.getInjectModelA().getString(), is("MockString"));

    }


}
