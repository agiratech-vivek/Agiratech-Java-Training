package org.java8features.functionalinterface.supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dice dice = new Dice();
        System.out.println("Welcome to Race with Dices");
        System.out.println("Please enter the range");
        int range = scanner.nextInt();
        System.out.print("1st Player name: ");
        scanner.nextLine();
        String firstPlayer = scanner.nextLine();
        System.out.print("2nd Player name: ");
        String secondPlayer = scanner.nextLine();
        int firstPlayerPosition = 0;
        int secondPlayerPosition = 0;
        firstPlayerPosition = gamePlay(firstPlayerPosition, range, secondPlayerPosition, firstPlayer, secondPlayer, scanner, dice);
        if(firstPlayerPosition >= range){
            System.out.println(firstPlayer + " won!!");
        } else {
            System.out.println(secondPlayer + " won!!");
        }
    }

    private static int gamePlay(int firstPlayerPosition, int range, int secondPlayerPosition, String firstPlayer, String secondPlayer, Scanner scanner, Dice dice) {
        while(firstPlayerPosition < range && secondPlayerPosition < range){
            System.out.println(firstPlayer + " is at " + firstPlayerPosition);
            System.out.println(secondPlayer + " is at " + secondPlayerPosition);
            System.out.println("Press any key to roll the dices");
            scanner.nextLine();
            // using supplier by implementing in the class Dice
            int firstPlayerDiceNumber = dice.get();
            // using supplier with lambda expression and storing the function implementation in Supplier variable
            Supplier<Integer> secondPlayerDiceNumber = () -> (int) Math.round(Math.random() * 100) % 6 + 1;
            firstPlayerPosition += firstPlayerDiceNumber;
            // getting the integer value using get function.
            secondPlayerPosition += secondPlayerDiceNumber.get();
            System.out.println(firstPlayer + " got " + firstPlayerDiceNumber);
            System.out.println(secondPlayer + " got " + secondPlayerDiceNumber);
            System.out.println();
        }
        return firstPlayerPosition;
    }
}
