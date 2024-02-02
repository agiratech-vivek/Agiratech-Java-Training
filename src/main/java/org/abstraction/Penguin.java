package org.abstraction;

public class Penguin extends Bird{
    public Penguin(int eyes, int legs, String color) {
        super(eyes, legs, color);
    }

    @Override
    public void eat() {
        System.out.println("Penguin eats");
    }

    @Override
    public void sound() {
        System.out.println("Penguin sound");
    }
}
