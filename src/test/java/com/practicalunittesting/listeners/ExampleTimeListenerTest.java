package com.practicalunittesting.listeners;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by otsukanov on 8/12/2015.
 */
public class ExampleTimeListenerTest {

    @Rule
    public TimeTestListener timeListener = new TimeTestListener();

    @Test
    public void tenMillis() throws InterruptedException {
        Thread.sleep(10);
    }

    @Test
    public void twentyMillis() throws InterruptedException {
        Thread.sleep(20);
    }
}
