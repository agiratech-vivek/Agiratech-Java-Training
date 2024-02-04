package org.collection;

import java.util.List;

public class BookMyShow {
    private List<City> cities;

    public BookMyShow() {
    }

    public BookMyShow(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
