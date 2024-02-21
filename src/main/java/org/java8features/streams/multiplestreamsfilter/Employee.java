package org.java8features.streams.multiplestreamsfilter;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private String department;
    private int salary;
    private int age;
    private String address;

    public Employee(String name, String designation, String department, int salary, String address) {
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
        this.address = address;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getDesignation() {
        return designation;
    }

    public void setDesignation(java.lang.String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public java.lang.String getAddress() {
        return address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " Employee {" +
                "Name = '" + name + '\'' +
                ", Age = '" + age + '\'' +
                ", Designation = '" + designation + '\'' +
                ", Department = '" + department + '\'' +
                ", Salary = " + salary +
                ", Address = '" + address + '\'' +
                " }";
    }

    public String printEmployeeWithId(){
        return "Employee { Id: " + id + ", Name: " + name + " Designation: " + designation + " }";
    }
}
