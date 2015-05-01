package com.practicalunittesting;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by otsukanov on 24.02.2015.
 */
public class DigitSequenceExtractor {

    public static final String THREE_DIGITS_SEQUENCE_PATTERN = "\\d{3,}";

    public List<String> extract(String source){
        if(source == null){
            throw new NullPointerException();
        }
        List<String> digitSequences = new ArrayList<String>();
        Pattern pattern = Pattern.compile(THREE_DIGITS_SEQUENCE_PATTERN);
        Matcher matcher = pattern.matcher(source);
        while(matcher.find()) {
            digitSequences.add(matcher.group());
        }
        return digitSequences;
    }
}
