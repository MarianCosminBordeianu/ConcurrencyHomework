package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    private final Queue<TicketType> ticketQueue = new LinkedList<>();

    public synchronized void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public synchronized Queue<TicketType> getTicketQueue() {
        return new LinkedList<>(ticketQueue);
    }
}
