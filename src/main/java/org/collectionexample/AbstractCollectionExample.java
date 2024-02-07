package org.collectionexample;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Scanner;

public class AbstractCollectionExample extends AbstractCollection<String> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AbstractCollection<String> carShop = new AbstractCollectionExample();
//        carShop.
        while(true) {
            System.out.println("Welcome to car shop, here you can add a car but cannot modify the shop items");
            System.out.println("Press 1 to add a car name(throws exception)\nPress 2 to remove a car (throws exception)\nPress 3 to show all cars\nPress 4 to exit");

            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Please enter a car name");
                String carName = scanner.next();
                carShop.add(carName);
            } else if (option == 2) {
                try {
                    System.out.println("Please enter car you want to remove");
                    carShop.remove(scanner.next());
                } catch (UnsupportedOperationException unsupportedOperationException) {
                    System.out.println(unsupportedOperationException.toString());
                }
            } else if (option == 3) {
                System.out.println(carShop.toString());
            } else if (option == 4) {
                System.out.println("Thank you for your time");
                break;
            }
        }
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
