package org.collectionexample.treemapexample;

import java.util.*;

public class TreeMapExample extends LinkedHashMap<String, Employee>{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Employee> employeeMap = new TreeMap<>();
        while (true) {
            System.out.println("Press 1: Insert new Flyable\n" +
                    "Press 2: Display Employees\n" +
                    "Press 3: Remove employee\n" +
                    "Press 4: Get Last Entry\n" +
                    "Press 5: Get First Entry\n" +
                    "Press 6: Get first few entries\n" +
                    "Press 7: Get last few entries");
            int option = scanner.nextInt();
            if (option == 1) {
//                insertNewEmployee(scanner, employeeMap);
                employeeMap.put(25, new Employee("Vivek", "CEO"));
                employeeMap.put(52, new Employee("Kishore", "SDE"));
                employeeMap.put(22, new Employee("Arun", "SDE2"));
                employeeMap.put(1, new Employee("Deva", "Manager"));
                employeeMap.put(54, new Employee("Musabbir", "HR"));
                employeeMap.put(12, new Employee("Ranjan", "CTO"));
                System.out.println("Data in descending order");
                employeeMap.descendingMap().forEach((integer, employee) -> {
                    System.out.println(integer + ": " + employee.getName() + ", " + employee.getDesignation());
                });
            } else if (option == 2) {
                displayEmployees(employeeMap);
            } else if (option == 3) {
                removeEmployees(scanner, employeeMap);
            } else if (option == 4) {
                getLastEnteredEmployee(employeeMap);
            } else if (option == 5) {
                getFirstEnteredEmployee(employeeMap);
            } else if (option == 6) {
                getTopFewEntries(scanner, employeeMap);
            } else if (option == 7) {
                getLastFewEntries(scanner, employeeMap);
            } else {
                System.out.println("Incorrect input, Please try again");
            }
        }
    }

    private static void getLastFewEntries(Scanner scanner, TreeMap<Integer, Employee> employeeMap) {
        System.out.println("Please specify the employeeId");
        int employeeId = scanner.nextInt();
        SortedMap<Integer, Employee> integerEmployeeSortedMap = employeeMap.tailMap(employeeId);
        integerEmployeeSortedMap.forEach((integer, employee) -> System.out.println(integer + ": " + employee.getName() + ", " + employee.getDesignation()));
    }

    private static void getTopFewEntries(Scanner scanner, TreeMap<Integer, Employee> employeeMap) {
        System.out.println("Please please specify the employeeId");
        int employeeId = scanner.nextInt();
        SortedMap<Integer, Employee> integerEmployeeSortedMap = employeeMap.headMap(employeeId);
        integerEmployeeSortedMap.forEach((integer, employee) -> System.out.println(integer + ": " + employee.getName()));
    }

    private static void getFirstEnteredEmployee(TreeMap<Integer, Employee> employeeMap) {
        Map.Entry<Integer, Employee> firstEntry = employeeMap.firstEntry();
        System.out.println(firstEntry.getKey() + ": " + firstEntry.getValue().getName() + ", " + firstEntry.getValue().getDesignation());
    }

    private static void getLastEnteredEmployee(TreeMap<Integer, Employee> employeeMap) {
        Map.Entry<Integer, Employee> employeeEntry = employeeMap.lastEntry();
        System.out.println(employeeEntry.getKey() + ": " +
                employeeEntry.getValue().getName() + ", " + employeeEntry.getValue().getDesignation());
    }

    private static void removeEmployees(Scanner scanner, TreeMap<Integer, Employee> employeeMap) {
        System.out.println("Please enter the employee id you want to delete");
        int employeeId = scanner.nextInt();
        if (!employeeMap.containsKey(employeeId)) {
            System.out.println("Flyable does not exist");
            return;
        }
        Employee removedEmployee = employeeMap.remove(employeeId);
        System.out.println("Flyable with name: " + removedEmployee.getName() + " has been removed");
        System.out.println();
    }

    private static void displayEmployees(TreeMap<Integer, Employee> employeeMap) {
        for (int employeeId : employeeMap.keySet()) {
            System.out.println("Id: " + employeeId + " Name: " + employeeMap.get(employeeId).getName() + " Designation: " + employeeMap.get(employeeId).getDesignation());
        }
        System.out.println();
    }

    private static void insertNewEmployee(Scanner scanner, TreeMap<Integer, Employee> employeeMap) {
        System.out.print("Flyable id: ");
        int employeeId = scanner.nextInt();
        if (employeeMap.containsKey(employeeId)) {
            System.out.println("Flyable already exists");
            return;
        }
        System.out.print("Flyable name, Designation");
        String[] employeeData = scanner.nextLine().split(", ");
        String name = employeeData[0];
        String designation = employeeData[1];
        employeeMap.put(employeeId, new Employee(name, designation));
        System.out.println();
    }
}
