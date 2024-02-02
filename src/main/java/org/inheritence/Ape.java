package org.inheritence;

public class Ape extends Mammal{

    public Ape(String type, int eyes, int legs, int hands) {
        super(type, eyes, legs, hands);
    }

    @Override
    public void eat() {
        System.out.println("Ape eats");
    }

    @Override
    public void sleep() {
        System.out.println("Ape sleeps");
    }

    @Override
    public void walk() {
        System.out.println("Ape walk on 4 limbs");
    }
}
