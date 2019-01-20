package com.au.taximgmt;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Taxi implements Runnable {
    public AtomicBoolean IN_QUEUE, IN_STAND, DEPART;

    public static final int MAX_CAPACITY = 4, MAX_WAIT_TIME = 60000, DELAY = 1000;
    private int taxiId, waitTime = 0;

    private Passenger.DESTINATION destination;
    private LinkedBlockingQueue<Passenger> passengerList;
    private LinkedBlockingQueue<Taxi> taxiQueue;
    private LinkedBlockingQueue<Taxi> taxiStand;

    public Taxi(LinkedBlockingQueue<Taxi> taxiQueue, LinkedBlockingQueue<Taxi> taxiStand) {
        this.IN_QUEUE = new AtomicBoolean();
        this.IN_STAND = new AtomicBoolean();
        this.DEPART = new AtomicBoolean();
        this.taxiQueue = taxiQueue;
        this.taxiStand = taxiStand;

        passengerList = new LinkedBlockingQueue<>(MAX_CAPACITY);
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public Passenger.DESTINATION getDestination() {
        return destination;
    }

    synchronized public boolean setDestination(Passenger.DESTINATION destination) {
        if(this.getDestination() == null) {
            this.destination = destination;
            return true;
        } else {
            return false;
        }
    }

    public int getCapacity() {
        return this.passengerList.size();
    }

    public boolean addPassenger(Passenger passenger) {
        return this.passengerList.offer(passenger);
    }

    public void removePassenger(Passenger passenger) {
        this.passengerList.remove(passenger);
    }

    @Override
    public void run() {
        while(!this.DEPART.get()) {
            try {
                if(this.IN_QUEUE.get()) {
                    if (this == taxiQueue.peek() && taxiStand.size() < TaxiStand.STAND_SIZE) {
                        // If taxi can be moved to taxi stand
                        if(this.IN_QUEUE.compareAndSet(true, false)) {
                            taxiQueue.remove(this);
                        }
                        if(this.IN_STAND.compareAndSet(false, true)) {
                            taxiStand.put(this);
                            System.out.println(TaxiStand.sdf.format(new Date().getTime()) + ": Taxi <" + this.getTaxiId()
                                    + "> moved to taxi stand");
                        }
                    } else {
                        Thread.sleep(DELAY);
                    }
                }
                if(this.IN_STAND.get()) {
                    if(this.waitTime == MAX_WAIT_TIME || this.passengerList.size() == MAX_CAPACITY) {
                        // If taxi has waited for 60 seconds for additional passenger
                        this.IN_STAND.compareAndSet(true, false);
                        if(this.DEPART.compareAndSet(false, true)) {
                            taxiStand.remove(this);
                            System.out.println(TaxiStand.sdf.format(new Date().getTime()) + ": Taxi <" + this.getTaxiId()
                                    + "> departed for " + this.getDestination()
                                    + " with " + this.getCapacity() + " passengers");
                        }

                        Taxi taxi = taxiQueue.peek();
                        if(taxi != null) {
                            if (taxi.IN_QUEUE.compareAndSet(true, false)) {
                                taxiQueue.remove(taxi);
                            }
                            if (taxi.IN_STAND.compareAndSet(false, true)) {
                                taxiStand.put(taxi);
                                System.out.println(TaxiStand.sdf.format(new Date().getTime()) + ": Taxi <" + taxi.getTaxiId()
                                        + "> moved to taxi stand");
                            }
                        }
                    } else {
                        // Wait for passenger
                        this.waitTime += DELAY;
                        Thread.sleep(DELAY);
                    }
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
