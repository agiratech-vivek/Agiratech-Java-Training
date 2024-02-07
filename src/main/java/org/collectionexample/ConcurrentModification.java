package org.collectionexample;

import java.util.*;

public class ConcurrentModification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();
        System.out.println("Please provide the count of numbers you want to enter");
        int count = scanner.nextInt();
        while(count > 0){
            numberList.add(scanner.nextInt());
            count--;
        }
        while(true){
            try {
                System.out.println("Press 1: Concurrent Modification using for each loop(Throws error)\n" +
                        "Press 2: Concurrent Modification using for loop\n" +
                        "Press 3: Concurrent Modification using Iterator\n" +
                        "Press 4: Exit");
                byte option = scanner.nextByte();
                if(option == 1){
                    concurrentModificationUsingForEach(scanner, numberList);
                } else if(option == 2){
                    concurrentModificationUsingForLoop(scanner, numberList);
                } else if (option == 3){
                    concurrentModificationUsingIterator(scanner, numberList);
                }
            } catch(ConcurrentModificationException concurrentModificationException){
                System.out.println("Cannot modify the list while iterating using for each loop");
            } catch (RuntimeException runtimeException){
                System.out.println(runtimeException.toString());
            } catch (Exception exception){
                System.out.println(exception.getCause().toString());
            }
        }
    }

    private static void concurrentModificationUsingIterator(Scanner scanner, List<Integer> numberList) {
        Iterator<Integer> integerListIterator = numberList.listIterator();
        System.out.println("Press 1: Remove numbers || Press 2: Add numbers");
        byte option = scanner.nextByte();
        if(option == 1) {
            while(integerListIterator.hasNext()){
                integerListIterator.next();
                integerListIterator.remove();
            }
        } else if (option == 2) {
            System.out.println("Please provide the number of inputs you want to insert");
            ListIterator<Integer> integerIterator = numberList.listIterator();
            int limit = scanner.nextInt();
            while(limit > 0){
                integerIterator.add(scanner.nextInt());
                limit--;
            }
        } else {
            System.out.println("Invalid option selected");
        }
        System.out.println("Current List Items: " + numberList.toString());
    }

    private static void concurrentModificationUsingForLoop(Scanner scanner, List<Integer> numberList) {
        System.out.println("Press 1: Remove numbers || Press 2: Add numbers");
        byte option = scanner.nextByte();
        if(option == 1) {
            for (int index = 0; index < numberList.size(); index++) {
                Integer value = numberList.get(index);
                numberList.remove(value);
            }
        } else if (option == 2) {
            System.out.println("Please provide the number of inputs you want to insert");
            int limit = scanner.nextInt();
            for(int index = 0; index < limit; index++){
                numberList.add(scanner.nextInt());
            }
        } else {
            System.out.println("Invalid option selected");
        }
        System.out.println("Current List Items: " + numberList.toString());
    }

    private static void concurrentModificationUsingForEach(Scanner scanner, List<Integer> numberList){
        System.out.println("Press 1: Remove numbers || Press 2: Add numbers");
        byte option = scanner.nextByte();
        if(option == 1) {
            for (int number : numberList) {
                numberList.remove(number);
            }
        } else if (option == 2) {
            for(int number : numberList){
                numberList.add(scanner.nextInt());
            }
        } else {
            System.out.println("Invalid option selected");
        }
        System.out.println("Current List Items: " + numberList.toString());
    }
}
