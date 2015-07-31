package com.practicalunittesting.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.lang.annotation.Annotation;

/**
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

                }
            }
        };
    }
}
