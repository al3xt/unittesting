package com.practicalunittesting.listeners;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a listener, which collects tests execution summary and prints it
 * after all tests will be executed
 * Created by Alexey on 15.08.2015.
 */
@SuppressWarnings("unused")
public class TestsSummaryListener extends RunListener {

    private Map<String, TestSummary> testSummaries = new HashMap<>();

    @Override
    public void testFailure(Failure failure) throws Exception {
        TestSummary testSummary = testSummaries.get(failure.getDescription().getDisplayName());
        testSummary.setResult(TestSummary.TestResult.FAILURE);
    }

    @Override
    public void testStarted(Description description) throws Exception {
        TestSummary testSummary = new TestSummary();
        testSummary.setClazz(description.getTestClass().getSimpleName());
        testSummary.setName(description.getMethodName());
        testSummary.setStartTime(Calendar.getInstance().getTime().getTime());
        testSummaries.put(description.getDisplayName(), testSummary);
    }

    @Override
    public void testFinished(Description description) throws Exception {
        TestSummary testSummary = testSummaries.get(description.getDisplayName());
        if(testSummary.getResult() == null){
            testSummary.setResult(TestSummary.TestResult.OK);
        }
        testSummary.setFinishTime(Calendar.getInstance().getTime().getTime());
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Customized tests summary: ");
        for(TestSummary testSummary : testSummaries.values()){
            System.out.println(testSummary);
        }
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        TestSummary testSummary = new TestSummary();
        testSummary.setClazz(description.getDisplayName());
        testSummary.setName(description.getMethodName());
        testSummary.setStartTime(0);
        testSummary.setFinishTime(0);
        testSummary.setResult(TestSummary.TestResult.IGNORED);
        testSummaries.put(description.getDisplayName(), testSummary);
    }
}
