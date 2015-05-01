package com.practicalunittesting.mocks;

/**
 * Created by otsukanov on 04.03.2015.
 */
public interface Car {

    boolean needsFuel();

    double getEngineTemperature();

    void driveTo(String destination);
}
