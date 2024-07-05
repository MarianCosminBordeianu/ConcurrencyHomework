package org.example;

public class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        gate.addTicket(ticketType);
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("Error");;
        }
    }
}
