package com.practicalunittesting.legacy;

import java.util.Date;

/**
 * Created by Alexey on 09.08.2015.
 */
public class PIM {

    private final static int MILLIS_IN_MINUTE = 60 * 1000;

    private Calendar calendar;

    public PIM(Calendar calendar) {
        this.calendar = calendar;
    }

    public void addMeeting(Date startDate, int durationInMinutes) {
        Date endDate = new Date(startDate.getTime()
                + MILLIS_IN_MINUTE * durationInMinutes);
        Meeting meeting = new Meeting(startDate, endDate);
        calendar.addEvent(meeting);
    }
}
