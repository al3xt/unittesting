package com.practicalunittesting.concurrent;

/**
 * Created by otsukanov on 5/20/2015.
 */
public class AtomicIdGenerator implements IdGenerator {

    private static Long nextId = System.currentTimeMillis();

    public Long nextId() {
        return nextId++;
    }
}
