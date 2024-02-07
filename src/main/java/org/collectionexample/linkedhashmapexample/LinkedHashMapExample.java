package org.collectionexample.linkedhashmapexample;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Players> raceCarsMap = new LinkedHashMap<>();
        while (true) {
            System.out.println("Press 1: Insert players as per ranking\nPress 2: Display Players ranking\nPress 3: Remove Players\nPress 4: exit");
            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Please enter the number of cars in the race");
                int numberOfCars = scanner.nextInt();
                while (numberOfCars-- > 0) {
                    System.out.println("Player number: ");
                    int playerNumber = scanner.nextInt();
                    System.out.print("Player name: ");
                    String playerName = scanner.next();
                    System.out.println("Car name: ");
                    String carName = scanner.next();
                    if (raceCarsMap.containsKey(playerNumber)) {
                        numberOfCars++;
                        System.out.println("Player number already exists");
                        continue;
                    }
                    raceCarsMap.put(playerNumber, new Players(playerName, carName));
                }
            } else if (option == 2) {
                System.out.println("List of players as per their rank");
                int rank = 1;
                for (int playerNumber : raceCarsMap.keySet()) {
                    System.out.println(rank + ": " + raceCarsMap.get(playerNumber).getName() + " Car: " + raceCarsMap.get(playerNumber).getCarName());
                    rank++;
                }
            } else if (option == 3) {
                System.out.println("Please enter the number of players you want to remove");
                int numberOfPlayers = scanner.nextInt();
                while (numberOfPlayers-- > 0 && !raceCarsMap.isEmpty()) {
                    System.out.println("Please mention the player number you want to remove from race");
                    int playerNumber = scanner.nextInt();
                    if (!raceCarsMap.containsKey(playerNumber)) {
                        System.out.println("Player does not exists");
                    }
                    raceCarsMap.remove(playerNumber);
                }
            } else if (option == 4) {
                break;
            } else {
                System.out.println("Please provide correct input");
            }
        }
    }
}
