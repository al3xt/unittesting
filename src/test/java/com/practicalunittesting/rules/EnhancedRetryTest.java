package com.practicalunittesting.rules;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by otsukanov on 7/30/2015.
 */
public class EnhancedRetryTest {

    @Rule
    public RetryTestEnhancedRule retryTestRule = new RetryTestEnhancedRule();

    static int firstTestCounter = 0;
    static int secondTestCounter = 0;
    static int thirdTestCounter = 0;

    @Test
    @RetryTest(retryNb = 2)
    public void shouldFailOnSecondAttempt() {
        firstTestCounter++;
        Assert.fail("failing " + firstTestCounter);
    }
    @Test
    @RetryTest(retryNb = 3)
    public void shouldFailOnThirdAttempt() {
        secondTestCounter++;
        Assert.fail("failing " + secondTestCounter);
    }
    @Test
    public void shouldNotBeRerun() {
        thirdTestCounter++;
        Assert.fail("failing " + thirdTestCounter);
    }
}
