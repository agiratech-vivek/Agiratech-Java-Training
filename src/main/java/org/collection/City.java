package org.collection;

import java.util.List;

public class City {
    private String name;
    private List<Theatre> theatres;

    public City() {
    }

    public City(String name, List<Theatre> theatres) {
        this.name = name;
        this.theatres = theatres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }
}
