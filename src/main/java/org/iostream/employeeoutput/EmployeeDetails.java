package org.iostream.employeeoutput;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String designation;
    private String employeeId;
    private Map<Integer, Attendance> attendanceSheet;

    public EmployeeDetails(String name, String designation, String employeeId) {
        this.name = name;
        this.designation = designation;
        this.employeeId = employeeId;
        this.attendanceSheet = new HashMap<>(31);
        for(int dayCount = 1; dayCount <= 31; dayCount++){
            attendanceSheet.put(dayCount, Attendance.ABSENT);
        }
    }

    public EmployeeDetails() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Map<Integer, Attendance> getAttendanceSheet() {
        return attendanceSheet;
    }

    public void setAttendanceSheet(Map<Integer, Attendance> attendanceSheet) {
        this.attendanceSheet = attendanceSheet;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", attendanceSheet=" + attendanceSheet +
                '}';
    }
}
