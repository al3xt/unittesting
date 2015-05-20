package com.practicalunittesting.time;

import java.util.Calendar;

/**
 * Created by otsukanov on 5/20/2015.
 */
public class HelloRedesigned {

    private TimeProvider timeProvider;

    public HelloRedesigned(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String sayHello() {
        Calendar current = timeProvider.getTime();
        if (current.get(Calendar.HOUR_OF_DAY) < 12) {
            return "Good Morning!";
        } else {
            return "Good Afternoon!";
        }
    }
}
