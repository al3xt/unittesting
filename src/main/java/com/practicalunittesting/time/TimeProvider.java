package com.practicalunittesting.time;

import java.util.Calendar;

/**
 * Allows for taking control over time in unit tests.
 * Created by otsukanov on 5/20/2015.
 */
public interface TimeProvider {

    Calendar getTime();
}
