package org.multithreading.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiThreadingUsingRunnable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Press 1: Enter into a race\nPress 2: Exit");
            int option = scanner.nextInt();
            if(option == 1) {
                race(scanner);
            } else {
                break;
            }
        }
    }

    private static void race(Scanner scanner) {
        System.out.println("Please enter the number of players");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("Please enter the sprint distance in KM");
        int distance = scanner.nextInt();
        List<Thread> threads = new ArrayList<>();
        scanner.nextLine();
        while (numberOfPlayers-- > 0) {
            System.out.print("Car Name: ");
            String carName = scanner.nextLine();
            CarRaceRunner carRaceRunner = new CarRaceRunner(carName, distance);
            Thread thread = new Thread(carRaceRunner);
            threads.add(thread);
        }
        for (int index = 0; index < threads.size(); index++) {
            threads.get(index).start();
        }
    }
}