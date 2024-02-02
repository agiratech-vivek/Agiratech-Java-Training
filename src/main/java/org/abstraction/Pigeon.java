package org.abstraction;

public class Pigeon extends Bird implements Flyable{
    public Pigeon(int eyes, int legs, String color) {
        super(eyes, legs, color);
    }
    @Override
    public void eat() {
        System.out.println("Pigeon eats");
    }

    @Override
    public void sound() {
        System.out.println("Pigeon Sound");
    }

    @Override
    public void fly() {
        System.out.println("Pigeon fly");
    }
}
