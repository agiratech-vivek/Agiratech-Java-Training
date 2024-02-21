package org.java8features.streams.multiplestreamsfilter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MultipleStreamsFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();
        while (true) {
            System.out.println("Press 1: Insert Dummy Data\nPress 2: Get Max Salary Employee" +
                    "\nPress 3: Get Employees based on designation\nPress 4: Get Employees based on department" +
                    "\nPress 5: Change employee department and designation\nPress 6: Update salary\nPress 7: Update Address" +
                    "\nPress 8: Get total employee count based on department\nPress 9: Update employee id\10Press 10: Parallel Stream demo\nPress 11: Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                employeeList = DummyEmployees.insertDummyData();
                Random random = new Random();
                employeeList.parallelStream().forEach(employee -> employee.setAge(random.nextInt(39) + 22));
            } else if (option == 2) {
                getMaxSalaryEmployee(employeeList);
            } else if (option == 3) {
                getEmployeesOnDesignation(employeeList, scanner);
            } else if (option == 4) {
                getEmployeesOnDepartment(employeeList, scanner);
            } else if (option == 5) {
                updateEmployeeDesignation(employeeList, scanner);
            } else if (option == 6) {
                updateSalary(employeeList, scanner);
            } else if (option == 7) {
                updateAddress(employeeList, scanner);
            } else if (option == 8) {
                getTotalEmployeeCount(employeeList, scanner);
            } else if (option == 9) {
                updateEmployeeId(employeeList);
            } else if (option == 10) {
                parallelStreamDemo(employeeList);
            } else if (option == 11) {
                filterDataOnMultipleConditions(employeeList, scanner);
            } else {
                break;
            }
        }
    }

    private static void filterDataOnMultipleConditions(List<Employee> employeeList, Scanner scanner) {
        System.out.println("Please insert the Department");
        String department = scanner.nextLine();
        System.out.println("Please insert salary range");
        System.out.print("From Salary: ");
        int fromSalary = scanner.nextInt();
        System.out.print("To Salary: ");
        int toSalary = scanner.nextInt();

    }

    private static void parallelStreamDemo(List<Employee> employeeList) {
        employeeList.parallelStream()
                .forEach(employee -> System.out.println(employee.getName() + " is executed by " + Thread.currentThread().getName()));
    }

    private static void updateAddress(List<Employee> employeeList, Scanner scanner) {
        System.out.println("Update employee address");
        System.out.print("Employee id: ");
        int id = scanner.nextInt();
        Optional<Employee> employeeOptional = employeeList.stream().filter(employee -> employee.getId() == id).findFirst();
        if(employeeOptional.isPresent()){
            System.out.println("Current address: " + employeeOptional.get().getAddress());
            System.out.print("New address: ");
            String newAddress = scanner.nextLine();
            employeeList.stream()
                    .filter(employee -> employee.getId() == id)
                    .peek(employee -> employee.setAddress(newAddress));
            System.out.println("Address updated");
            return;
        }
        System.out.println("Employee not found with id: " + id);
    }

    private static void updateSalary(List<Employee> employeeList, Scanner scanner) {
        System.out.println("Update employee salary");
        int id = scanner.nextInt();
        Optional<Employee> employeeOptional = employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findAny();
        if(employeeOptional.isPresent()){
            System.out.println(employeeOptional.get().getName() + " current salary is " + employeeOptional.get().getSalary());
            System.out.println("Please insert the new salary");
            int salary = scanner.nextInt();
            Optional<Integer> employeeSalary = employeeList.stream()
                    .filter(employee -> employee.getId() == employeeOptional.get().getId())
                    .peek(employee -> employee.setSalary(salary)).map(employee -> employee.getSalary()).findAny();
            System.out.println(employeeOptional.get().getName() + " salary has been updated to: " + employeeSalary.get());
            return;
        }
        System.out.println("Employee not found with id: " + id);
    }

    private static void updateEmployeeId(List<Employee> employeeList) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        employeeList.parallelStream()
                .peek(employee -> {
                    employee.setId(atomicInteger.getAndIncrement());
                })
                .limit(10)
                .sorted(Comparator.comparing(Employee::getId))
                .forEachOrdered(employee -> System.out.println(employee.printEmployeeWithId()));
    }

    private static void getTotalEmployeeCount(List<Employee> employeeList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("This company has total " + employeeList.stream().count() + " employees.");
        System.out.print("Please insert the department name: ");
        String department = scanner.nextLine();
        long countForDepartment = employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .count();
        System.out.println(department + " has " + countForDepartment + " employees.");
    }

    private static void updateEmployeeDesignation(List<Employee> employeeList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please mention the Department");
        String department = scanner.nextLine();
        System.out.println("Please mention the salary range");
        System.out.print("Salary from: ");
        int fromSalary = scanner.nextInt();
        System.out.print("Salary to: ");
        int toSalary = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please mention the designation");
        String designation = scanner.nextLine();
        employeeList.stream()
                .filter(employee -> employee.getDepartment().equals(department) && employee.getSalary() >= fromSalary && employee.getSalary() < toSalary)
                .peek(employee -> employee.setDesignation(designation))
                .forEach(employee -> System.out.println(employee.getName() + " designation has been updated to " + employee.getDesignation()));
    }

    private static void getEmployeesOnDepartment(List<Employee> employeeList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please enter the department");
        String department = scanner.nextLine();
        List<String> employeeStream = employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
        employeeStream.forEach(System.out::println);
    }

    private static void getEmployeesOnDesignation(List<Employee> employeeList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please insert the designation");
        String designation = scanner.nextLine();
        employeeList.parallelStream()
                .filter(employee -> employee.getDesignation().equals(designation))
                .forEach(System.out::println);
    }

    public static void getMaxSalaryEmployee(List<Employee> employeeList){
        Optional<Employee> highestSalaryEmployee = employeeList.stream().reduce((employee, employee2) -> employee.getSalary() > employee2.getSalary() ? employee : employee2);
        highestSalaryEmployee.ifPresent(System.out::println);
    }
}
