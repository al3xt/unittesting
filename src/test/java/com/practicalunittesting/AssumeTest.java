package com.practicalunittesting;

import org.junit.Test;

import static org.junit.Assume.assumeTrue;

/**
 * This test shows possibilities of evaluation some condition at runtime
 * Created by Alexey on 10.05.2015.
 */
public class AssumeTest {

    @Test
    public void shouldRunOnlyOnWindows() {
        assumeTrue(thisIsAWindowsMachine());
        System.out.println("running on Windows!");
    }
    private boolean thisIsAWindowsMachine() {
        return System.getProperty("os.name").startsWith("Windows");
    }
    @Test
    public void shouldRunOnlyOnLinux() {
        assumeTrue(thisIsALinuxMachine());
        System.out.println("running on Linux!");
    }
    private boolean thisIsALinuxMachine() {
        return System.getProperty("os.name").startsWith("Linux");
    }
}
