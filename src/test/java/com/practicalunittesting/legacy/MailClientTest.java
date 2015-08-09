package com.practicalunittesting.legacy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 * Tests for MailClient, include static method call verification
 * Created by Alexey on 09.08.2015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmailServer.class)
public class MailClientTest {

    public static final String ADDRESS = "Odessa";

    public static final String TITLE = "Test email";

    public static final String BODY = "Hello!";

    @Test
    public void mustSendEmail() throws Exception {
        mockStatic(EmailServer.class);
        MailClient mailClient = spy(MailClient.class);
        ArgumentCaptor<Email> argument
                = ArgumentCaptor.forClass(Email.class);
        mailClient.sendEmail(ADDRESS, TITLE, BODY);
        verifyStatic();
        EmailServer.sendEmail(argument.capture());
        Email email = argument.getValue();
        assertEquals(ADDRESS, email.getAddress());
        assertEquals(TITLE, email.getTitle());
        assertEquals(BODY, email.getBody());
    }
}
