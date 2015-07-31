package com.practicalunittesting.matchers;

import org.junit.Test;

import static com.practicalunittesting.matchers.OperatingSystemMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by otsukanov on 7/27/2015.
 */
public class OperatingSystemTest {

    @Test
    public void testWindowsWith128Bit() {
        OperatingSystem windows = new OperatingSystem();
        windows.setNbOfBits(128);
        assertThat(windows, is128bit());
        assertThat(windows, not(is64bit()));
    }

    @Test
    public void testOSWithName() {
        OperatingSystem windows = new OperatingSystem();
        windows.setName("Windows 7");
        assertThat(windows, hasName("Windows 7"));
    }

    @Test
    public void testOSWithReleaseYear() {
        OperatingSystem windows = new OperatingSystem();
        windows.setReleaseYear(2007);
        assertThat(windows, wasReleasedIn(2007));
    }

}
