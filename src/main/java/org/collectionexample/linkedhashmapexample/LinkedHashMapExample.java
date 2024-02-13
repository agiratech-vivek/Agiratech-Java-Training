package org.collectionexample.linkedhashmapexample;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Players> raceCarsMap = new LinkedHashMap<>();
        while (true) {
            System.out.println(
                    "Press 1: Insert players as per ranking\n" +
                    "Press 2: Display Players ranking\n" +
                    "Press 3: Remove Players\n" +
                    "Press 4: Update Player\n" +
                    "Press 5: Replace Player\n" +
                    "Press 6: Insert new player\n" +
                    "Press 7: exit"
            );
            int option = scanner.nextInt();
            if (option == 1) {
                //insertPlayer(scanner, raceCarsMap);
                raceCarsMap.put(1, new Players("Vivek", "Ferrari"));
                raceCarsMap.put(2, new Players("Kishore", "McLaren"));
                raceCarsMap.put(3, new Players("Deva", "Nissan"));
                raceCarsMap.put(4, new Players("Arun", "Tesla"));
            } else if (option == 2) {
                displayPlayers(raceCarsMap);
            } else if (option == 3) {
                removePlayers(scanner, raceCarsMap);
            } else if (option == 4) {
                updatePlayers(scanner, raceCarsMap);
            } else if (option == 5) {
                replacePlayer(scanner, raceCarsMap);
            } else if (option == 6) {
                insertIfAbsent(scanner, raceCarsMap);
            } else if (option == 7) {
                break;
            } else {
                System.out.println("Please provide correct input");
            }
        }
    }

    private static void insertIfAbsent(Scanner scanner, Map<Integer, Players> raceCarsMap) {
        System.out.println(Integer.parseInt("12"));
        System.out.println("Add new player if not present");
        System.out.println("Player number, Player name, Car");
        scanner.nextLine();
        String[] playerData = scanner.nextLine().split(", ");
        int playerNumber = Integer.parseInt(playerData[0]);
        Players newPlayer = raceCarsMap.computeIfAbsent(
                playerNumber, key -> {
                    System.out.println("New player added");
                    return new Players(playerData[1], playerData[2]);
                });
        System.out.println(newPlayer.toString());
    }

    private static void replacePlayer(Scanner scanner, Map<Integer, Players> raceCarsMap) {
        System.out.println("Replace player");
        System.out.print("Player number: ");
        int playerNumber = scanner.nextInt();
        if (!raceCarsMap.containsKey(playerNumber)) {
            System.out.println("Player does not exist");
            return;
        }
        System.out.println("Player name: ");
        String playerName = scanner.next();
        System.out.println("Car name: ");
        String carName = scanner.next();
        Players oldPlayer = raceCarsMap.get(playerNumber);
        raceCarsMap.replace(playerNumber, oldPlayer, new Players(playerName, carName));
        System.out.println(oldPlayer.getName() + "'s name has been updated to " + raceCarsMap.get(playerNumber).getName());
    }

    private static void updatePlayers(Scanner scanner, Map<Integer, Players> raceCarsMap) {
        System.out.println("Update Player");
        System.out.println("Player number, New Car name");
        scanner.nextLine();
        String[] playerData = scanner.nextLine().split(", ");
        int playerNumber = Integer.parseInt(playerData[0]);
        raceCarsMap.computeIfPresent(playerNumber, (key, value) -> {
            System.out.println("Player car has been updated");
            value.setCarName(playerData[1]);
            return value;
        });
    }

    private static void removePlayers(Scanner scanner, Map<Integer, Players> raceCarsMap) {
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
    }

    private static void displayPlayers(Map<Integer, Players> raceCarsMap) {
        System.out.println("List of players as per their rank");
        int rank = 1;
        for(Map.Entry<Integer, Players> playersEntry: raceCarsMap.entrySet()){
            System.out.print(rank + ": " + playersEntry.getValue().getName() + " (" + playersEntry.getKey() + ") " + playersEntry.getValue().getCarName());
            System.out.println();
            rank++;
        }
    }

    private static void insertPlayer(Scanner scanner, Map<Integer, Players> raceCarsMap) {
        System.out.println("Please enter the number of cars in the race");
        int numberOfCars = scanner.nextInt();
        while (numberOfCars-- > 0) {
            scanner.nextLine();
            String[] playerData = scanner.nextLine().split(", ");
            int playerNumber = Integer.parseInt(playerData[0]);
            String playerName = playerData[1];
            String carName = playerData[2];
            if (raceCarsMap.containsKey(playerNumber)) {
                numberOfCars++;
                System.out.println("Player number already exists");
                continue;
            }
            raceCarsMap.put(playerNumber, new Players(playerName, carName));
        }
    }
}
