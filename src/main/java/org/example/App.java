package org.example;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);

        statisticsThread.start();

        Random random = new Random();
        TicketType[] ticketTypes = TicketType.values();

        for (int i = 0; i < 1000; i++) {
            TicketType ticketType = ticketTypes[random.nextInt(ticketTypes.length)];
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        statisticsThread.stopRunning();
        try {
            statisticsThread.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        System.out.println("Festival simulation ended.");
    }
}
