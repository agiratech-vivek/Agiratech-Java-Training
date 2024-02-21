package org.collectionexample;

import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeExample {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of fruits you to want add in basket");
        int numberOfFruits = scanner.nextInt();
        BlockingDeque<String> fruitQueue = new LinkedBlockingDeque<>(numberOfFruits);
        while (numberOfFruits-- > 0) {
            fruitQueue.add(scanner.next());
        }
        // To add another fruit we need to remove a fruit from the fruitQueue
        // add, addFirst, addLast, remove, removeFirst, removeLast throws exception
        while (true) {
            try {
                System.out.println("BlockDeque using methods which throws exception");
                System.out.println("Press 1 to remove a fruit\nPress 2 to add the fruit\nPress 3 to show the fruit\nPress 4 to exit");
                int option = scanner.nextInt();
                if (option == 1) {
                    fruitQueue.removeFirst();
                } else if (option == 2) {
                    System.out.println("Please enter the food name you want to enter");
                    fruitQueue.addLast(scanner.next());
                } else if (option == 3) {
                    System.out.println(fruitQueue.toString());
                } else if (option == 4) {
                    break;
                }
            } catch (Exception exception) {
                System.out.println(exception.getCause().toString());
            }
        }
        // offer, offerFirst, offerLast, poll, pollFirst, pollLast, peek, peekFirst, peekLast
        // returns boolean value for adding new element and returns null or object name while removing
        while (true) {
            System.out.println("BlockDeque using methods which returns null, value or boolean");
            System.out.println("Press 1 to remove a fruit\nPress 2 to add the fruit\nPress 3 to show the fruits\nPress 4 to exit");
            int newOption = scanner.nextInt();
            if (newOption == 1) {
                System.out.println(fruitQueue.pollLast());
            } else if (newOption == 2) {
                System.out.println("Please enter the fruit name you want to enter");
                System.out.println(fruitQueue.offerFirst(scanner.next()));
            } else if (newOption == 3) {
                System.out.println(fruitQueue.toString());
            } else {
                break;
            }
        }

        // put, putFirst, putLast, take, takeFirst, takeLast blocks the runnable to perform operation
        // if dequeue is full then it will wait indefinitely for different runnable to delete the item
        // if dequeue is empty then it will wait indefinitely for different runnable to populate the queue
        while (true) {
            System.out.println("BlockDeque using methods which blocks the runnable");
            System.out.println("Press 1 to remove a fruit\nPress 2 to add a fruit\nPress 3 to show the fruits");
            int blockOption = scanner.nextInt();
            if (blockOption == 1) {
                fruitQueue.takeLast();
            } else if (blockOption == 2) {
                System.out.println("Please enter the fruit name");
                fruitQueue.putFirst(scanner.next());
            } else if (blockOption == 3) {
                System.out.println(fruitQueue.toString());
            } else {
                break;
            }
        }
    }
}
