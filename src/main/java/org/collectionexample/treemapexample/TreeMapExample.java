package org.collectionexample.treemapexample;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Employee> employeeMap = new TreeMap<>();
        while(true){
            System.out.println("Press 1: Insert new Employee\nPress 2: Display Employees\nPress 3: Remove employee\nPress 4: Exit");
            int option = scanner.nextInt();
            if(option == 1){
                System.out.print("Employee id: ");
                int employeeId = scanner.nextInt();
                if(employeeMap.containsKey(employeeId)){
                    System.out.println("Employee already exists");
                    continue;
                }
                System.out.print("Employee name: ");
                String name = scanner.next();
                System.out.print("Designation: ");
                String designation = scanner.next();
                employeeMap.put(employeeId, new Employee(name, designation));
                System.out.println();
            } else if(option == 2){
                for(int employeeId : employeeMap.keySet()){
                    System.out.println("Id: " + employeeId + " Name: " + employeeMap.get(employeeId).getName() + " Designation: " + employeeMap.get(employeeId).getDesignation());
                }
                System.out.println();
            } else if(option == 3){
                System.out.println("Please enter the employee id you want to delete");
                int employeeId = scanner.nextInt();
                if(!employeeMap.containsKey(employeeId)){
                    System.out.println("Employee does not exist");
                    continue;
                }
                Employee removedEmployee = employeeMap.remove(employeeId);
                System.out.println("Employee with name: " + removedEmployee.getName() + " has been removed");
                System.out.println();
            } else if (option == 4) {
                break;
            } else{
                System.out.println("Incorrect input, Please try again");
            }
        }
    }
}
