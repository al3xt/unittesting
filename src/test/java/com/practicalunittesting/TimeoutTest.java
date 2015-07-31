package com.practicalunittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by otsukanov on 7/27/2015.
 */
public class TimeoutTest {

    @Rule
    public Timeout globalTimeout = new Timeout(20);

    @Test
    public void willFail() throws InterruptedException {
        Thread.sleep(100);
    }

    @Test
    public void willPass() throws InterruptedException {
        Thread.sleep(10);
    }
}
