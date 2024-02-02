package org.inheritence;

public abstract class Animal {
    private String type;
    private int eyes;
    private int legs;
    private int hands;
    public Animal(String type, int eyes, int legs, int hands) {
        this.type = type;
        this.eyes = eyes;
        this.legs = legs;
        this.hands = hands;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getHands() {
        return hands;
    }

    public void setHands(int hands) {
        this.hands = hands;
    }

    public abstract void eat();
    public abstract void sleep();
}
