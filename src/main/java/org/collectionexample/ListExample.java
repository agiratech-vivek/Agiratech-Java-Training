package org.collectionexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExample {
    public void arrayListOperations(Scanner scanner) {
        System.out.println("Please enter the count of numbers you want to enter in ArrayList");
        int numberCount = scanner.nextInt();
        List<String> numbers = new ArrayList<>();
        while(numberCount > 0){
            numbers.add(scanner.next());
        }
        while(true) {
            System.out.println("Press 1 to enter more elements one by one or Press 2 to delete elements from List");
            int option = scanner.nextInt();
            if (option == 1) {
                numbers.add(scanner.next());
            } else if (option == 2) {
                System.out.println("Please 1 to delete as per index or press 2 to delete by value");
                int subOption = scanner.nextInt();
                if(subOption == 1){
                    System.out.println("Please provide the index");
                    int index = scanner.nextInt();
                    if(index >= numbers.size()){
                        System.out.println("Index does not exist");
                    } else {
                        numbers.remove(index);
                    }
                } else if(subOption == 2){
                    System.out.println("Please provide the value");
                    String value = scanner.next();
                    if(numbers.contains(value)){
                        numbers.remove(value);
                    } else {
                        System.out.println("Value does not exist");
                    }
                }
            } else {
                break;
            }
        }
    }
}
