package utils;

import org.junit.Assert;

public class Utils {

    public static void assertEquals(String expectedValue, String currentValue) {
        try {
            Assert.assertEquals(expectedValue, currentValue);
        } catch (Exception e) {
            assertFail("Expected [" + expectedValue + "], but returned [" + currentValue + "]");
        }
    }

    public static void assertTrue(String message, boolean value) {
        Assert.assertTrue(message, value);
    }

    public static void assertFalse(String message, boolean value) {
        Assert.assertFalse(message, value);
    }

    public static void assertFail(String message) {
        Assert.fail(message);
    }

    public static void wait(final int iTimeInMillis) {
        try {
            Thread.sleep(iTimeInMillis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
