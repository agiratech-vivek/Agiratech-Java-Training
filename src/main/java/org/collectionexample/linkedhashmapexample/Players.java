package org.collectionexample.linkedhashmapexample;

public class Players {
    private String name;
    private String carName;

    public Players(String playerName, String carName) {
        this.name = playerName;
        this.carName = carName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
