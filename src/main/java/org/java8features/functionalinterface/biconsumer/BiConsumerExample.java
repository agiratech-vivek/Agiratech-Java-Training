package org.java8features.functionalinterface.biconsumer;

import java.util.*;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiConsumer<Map<Role, List<User>>, User> addUserPrivileges = getMapUserBiConsumer();
        Map<Role, List<User>> userRoleMap = getRoleListMap();
        while(true) {
            System.out.println("Press 1: Insert Dummy data of users\nPress 2: Insert User data\nPress 3: Display Users as per privileges\nPress 4: Exit");
            int option = scanner.nextInt();
            if(option == 1){
                addDummyUsers(addUserPrivileges, userRoleMap);
            } else if(option == 2) {
                insertUser(scanner, addUserPrivileges, userRoleMap);
            } else if(option == 3) {
                displayUsers(userRoleMap);
            } else {
                break;
            }
        }
    }

    private static void displayUsers(Map<Role, List<User>> userRoleMap) {
        System.out.println("Users with their privileges");
        userRoleMap.forEach((role, users) -> {
            System.out.println();
            System.out.println("******" + role + "******");
            users.forEach(user -> System.out.println(user.getName()));
        });
        System.out.println();
    }

    private static void insertUser(Scanner scanner, BiConsumer<Map<Role, List<User>>, User> addUserPrivileges, Map<Role, List<User>> userRoleMap) {
        System.out.println("Please insert the number of users you want to insert");
        int range = scanner.nextInt();
        while (range-- > 0) {
            System.out.println("Name, Role (0: Admin, 1: User, 2: Guest)");
            String[] userData = scanner.nextLine().split(", ");
            String userName = userData[0];
            Role role = Role.getRole(Integer.parseInt(userData[1]));
            User user = new User(userData[0], role);
            addUserPrivileges.accept(userRoleMap, user);
        }
    }

    private static void addDummyUsers(BiConsumer<Map<Role, List<User>>, User> addUserPrivileges, Map<Role, List<User>> userRoleMap) {
        addUserPrivileges.accept(userRoleMap, new User("Vivek", Role.ADMIN));
        addUserPrivileges.accept(userRoleMap, new User("Ranjan", Role.ADMIN));
        addUserPrivileges.accept(userRoleMap, new User("Kishore", Role.USER));
        addUserPrivileges.accept(userRoleMap, new User("Deva", Role.GUEST));
        addUserPrivileges.accept(userRoleMap, new User("Harshini", Role.USER));
        addUserPrivileges.accept(userRoleMap, new User("Arun", Role.USER));
        addUserPrivileges.accept(userRoleMap, new User("Harsha", Role.USER));
        addUserPrivileges.accept(userRoleMap, new User("Pragati", Role.GUEST));
        addUserPrivileges.accept(userRoleMap, new User("Saurabh", Role.GUEST));
        addUserPrivileges.accept(userRoleMap, new User("Gaurav", Role.USER));
        addUserPrivileges.accept(userRoleMap, new User("Nishant", Role.ADMIN));
    }

    private static BiConsumer<Map<Role, List<User>>, User> getMapUserBiConsumer() {
        BiConsumer<Map<Role, List<User>>, User> addUserPrivileges = (userMap, user) -> {
            if(user.getRole() == Role.USER){
                List<User> users = userMap.get(Role.USER);
                users.add(user);
                userMap.put(Role.USER, users);
            } else if (user.getRole() == Role.ADMIN){
                List<User> users = userMap.get(Role.ADMIN);
                users.add(user);
                userMap.put(Role.ADMIN, users);
            } else if(user.getRole() == Role.GUEST){
                List<User> users = userMap.get(Role.GUEST);
                users.add(user);
                userMap.put(Role.GUEST, users);
            }
        };
        return addUserPrivileges;
    }

    private static Map<Role, List<User>> getRoleListMap() {
        Map<Role, List<User>> userRoleMap = new HashMap<>();
        userRoleMap.put(Role.USER, new ArrayList<>());
        userRoleMap.put(Role.ADMIN, new ArrayList<>());
        userRoleMap.put(Role.GUEST, new ArrayList<>());
        return userRoleMap;
    }
}
