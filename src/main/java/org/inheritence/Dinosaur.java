package org.inheritence;

public class Dinosaur extends Reptile{
    public Dinosaur(String type, int eyes, int legs, int hands) {
        super(type, eyes, legs, hands);
    }

    @Override
    public void eat() {
        System.out.println(this.getType() + " eats.");
    }

    @Override
    public void sleep() {
        System.out.println(this.getType() + " sleeps.");
    }

    @Override
    public void hibernate() {
        System.out.println(this.getType() + " hibernates.");
    }
}
