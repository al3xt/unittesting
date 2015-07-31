package com.practicalunittesting.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by otsukanov on 7/27/2015.
 */
public class OperatingSystemMatcher extends TypeSafeMatcher<OperatingSystem> {

    @Override
    protected boolean matchesSafely(OperatingSystem operatingSystem) {
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("operation system matcher");
    }

    @Factory
    public static <T> Matcher<OperatingSystem> is128bit() {
        return new NumberOfBitsMatcher(128);
    }

    @Factory
    public static <T> Matcher<OperatingSystem> is64bit() {
        return new NumberOfBitsMatcher(64);
    }

    @Factory
    public static <T> Matcher<OperatingSystem> hasName(final String name) {
        return new TypeSafeMatcher<OperatingSystem>() {
            @Override
            protected boolean matchesSafely(OperatingSystem operatingSystem) {
                return operatingSystem.getName().equals(name);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("name doesn't match");
            }
        };
    }

    @Factory
    public static <T> Matcher<OperatingSystem> wasReleasedIn(final int year) {
        return new TypeSafeMatcher<OperatingSystem>() {
            @Override
            protected boolean matchesSafely(OperatingSystem operatingSystem) {
                return operatingSystem.getReleaseYear() == year;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("year doesn't match");
            }
        };
    }

    private static class NumberOfBitsMatcher extends TypeSafeMatcher<OperatingSystem> {

        private int expectedNumber;

        private NumberOfBitsMatcher(int expectedNumber) {
            this.expectedNumber = expectedNumber;
        }

        @Override
        protected boolean matchesSafely(OperatingSystem operatingSystem) {
            return expectedNumber == operatingSystem.getNbOfBits();
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("number of bits doesn't match");
        }
    }

    private static class NameMatcher extends TypeSafeMatcher<OperatingSystem> {
        @Override
        protected boolean matchesSafely(OperatingSystem operatingSystem) {
            return false;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("name doesn't match");
        }
    }
}
