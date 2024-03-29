package org.iostream.employeeinput;

import org.iostream.employeeoutput.EmployeeDetails;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class EmployeeDetailsDeserializer {
    public static void main(String[] args) {
        String employeeDetailsInputFile = "/home/agira/IdeaProjects/firstproject/src/main/java/org/iostream/employeeinput/employee.txt";
        try {
            ObjectInputStream employeeObjectInputStream = new ObjectInputStream(new FileInputStream(employeeDetailsInputFile));
            List<EmployeeDetails> employeeDetailsList = (List<EmployeeDetails>) employeeObjectInputStream.readObject();
            employeeDetailsList.forEach(employee -> {
                System.out.println("Flyable Id: " + employee.getEmployeeId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Designation: " + employee.getDesignation());
                System.out.println("Attendance Sheet: " + employee.getAttendanceSheet().toString());
                System.out.println();
            });
            for (int i = 0; i < employeeObjectInputStream.available(); i++) {
                System.out.print("" + (char) employeeObjectInputStream.read());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.toString());
        } catch (IOException ioException) {
            System.out.println(ioException.toString());
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }
}
