package org.multithreading.synchronizationproblem;

import java.util.Scanner;

public class SynchronizationRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Press 1: Try Synchronization problem\nPress 2: Exit");
            int option = scanner.nextInt();
            if(option == 1){
                synchronizationExecute(scanner);
            } else {
                break;
            }
        }
    }

    private static void synchronizationExecute(Scanner scanner) throws InterruptedException {
        System.out.println("Please insert the initial amount");
        //AtomicInteger initialAmount = new AtomicInteger(scanner.nextInt());
        Amount amount = new Amount(scanner.nextInt());
        System.out.println("Please mention the number of operations to be performed");
        int numberOfOperations = scanner.nextInt();
        DepositBalance depositBalance = new DepositBalance(amount, numberOfOperations);
        WithdrawBalance withdrawBalance = new WithdrawBalance(amount, numberOfOperations);
        Thread depositThread = new Thread(depositBalance);
        Thread withdrawThread = new Thread(withdrawBalance);
        depositThread.start();
        withdrawThread.start();
        depositThread.join();
        withdrawThread.join();
        System.out.println("Current available balance: " + amount.getAmount());
    }
}
