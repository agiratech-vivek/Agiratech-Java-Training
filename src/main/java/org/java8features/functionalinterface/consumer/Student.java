package org.java8features.functionalinterface.consumer;

public class Student {
    private String name;
    private String address;
    private String className;

    public Student(String name, String address, String className) {
        this.name = name;
        this.address = address;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
