package org.java8features.functionalinterface.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FunctionRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userPinCode = 600089;
        Function<Address, Boolean> nearestMetro = (address) -> {
            if(userPinCode - address.getPinCode() >= 1 || userPinCode - address.getPinCode() <= -1){
                return false;
            }
            return true;
        };
        List<Address> addressList = new ArrayList<>();
        while(true){
            System.out.println("Press 1: Insert Dummy data\nPress 2: Insert data manually\nPress 3: Check nearest metro\nPress 4: Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                addressList.add(new Address("Alandur", 600032));
                addressList.add(new Address("Guindy", 600016));
                addressList.add(new Address("Ekkatuthangal", 600066));
                addressList.add(new Address("Porur", 600025));
                addressList.add(new Address("Besent Nagar", 600012));
                addressList.add(new Address("Ayanavaram", 600022));
                addressList.add(new Address("Kodambakkam", 600089));
                addressList.add(new Address("Ashok Nagar", 600052));
                addressList.add(new Address("Nehru Park", 600015));
            } else if (option == 2) {
                System.out.println("Address, Pin-code");
                String[] addressDetail = scanner.nextLine().split(", ");
                addressList.add(new Address(addressDetail[0], Integer.parseInt(addressDetail[1])));
            } else if (option == 3) {
                addressList.forEach(address -> {
                    if (nearestMetro.apply(address)) {
                        System.out.println(address.getArea() + " metro is nearest to your location.");
                    }
                });
            } else {
                break;
            }
        }
    }
}
