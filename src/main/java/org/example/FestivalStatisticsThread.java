package org.example;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private volatile boolean running = true;


    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000);
                generateStatistics();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        System.out.println("Statistics thread stopped");
    }
    public void stopRunning(){
        running = false;
    }

    private void generateStatistics() {
        Queue<TicketType> ticketQueue = gate.getTicketQueue();
        if (ticketQueue.isEmpty()) {
            System.out.println("No new attendees in the last 5 seconds.");
            return;
        }

        int full = 0, fullVip = 0, freePass = 0, oneDay = 0, oneDayVip = 0;

        for (TicketType ticket : ticketQueue) {
            switch (ticket) {
                case FULL:
                    full++;
                    break;
                case FULL_VIP:
                    fullVip++;
                    break;
                case FREE_PASS:
                    freePass++;
                    break;
                case ONE_DAY:
                    oneDay++;
                    break;
                case ONE_DAY_VIP:
                    oneDayVip++;
                    break;
            }
        }

        System.out.println("Festival statistics:");
        System.out.println(ticketQueue.size() + " people entered");
        System.out.println(full + " have full tickets");
        System.out.println(fullVip + " have full VIP tickets");
        System.out.println(freePass + " have free passes");
        System.out.println(oneDay + " have one-day passes");
        System.out.println(oneDayVip + " have one-day VIP passes");
    }
}
