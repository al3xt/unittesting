package com.practicalunittesting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by otsukanov on 24.02.2015.
 */
public class BookingSystem {

    private Set<Integer> bookedHours = new HashSet<Integer>();

    public void book(int fromTime, int toTime) throws Exception {
        if(fromTime >= toTime){
            throw new Exception(
                    String.format("Cannot book. From time(%d) should be less than to time (%d)", fromTime, toTime)
            );
        }
        if(bookedHours.contains(fromTime) && bookedHours.contains(toTime - 1)){
            throw new Exception(
                    String.format("Cannot book. Time from (%d) to (%d) has already booked", fromTime, toTime)
            );
        }
        List<Integer> intersectionsWithBookedHours = new ArrayList<Integer>();
        List<Integer> unbookedHours = new ArrayList<Integer>();
        for(int i = fromTime; i < toTime; i++){
            if(bookedHours.contains(i)){
                intersectionsWithBookedHours.add(i);
            } else {
                unbookedHours.add(i);
            }
        }
        if(intersectionsWithBookedHours.isEmpty()){
            bookedHours.addAll(unbookedHours);
        } else {
            StringBuilder alreadyBookedPeriodPart = new StringBuilder();
            for(Integer bookedHour : intersectionsWithBookedHours){
                alreadyBookedPeriodPart.append(" from (");
                alreadyBookedPeriodPart.append(bookedHour);
                alreadyBookedPeriodPart.append(") to (");
                alreadyBookedPeriodPart.append(bookedHour + 1);
                alreadyBookedPeriodPart.append("),");
            }
            throw new Exception(
                    "Cannot book. Time" + alreadyBookedPeriodPart.toString().substring(0, alreadyBookedPeriodPart.length() - 1)
                    + " has already booked"
            );
        }
    }

    public Set<Integer> getBookedHours(){
        return bookedHours;
    }

}
