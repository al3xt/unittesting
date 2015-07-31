package com.practicalunittesting.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.Properties;

/**
 * Created by otsukanov on 7/30/2015.
 */
public class RestoreSysPropertiesRule implements TestRule {

    @Override
    public Statement apply(final Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Properties properties = null;
                try {
                    properties = (Properties) System.getProperties().clone();
                    statement.evaluate();
                } finally {
                    System.setProperties(properties);
                }
            }
        };
    }
}
