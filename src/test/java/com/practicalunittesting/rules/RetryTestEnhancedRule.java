package com.practicalunittesting.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * This rule is used to provide rerun tests possibility
 * Created by otsukanov on 7/30/2015.
 */
public class RetryTestEnhancedRule implements TestRule {

    @Override
    public Statement apply(final Statement statement, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (AssertionError ae) {
                    RetryTest annotation = description.getAnnotation(RetryTest.class);
                    if(annotation != null){
                        rerun(annotation);
                    }
                }
            }

            private void rerun(RetryTest annotation) throws Throwable {
                boolean evaluated = false;
                for(int i = 0; i < annotation.retryNb() - 1 || evaluated; i++){
                    try {
                        statement.evaluate();
                        evaluated = true;
                    } catch (AssertionError assertionError){
                        if (i == annotation.retryNb() - 2){
                            throw assertionError;
                        }
                    }
                }
            }
        };
    }
}
