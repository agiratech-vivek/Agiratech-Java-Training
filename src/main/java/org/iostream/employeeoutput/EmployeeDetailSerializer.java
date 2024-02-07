package org.iostream.employeeoutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDetailSerializer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String employeeOutputFile = "/home/agira/IdeaProjects/firstproject/src/main/java/org/iostream/employeeinput/EmployeeDetails.txt";
        try {
            ObjectOutputStream employeeObjectOutputStream = new ObjectOutputStream(new FileOutputStream(employeeOutputFile));
            List<EmployeeDetails> employeeDetailsList = new LinkedList<>();
            System.out.println("Please specify the number of employees you want to add");
            int employeeCount = scanner.nextInt();
            while (employeeCount-- > 0) {
                EmployeeDetails employeeDetails = getEmployeeDetails(scanner);
                System.out.println("Kindly specify the number of days you to want to insert attendance");
                int days = scanner.nextInt();
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
                employeeDetailsList.add(employeeDetails);
            }
            employeeObjectOutputStream.writeObject(employeeDetailsList);
            employeeObjectOutputStream.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getCause().toString());
        } catch (IOException ioException) {
            System.out.println(ioException.getCause().toString());
        } catch (Exception exception) {
            System.out.println(exception.getCause().toString());
        }
    }

    private static EmployeeDetails getEmployeeDetails(Scanner scanner) {
        System.out.println("Please provide the employee details");
        System.out.print("Name: ");
        String employeeName = scanner.next();
        System.out.print("Designation: ");
        String designation = scanner.next();
        System.out.print("Employee Id: ");
        scanner.nextLine();
        String employeeId = scanner.next();
        EmployeeDetails employeeDetails = new EmployeeDetails(employeeName, designation, employeeId);
        return employeeDetails;
    }
}
