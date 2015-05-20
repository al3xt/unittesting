package com.practicalunittesting.concurrent;

/**
 * Id generator interface
 * Created by otsukanov on 5/20/2015.
 */
public interface IdGenerator {

    /**
     * @return unique id
     */
    Long nextId();
}
