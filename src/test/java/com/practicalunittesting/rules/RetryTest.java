package com.practicalunittesting.rules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark test method for re-run with RetryTestEnhancedRule
 * Created by otsukanov on 7/30/2015.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface RetryTest {

    /**
     * Get number of test re-run
     * @return number of test re-run
     */
    int retryNb();
}
