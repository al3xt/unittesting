package com.practicalunittesting.legacy;

import java.util.Date;

/**
 * Created by Alexey on 09.08.2015.
 */
public class Meeting implements Event {

    private final Date startDate;
    private final Date endDate;

    public Meeting(Date startDate, Date endDate) {
        this.startDate = new Date(startDate.getTime());
        this.endDate = new Date(endDate.getTime());
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}