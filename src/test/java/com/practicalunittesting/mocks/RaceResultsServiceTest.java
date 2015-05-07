package com.practicalunittesting.mocks;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.*;

/**
 * Tests for RaceResultsService
 * Created by Alexey on 02.05.2015.
 */
public class RaceResultsServiceTest {

    public static final String MESSAGE_TEXT = "Default message";

    public static final Date MESSAGE_DATE = new Date();

    private MessageLogger logger = mock(MessageLogger.class);

    private Message message = mock(Message.class);

    private Message secondMessage = mock(Message.class);

    private Message thirdMessage = mock(Message.class);

    private Client clientA = mock(Client.class, "clientA");

    private Client clientB = mock(Client.class, "clientB");

    private RaceResultsService raceResults = new RaceResultsService(logger);

    @Test
    public void sentMessageMustBeLogged() {
        Message messageWithText = mock(Message.class);
        when(messageWithText.getText()).thenReturn(MESSAGE_TEXT);
        when(messageWithText.getDate()).thenReturn(MESSAGE_DATE);
        raceResults.send(messageWithText, RaceCategory.HORSE_RACE);
        verify(logger).log(MESSAGE_TEXT, MESSAGE_DATE);
    }

    @Test
    public void subscribedClientShouldReceiveSameCategoryMessage() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.send(message, RaceCategory.HORSE_RACE);
        verify(clientA).receive(message);
    }

    @Test
    public void subscribedClientShouldNotReceiveDifferentCategoryMessage() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.send(message, RaceCategory.BOAT);
        verify(clientA, never()).receive(message);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMessages() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.addSubscriber(clientB, RaceCategory.HORSE_RACE);
        raceResults.send(message, RaceCategory.HORSE_RACE);
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message, RaceCategory.HORSE_RACE);
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.addSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.send(message, RaceCategory.HORSE_RACE);
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() throws Exception {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.removeSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.send(message, RaceCategory.HORSE_RACE);
        verify(clientA, never()).receive(message);
    }

    @Test
    public void subscribedClientShouldReceiveSameCategoryAllMessages() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE_RACE);
        raceResults.send(
                Arrays.asList(message, secondMessage, thirdMessage),
                RaceCategory.HORSE_RACE
        );
        verify(clientA).receive(message);
        verify(clientA).receive(secondMessage);
        verify(clientA).receive(thirdMessage);
    }

    @Test(expected = Exception.class)
    public void throwExceptionWhenNotSubscribedClientTriesToUnsubscribe() throws Exception {
        raceResults.removeSubscriber(clientA, RaceCategory.HORSE_RACE);
    }

}
