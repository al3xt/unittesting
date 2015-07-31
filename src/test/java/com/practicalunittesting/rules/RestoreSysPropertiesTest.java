package com.practicalunittesting.rules;

import org.junit.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by otsukanov on 7/30/2015.
 */
public class RestoreSysPropertiesTest {
    
    @Rule
    public RestoreSysPropertiesRule rule = new RestoreSysPropertiesRule();

    @Test
    public void testChangeUserDirProperty() throws Exception {
        System.setProperty("user.dir", "C:\\tmp");
        String userDirProperty = System.getProperty("user.dir");
        assertEquals("C:\\tmp", userDirProperty);
        System.out.println("In test user.dir: " + userDirProperty);
    }

    @Before
    public void beforeTest(){
        System.out.println("Before test user.dir: " + System.getProperty("user.dir"));
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("After test user.dir: " + System.getProperty("user.dir"));
    }
}
