package com.practicalunittesting.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This is a generator for some identifier
 * Created by otsukanov on 5/20/2015.
 */
public class AtomicIdGenerator implements IdGenerator {

    private static AtomicLong nextId = new AtomicLong(System.currentTimeMillis());

    public Long nextId() {
        return nextId.incrementAndGet();
    }
}
