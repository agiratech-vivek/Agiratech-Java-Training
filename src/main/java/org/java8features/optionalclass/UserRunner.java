package org.java8features.optionalclass;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class UserRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRepository.addUser(1, new User(1, "Vivek", "1235689"));
        UserRepository.addUser(2, new User(2, "Ranjan", "1235689"));
        UserRepository.addUser(3, new User(3, "Arun", "1235689"));
        UserRepository.addUser(4, new User(4, "Saurabh", "1235689"));
        UserRepository.addUser(5, new User(5, "Deva", "1235689"));
        UserRepository.addUser(6, new User(6, "Harsha", "1235689"));
        UserRepository.addUser(7, new User(7, "Nishant", "1235689"));
        UserRepository.addUser(8, new User(8, "Kishore", "1235689"));
        UserRepository.addUser(9, new User(9, "Harshini", "1235689"));
        UserRepository.addUser(10, new User(10, "Nehal", "1235689"));
        while(true){
            System.out.println("Press 1: Insert new User\nPress 2: Search User using Id\nPress 3: Search user by name");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                addUser(scanner);
            } else if (option == 2) {
                getUserById(scanner);
            } else if (option == 3) {
                getUserByName(scanner);
            } else if (option == 4) {
                break;
            }
        }
    }

    private static void getUserByName(Scanner scanner) {
        System.out.println("Please enter user name");
        String name = scanner.nextLine();
        Optional<User> userByName = UserRepository.getUserByName(name);
        userByName.ifPresent(System.out::println);
    }

    private static void getUserById(Scanner scanner) {
        System.out.println("Please enter user id");
        int userId = scanner.nextInt();
//        Optional<User> userOptional = UserRepository.getUser(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//        } else {
//            System.out.println("User not found with id " + userId);
//        }
        if (UserRepository.getUser(userId) == null){
            System.out.println("not present");
        } else {
            System.out.println();
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.println("Id, User name, Contact");
        String[] userData = scanner.nextLine().split(", ");
        UserRepository.addUser(Integer.parseInt(userData[0]), new User(Integer.parseInt(userData[0]), userData[1], userData[2]));
        System.out.println("New user added");
    }
}
