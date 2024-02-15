package org.java8features.functionalinterface.predicate;

public class Employee {
    private String name;
    private int totalWorkingDays;

    public Employee(String name, int totalWorkingDays) {
        this.name = name;
        this.totalWorkingDays = totalWorkingDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalWorkingDays() {
        return totalWorkingDays;
    }

    public void setTotalWorkingDays(int totalWorkingDays) {
        this.totalWorkingDays = totalWorkingDays;
    }
}
