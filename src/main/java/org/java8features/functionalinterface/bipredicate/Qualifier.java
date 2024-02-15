package org.java8features.functionalinterface.bipredicate;

import java.time.LocalDate;

public class Qualifier {
    private LocalDate date;
    private String city;

    public Qualifier(LocalDate date, String city) {
        this.date = date;
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
