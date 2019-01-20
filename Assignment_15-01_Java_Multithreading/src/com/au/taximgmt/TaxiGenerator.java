package com.au.taximgmt;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public class TaxiGenerator implements Runnable {
    private static int taxiId = 0;
    private LinkedBlockingQueue<Taxi> taxiQueue;
    private LinkedBlockingQueue<Taxi> taxiStand;

    public TaxiGenerator(LinkedBlockingQueue<Taxi> taxiQueue, LinkedBlockingQueue<Taxi> taxiStand) {
        this.taxiQueue = taxiQueue;
        this.taxiStand = taxiStand;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Taxi taxi = new Taxi(taxiQueue, taxiStand);
                taxi.setTaxiId(taxiId);

                taxiQueue.put(taxi);
                taxi.IN_QUEUE.compareAndSet(false, true);

                System.out.println(TaxiStand.sdf.format(new Date().getTime()) + ": Taxi <" + taxiId + "> added to queue");

                new Thread(taxi).start();

                taxiId++;

                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
