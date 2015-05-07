package com.practicalunittesting.mocks;

import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests, which demonstrate basic Mockito functionality
 * Created by otsukanov on 04.03.2015.
 */
public class MockitoReturningDesiredValuesTest {

    private Car myFerrari = mock(Car.class);

    @Test
    public void testStubbing() {
        assertFalse("new test double should return false as boolean",
                myFerrari.needsFuel());
        when(myFerrari.needsFuel()).thenReturn(true);
        assertTrue("after instructed test double should return what we want",
                myFerrari.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        when(myFerrari.needsFuel())
                .thenThrow(new RuntimeException());
        myFerrari.needsFuel();
    }

    @Test
    public void testVerification() {
        myFerrari.driveTo("Sweet home Alabama");
        myFerrari.needsFuel();
        verify(myFerrari).driveTo("Sweet home Alabama");
        verify(myFerrari).needsFuel();
    }

    @Test
    @Ignore
    public void testVerificationFailure() {
        myFerrari.needsFuel();
        verify(myFerrari).getEngineTemperature();
    }

    @Test
    @Ignore
    public void testVerificationFailureArguments() {
        myFerrari.driveTo("Sweet home Alabama");
        verify(myFerrari).driveTo("Sweet home Honolulu");
    }
}
