package com.au.taximgmt;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Passenger implements Runnable {
    public static enum DESTINATION {
        WHITEFIELD, SARJAPUR, KRPURAM, INDIRANAGAR, MGROAD, HEBBAL, JAYANAGAR, PEENYA, HSRLAYOUT, KORAMANGLA
    }

    private static final int MIN_WAIT = 50, WAIT_CHANGE = 10;

    public boolean IN_TAXI;
    private int passengerId, waitDuration;

    private DESTINATION destination;
    private LinkedBlockingQueue<Passenger> passengers;
    private LinkedBlockingQueue<Taxi> taxiStand;

    public Passenger(LinkedBlockingQueue<Passenger> passengers, LinkedBlockingQueue<Taxi> taxiStand) {
        this.passengers = passengers;
        this.taxiStand = taxiStand;
        this.waitDuration = 1000;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public DESTINATION getDestination() {
        return destination;
    }

    public void setRandomDestination() {
        this.destination = DESTINATION.values()[new Random().nextInt(DESTINATION.values().length)];
    }

    @Override
    public void run() {
        while(!this.IN_TAXI) {
            try {
                // Check for every taxi in taxi stand
                for (Taxi taxi : taxiStand) {
                    if (taxi.getDestination() == null) {
                        // If taxi has no destination assigned
                        if (taxi.addPassenger(this)) {
                            if (taxi.setDestination(this.destination)) {
                                this.IN_TAXI = true;
                                System.out.println(TaxiStand.sdf.format(new Date().getTime()) + ": Passenger <"
                                        + this.getPassengerId() + "> added to Taxi <"
                                        + taxi.getTaxiId() + "> and destination set to " + this.destination);

                                passengers.remove(this);
                                break;
                            }
                        }
                    } else if (taxi.getDestination() == this.destination && taxi.getCapacity() < Taxi.MAX_CAPACITY) {
                        // If taxi destination matches passenger destination
                        if (taxi.addPassenger(this)) {
                            this.IN_TAXI = true;

                            System.out.println(TaxiStand.sdf.format(new Date().getTime()) + ": Passenger <"
                                    + this.getPassengerId() + "> added to Taxi <" + taxi.getTaxiId() + ">" );

                            passengers.remove(this);
                            break;
                        }
                    }
                }

                // Reduce sleep time for thread of passenger waiting for long time
                this.waitDuration -= Passenger.WAIT_CHANGE;
                if(this.waitDuration < Passenger.MIN_WAIT) {
                    this.waitDuration = Passenger.MIN_WAIT;
                }

                Thread.sleep(this.waitDuration);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
