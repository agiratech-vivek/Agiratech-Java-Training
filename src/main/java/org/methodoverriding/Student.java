package org.methodoverriding;

public class Student {
    private String name;
    private String section;
    private String address;
    private int rollNo;

    Student() {

    }

    Student(String name, String section, String address){
        this.name = name;
        this.section = section;
        this.address = address;
    }

    Student(String name, String section, String address, int rollNo){
        this(name, section, address);
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void studentDetails(){
        System.out.println(name + " " + section + " " + address + " " + rollNo);
    }
}
