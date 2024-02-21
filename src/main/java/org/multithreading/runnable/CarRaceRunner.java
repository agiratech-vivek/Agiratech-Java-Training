package org.multithreading.runnable;

import java.util.Random;

public class CarRaceRunner implements Runnable {
    private String carName;
    public static int currentPosition = 1;
    private int totalDistance;

    public CarRaceRunner(String carName, int totalDistance) {
        this.carName = carName;
        this.totalDistance = totalDistance;
    }

    @Override
    public void run() {
        int currentDistance = 0;
        while(currentDistance < totalDistance){
            Random random = new Random();
            currentDistance = currentDistance + random.nextInt(20);
            System.out.println(carName + " has covered " + currentDistance + " KM.");
        }
        System.out.println("******* " + carName + " finished at " + currentPosition + " ********");
        currentPosition++;
    }
}
