package org.multithreading.executerservice;

public class CarProduction implements Runnable {
    private String carName;

    public CarProduction(String carName) {
        this.carName = carName;
    }

    @Override
    public void run() {
        System.out.println(carName + " manufactured on " + Thread.currentThread().getName());
    }
}
