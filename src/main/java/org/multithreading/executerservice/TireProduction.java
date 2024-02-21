package org.multithreading.executerservice;

public class TireProduction implements Runnable {

    private String tireName;

    public TireProduction(String tireName) {
        this.tireName = tireName;
    }

    @Override
    public void run() {
        System.out.println(tireName + " was manufactured on " + Thread.currentThread().getName());
    }
}
