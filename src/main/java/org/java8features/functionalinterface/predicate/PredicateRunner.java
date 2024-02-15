package org.java8features.functionalinterface.predicate;

import org.java8features.functionalinterface.biconsumer.Role;
import org.java8features.functionalinterface.predicate.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<Employee> giftVacation = employee -> employee.getTotalWorkingDays() > 300;
        List<Employee> employeeList = new ArrayList<>();
        while(true){
            System.out.println("Press 1: Insert dummy data\nPress 2: Insert new employee\nPress 3: Gift Vacation to employees\nPress 4: Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                employeeList.add(new Employee("Vivek", 233));
                employeeList.add(new Employee("Ranjan", 355));
                employeeList.add(new Employee("Kishore", 546));
                employeeList.add(new Employee("Deva", 321));
                employeeList.add(new Employee("Harshini", 330));
                employeeList.add(new Employee("Arun", 200));
                employeeList.add(new Employee("Harsha", 312));
                employeeList.add(new Employee("Pragati", 56));
                employeeList.add(new Employee("Saurabh", 150));
                employeeList.add(new Employee("Gaurav", 250));
                employeeList.add(new Employee("Nishant", 255));
            } else if (option == 2) {
                System.out.println("Employee name, Total working days");
                String[] employeeData = scanner.nextLine().split(", ");
                employeeList.add(new Employee(employeeData[0], Integer.parseInt(employeeData[1])));
            } else if (option == 3) {
                employeeList.forEach(employee -> {
                    if (giftVacation.test(employee)) {
                        System.out.println(employee.getName() + " will get a vacation.");
                    }
                });
            } else if (option == 4) {
                break;
            }
        }
    }
}
