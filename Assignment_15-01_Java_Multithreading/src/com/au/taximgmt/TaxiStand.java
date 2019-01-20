package com.au.taximgmt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public class TaxiStand {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static final int STAND_SIZE = 5;
    public static LinkedBlockingQueue<Taxi> taxiStand;

    public static void main(String args[]) {
        taxiStand = new LinkedBlockingQueue<>(STAND_SIZE);

        LinkedBlockingQueue<Taxi> taxiQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Passenger> passengers = new LinkedBlockingQueue<>();

        TaxiGenerator taxiGenerator = new TaxiGenerator(taxiQueue, taxiStand);
        PassengerGenerator passengerGenerator = new PassengerGenerator(passengers, taxiStand);

        new Thread(taxiGenerator).start();
        System.out.println(sdf.format(new Date().getTime()) + ": Taxi generator started...");
        new Thread(passengerGenerator).start();
        System.out.println(sdf.format(new Date().getTime()) + ": Passenger generator started...");
    }
}
