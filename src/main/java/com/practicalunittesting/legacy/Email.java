package com.practicalunittesting.legacy;

/**
 * Created by Alexey on 09.08.2015.
 */
public class Email {

    private String address;

    private String title;

    private String body;

    public Email(String address, String title, String body) {
        this.address = address;
        this.title = title;
        this.body = body;
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
