package org.abstraction;

public abstract class Bird {
    private int eyes;
    private int legs;
    private String color;

    public Bird(int eyes, int legs, String color) {
        this.eyes = eyes;
        this.legs = legs;
        this.color = color;
    }

    abstract void eat();
    abstract void sound();
}
