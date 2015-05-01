package com.practicalunittesting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by otsukanov on 04.02.2015.
 */
@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {

    @Test
    @Parameters(method = "getTestStrings")
    public void testReverseString(String input, String output){
        assertEquals(output, StringUtil.reverse(input));
    }

    @SuppressWarnings("unused")
    private static Object[] getTestStrings() {
        return new Object[] {
                new Object[] {"abcde", "edcba"},
                new Object[] {"a", "a"},
                new Object[] {"", ""}
        };
    }

    @Test(expected = NullPointerException.class)
    public void testReverseNullString(){
        StringUtil.reverse(null);
    }
}
