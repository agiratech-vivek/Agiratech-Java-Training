package org.collectionexample;

import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetExample {
    public void treeSetOperations(Scanner scanner){
        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println("Please provide the count of elements you want to enter");
        int range = scanner.nextInt();
        while(range > 0){
            System.out.println("Current count: " + range);
            treeSet.add(scanner.nextInt());
        }

        System.out.println("Treeset stores data in increasing order");

    }
}
