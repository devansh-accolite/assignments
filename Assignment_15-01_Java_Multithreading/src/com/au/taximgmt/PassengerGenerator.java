package com.au.taximgmt;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public class PassengerGenerator implements Runnable {
    private static int passengerId = 0;
    private LinkedBlockingQueue<Passenger> passengers;
    private LinkedBlockingQueue<Taxi> taxiStand;

    public PassengerGenerator(LinkedBlockingQueue<Passenger> passengers, LinkedBlockingQueue<Taxi> taxiStand) {
        this.passengers = passengers;
        this.taxiStand = taxiStand;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Passenger passenger = new Passenger(passengers, taxiStand);
                passenger.setPassengerId(passengerId);
                passenger.setRandomDestination();

                System.out.println(TaxiStand.sdf.format(new Date().getTime()) + ": Passenger <"
                        + passengerId + "> travelling to " + passenger.getDestination() + " added to queue");

                new Thread(passenger).start();

                passengerId++;

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
