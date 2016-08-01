package me.halin.testapp.Mockito.MockitoInjectTest;

/**
 * Created by Halin on 6/5/16.
 */
public class MockitoInjectModel {

    private InjectModelA injectModelA;
    private final InjectModelB injectModelB;

    public MockitoInjectModel(InjectModelB injectModelB) {
        this.injectModelB = injectModelB;
    }


    public InjectModelA getInjectModelA() {
        return injectModelA;
    }

    public InjectModelB getInjectModelB() {
        return injectModelB;
    }

    static class InjectModelA {

        public String getString() {
            return InjectModelA.class.getName();
        }

    }

    static class InjectModelB {

        public String getString() {
            return InjectModelB.class.getName();
        }

    }
}
