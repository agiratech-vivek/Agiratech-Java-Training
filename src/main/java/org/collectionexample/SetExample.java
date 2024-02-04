package org.collectionexample;

import java.util.*;

public class SetExample {
    public void setOperations(Scanner scanner){
        Set<String> set = new HashSet<>();
        System.out.println("Please enter the count of numbers you want to enter in ArrayList");
        int numberCount = scanner.nextInt();
        while(numberCount > 0){
            set.add(scanner.next());
        }
        while(true) {
            System.out.println("Press 1 to enter more elements one by one or Press 2 to delete elements from List");
            int option = scanner.nextInt();
            if (option == 1) {
                String value = scanner.next();
                if(set.contains(value)){
                    System.out.println("Set already contains the value");
                } else {
                    set.add(value);
                }
            } else if (option == 2) {
                System.out.println("Please 1 to delete as per index or press 2 to delete by value");
                int subOption = scanner.nextInt();
                if(subOption == 1){
                    System.out.println("Please provide the index");
                    int index = scanner.nextInt();
                    if(index >= set.size()){
                        System.out.println("Index does not exist");
                    } else {
                        set.remove(index);
                    }
                } else if(subOption == 2){
                    System.out.println("Please provide the value");
                    String value = scanner.next();
                    if(set.contains(value)){
                        set.remove(value);
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
