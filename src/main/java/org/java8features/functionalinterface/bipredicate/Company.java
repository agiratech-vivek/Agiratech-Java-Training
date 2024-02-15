package org.java8features.functionalinterface.bipredicate;

import java.time.LocalDate;

public class Company {
    private String name;
    private String city;
    private LocalDate founded;
    private boolean isCompanyRegistered;

    public Company(String name, String city, LocalDate founded, String isCompanyRegistered) {
        this.name = name;
        this.city = city;
        this.founded = founded;
        this.isCompanyRegistered = isCompanyRegistered.equalsIgnoreCase("Y");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public void setFounded(LocalDate founded) {
        this.founded = founded;
    }

    public boolean isCompanyRegistered() {
        return isCompanyRegistered;
    }

    public void setCompanyRegistered(boolean companyRegistered) {
        isCompanyRegistered = companyRegistered;
    }

    @Override
    public String toString() {
        return "Company { " +
                "Name = '" + name + '\'' +
                ", City = '" + city + '\'' +
                ", Founded = " + founded +
                ", Registered = " + isCompanyRegistered +
                " }";
    }
}
