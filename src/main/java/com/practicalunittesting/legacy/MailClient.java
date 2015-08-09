package com.practicalunittesting.legacy;

/**
 * Created by Alexey on 09.08.2015.
 */
public class MailClient {

    public void sendEmail(String address, String title, String body) {
        Email email = new Email(address, title, body);
        EmailServer.sendEmail(email);
    }
}
