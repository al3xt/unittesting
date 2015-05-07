package com.practicalunittesting.mocks;

import java.util.*;

/**
 * Race result service, which sends message to all registered clients
 * Implements Listener pattern
 * Created by Alexey on 02.05.2015.
 */
public class RaceResultsService {

    private Map<RaceCategory, Set<Client>> categoryToClients = new HashMap<>();

    private MessageLogger logger;

    public RaceResultsService(MessageLogger logger) {
        this.logger = logger;
    }

    public void addSubscriber(Client client, RaceCategory category) {
        Set<Client> clients = categoryToClients.get(category);
        if(clients == null){
            clients = new HashSet<>();
            categoryToClients.put(category, clients);
        }
        clients.add(client);
    }

    public void removeSubscriber(Client client, RaceCategory category) throws Exception {
        if(categoryToClients.containsKey(category)){
            categoryToClients.get(category).remove(client);
        } else {
            throw new Exception("Client is not subscribed to category");
        }
    }

    public void send(Message message, RaceCategory category) {
        if(categoryToClients.containsKey(category)){
            for(Client client : categoryToClients.get(category)) {
                client.receive(message);
            }
        }
        logger.log(message.getText(), message.getDate());
    }

    public void send(List<Message> messages, RaceCategory category) {
        for(Message message : messages){
            send(message, category);
        }
    }
}
