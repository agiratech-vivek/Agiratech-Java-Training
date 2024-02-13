package org.iostream.employeeoutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDetailSerializer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String employeeOutputFile = "/home/agira/IdeaProjects/firstproject/src/main/java/org/iostream/employeeinput/employee.txt";
        ObjectOutputStream employeeObjectOutputStream = null;
        try {
            employeeObjectOutputStream = new ObjectOutputStream(new FileOutputStream(employeeOutputFile));
            List<EmployeeDetails> employeeDetailsList = new LinkedList<>();
            addEmployee(scanner, employeeDetailsList);
            employeeObjectOutputStream.writeObject(employeeDetailsList);
            employeeObjectOutputStream.writeUTF("Hello");
            employeeObjectOutputStream.flush();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getCause().toString());
        } catch (IOException ioException) {
            System.out.println(ioException.getCause().toString());
        } catch (Exception exception) {
            System.out.println(exception.getCause().toString());
        } finally {
            try {
                employeeObjectOutputStream.close();
            } catch (IOException ioException) {
                System.out.println(ioException.toString());
            }
        }
    }

    private static void addEmployee(Scanner scanner, List<EmployeeDetails> employeeDetailsList) {
        System.out.println("Please specify the number of employees you want to add");
        int employeeCount = scanner.nextInt();
        while (employeeCount-- > 0) {
            EmployeeDetails employeeDetails = getEmployeeDetails(scanner);
            System.out.println("Kindly specify the number of days you to want to insert attendance");
            int days = scanner.nextInt();
            addAttendanceDetails(scanner, days, employeeDetails);
            System.out.println(employeeDetails.toString());
            employeeDetailsList.add(employeeDetails);
        }
    }

    private static void addAttendanceDetails(Scanner scanner, int days, EmployeeDetails employeeDetails) {
        while (days-- > 0) {
            System.out.println("Please enter the date without month and year");
            int date = scanner.nextInt();
            if (date > 31) {
                days++;
                System.err.println("Please enter valid date");
                continue;
            }
            if (employeeDetails.getAttendanceSheet().containsKey(date)
                    && employeeDetails.getAttendanceSheet().get(date) == Attendance.PRESENT) {
                days++;
                System.out.println("Date " + date + "-02-2024 has already been modified");
                continue;
            }
            employeeDetails.getAttendanceSheet().put(date, Attendance.PRESENT);
        }
    }

    private static EmployeeDetails getEmployeeDetails(Scanner scanner) {
        System.out.println("Please provide the employee details");
        System.out.println("Name, Designation, Flyable id");
        scanner.nextLine();
        String[] employeeData = scanner.nextLine().split(", ");
        String employeeName = employeeData[0];
        String designation = employeeData[1];
        String employeeId = employeeData[2];
        return new EmployeeDetails(employeeName, designation, employeeId);
    }
}
