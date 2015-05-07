package com.practicalunittesting;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Set;

/**
 * This is tests for Booking system
 * Created by otsukanov on 24.02.2015.
 */
public class BookingSystemTest {

    private BookingSystem bookingSystem;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bookingSystem = new BookingSystem();
    }

    @Test
    public void testBookFromNineToEleven() throws Exception {
        bookingSystem.book(9, 11);
        Set<Integer> bookedHours = bookingSystem.getBookedHours();
        Assert.assertEquals("Unexpected booked hours count", 2, bookedHours.size());
        Assert.assertTrue(bookedHours.contains(9));
        Assert.assertTrue(bookedHours.contains(10));
    }

    @Test
    public void testBookFromElevenToNineShouldThrowException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Cannot book. From time(11) should be less than to time (9)");
        bookingSystem.book(11, 9);
    }

    @Test
    public void testBookFromElevenToElevenShouldThrowException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Cannot book. From time(11) should be less than to time (11)");
        bookingSystem.book(11, 11);
    }

    @Test
    public void testBookWithinBookedPeriodShouldThrowException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Cannot book. Time from (10) to (11) has already booked");
        bookingSystem.book(9, 11);
        bookingSystem.book(10, 11);
    }

    @Test
    public void testBookWithOneIntersectionToBookedPeriodShouldThrowException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Cannot book. Time from (10) to (11) has already booked");
        bookingSystem.book(9, 11);
        bookingSystem.book(10, 12);
    }

    @Test
    public void testBookTimeInsideAlreadyBookedPeriods() throws Exception {
        bookingSystem.book(9, 11);
        bookingSystem.book(12, 14);
        bookingSystem.book(11, 12);
    }
}
