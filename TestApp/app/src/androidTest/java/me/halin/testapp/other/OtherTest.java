package me.halin.testapp.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by halin on 12/3/15.
 */
public class OtherTest {

    @Test
    public void keepDigitsTest() {

        int testCount = 100;
        for (int i = 0; i < testCount; i++) {
            int input = (int) (100 * Math.random());
            int digits = (int) (10 * Math.random()) + 5;
            String output = convertIntToStringWithLeadingZero(input, digits);
            assertEquals(output.length(), digits);
        }
    }

    private static String convertIntToStringWithLeadingZero(int number, int digits) {
        String formatString = "%0" + digits + "d";
        return String.format(formatString, number);
    }


}
