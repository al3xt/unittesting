package com.practicalunittesting.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;

/**
 * Tests demonstrate usage of Hamcrest assertions
 * Created by otsukanov on 5/25/2015.
 */
public class HamcrestCollectionTest {

    Set<String> setA = new LinkedHashSet<>();
    Set<String> setB = new LinkedHashSet<>();
    String s1 = "s1";
    String s2 = "s2";


    public void setUp(){
        setA.add(s1);
        setA.add(s2);
        setB.add(s2);
        setB.add(s1);
    }

    @Test
    public void collectionsUtilityMethods() {
        assertThat(setA, hasItem(s1));
        assertThat(setA, hasItem(s2));
        assertThat(setA, hasItem("xyz"));
        assertThat(setA, hasItems(s1, s2, "xyz"));
    }
    @Test
    public void mapsUtilityMethods() {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 2);
        map.put("b", 3);
        assertThat(map, hasEntry("a", (Object) 2));
        assertThat(map, hasKey("b"));
    }
}
