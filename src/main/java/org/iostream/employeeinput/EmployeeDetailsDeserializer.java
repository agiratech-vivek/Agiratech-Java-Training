package org.iostream.employeeinput;

import org.iostream.employeeoutput.EmployeeDetails;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class EmployeeDetailsDeserializer {
    public static void main(String[] args) {
        String employeeDetailsInputFile = "/home/agira/IdeaProjects/firstproject/src/main/java/org/iostream/employeeinput/EmployeeDetails.txt";
        ObjectInputStream employeeObjectInputStream = null;
        try{
            employeeObjectInputStream = new ObjectInputStream(new FileInputStream(employeeDetailsInputFile));
            List<EmployeeDetails> employeeDetailsList = (List<EmployeeDetails>) employeeObjectInputStream.readObject();
            employeeDetailsList.forEach(employee -> {
                System.out.println("Employee Id: " + employee.getEmployeeId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Designation: " + employee.getDesignation());
                System.out.println("Attendance Sheet: " + employee.getAttendanceSheet().toString());
                System.out.println();
            });

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.toString());
        } catch (IOException ioException) {
            System.out.println(ioException.toString());
        } catch (Exception exception){
            System.out.println(exception.toString());
        } finally {
            try {
                employeeObjectInputStream.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getCause().toString());
            }
        }
    }
}
