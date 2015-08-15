package com.practicalunittesting.listeners;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a listener rule, which shows test execution time
 * Created by otsukanov on 8/12/2015.
 */
public class TimeTestListener extends TestWatcher {

    private Map<String, Long> startTimes = new HashMap<>();

    @Override
    protected void starting(Description description) {
        startTimes.put(description.getMethodName(),
                System.currentTimeMillis());
    }

    @Override
    protected void finished(Description description) {
        long executionTime = System.currentTimeMillis()
                - startTimes.get(description.getMethodName());
        System.out.println(description.getMethodName()
                + ": " + executionTime);
    }
}
