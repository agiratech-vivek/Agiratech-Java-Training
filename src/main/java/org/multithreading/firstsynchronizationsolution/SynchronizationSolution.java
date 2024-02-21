package org.multithreading.firstsynchronizationsolution;

import java.util.Scanner;

public class SynchronizationSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Press 1: Try Synchronization solution\nPress 2: Exit");
            int option = scanner.nextInt();
            if(option == 1){
                synchronizationSolution(scanner);
            } else if(option == 2){
                break;
            }
        }
    }

    private static void synchronizationSolution(Scanner scanner) {
        try {
            System.out.println("Please mention the initial amount");
            int initialAmount = scanner.nextInt();
            Amount amount = new Amount(initialAmount);
            System.out.println("Please mention the number of operations");
            int numberOfOperations = scanner.nextInt();
            Deposit deposit = new Deposit(amount, numberOfOperations);
            Withdraw withdraw = new Withdraw(amount, numberOfOperations);
            Thread depositThread = new Thread(deposit);
            Thread withdrawThread = new Thread(withdraw);
            depositThread.start();
            withdrawThread.start();
            depositThread.join();
            withdrawThread.join();
            System.out.println(amount.getAmount());
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
