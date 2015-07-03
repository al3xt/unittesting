package com.practicalunittesting.time;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for HelpDesk
 * Created by otsukanov on 7/3/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class HelpDeskTest {

    private HelpDesk helpDesk;

    private TimeProvider timeProvider;

    private Issue issue;

    @Before
    public void setUp() {
        timeProvider = mock(TimeProvider.class);
        helpDesk = new HelpDesk(timeProvider);
        issue = mock(Issue.class);
    }

    private Calendar getCalendar(int hour, int dayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        return calendar;
    }

    private static int[] fullHours() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    }

    private static int[] workingHours() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    }

    private static int[] notWorkingHours() {
        return new int[]{18, 19, 20, 21, 22, 23, 24};
    }

    private static Object[] workingTime() {
        return $(
                $(Calendar.MONDAY, new Hours(fullHours())),
                $(Calendar.TUESDAY, new Hours(fullHours())),
                $(Calendar.WEDNESDAY, new Hours(fullHours())),
                $(Calendar.THURSDAY, new Hours(fullHours())),
                $(Calendar.FRIDAY, new Hours(workingHours()))
        );
    }

    private static Object[] notWorkingTime() {
        return $(
                $(Calendar.FRIDAY, new Hours(notWorkingHours())),
                $(Calendar.SATURDAY, new Hours(fullHours())),
                $(Calendar.SUNDAY, new Hours(fullHours()))
        );
    }

    @Test
    @Parameters(method = "workingTime")
    public void shouldHandleIssueOnWorkingTime(int dayOfWeek, Hours hours) {
        for (int hour : hours.value){
            when(timeProvider.getTime()).thenReturn(getCalendar(dayOfWeek, hour));
            assertTrue(helpDesk.willHandleIssue(issue));
        }
    }

    @Test
    @Parameters(method = "notWorkingTime")
    public void shouldNotHandleIssueOnNotWorkingTime(int dayOfWeek, Hours hours) {
        for (int hour : hours.value){
            when(timeProvider.getTime()).thenReturn(getCalendar(dayOfWeek, hour));
            assertFalse(
                    String.format("Issue shouldn't be handled on day %d, hour %d", dayOfWeek, hour),
                    helpDesk.willHandleIssue(issue)
            );
        }
    }

    private static class Hours {
        int[] value;

        private Hours(int[] value) {
            this.value = value;
        }
    }
}
