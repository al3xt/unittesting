package com.practicalunittesting;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for HashMap functionality
 * Created by otsukanov on 04.02.2015.
 */
public class HashMapTest {

    private Map<String, String> testMap;

    @Before
    public void setUp(){
        testMap = new HashMap<String, String>();
    }

    @Test
    public void testPutCanBeRetrievedWithGet(){
        String value = "TestValue";
        String key = "TestKey";
        testMap.put(key, value);
        assertEquals(value, testMap.get(key));
    }

    @Test
    public void testAddTwoDifferentObjectsWithSameKey(){
        String value = "TestValue";
        String secondValue = "SecondTestValue";
        String key = "TestKey";
        testMap.put(key, value);
        assertEquals(value, testMap.put(key, secondValue));
        assertEquals(secondValue, testMap.get(key));
    }

    @Test
    public void testMapDoesNotContainElementsAfterClear(){
        String key = "TestKey";
        String secondKey = "TestKey";
        String value = "TestValue";
        String secondValue = "SecondTestValue";
        testMap.put(key, value);
        testMap.put(secondKey, secondValue);
        testMap.clear();
        assertTrue(testMap.isEmpty());
    }

    @Test
    public void testNullKeyUsage(){
        String key = null;
        String value = "TestValue";
        testMap.put(key, value);
        assertEquals(value, testMap.get(key));
    }

}
