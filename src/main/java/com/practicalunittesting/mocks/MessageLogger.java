package com.practicalunittesting.mocks;

import java.util.Date;

/**
 * The logger for messages
 * Created by Alexey on 07.05.2015.
 */
public interface MessageLogger {

    /**
     * Logs specified message
     * @param message message text
     * @param date message date
     */
    public void log(String message, Date date);
}
