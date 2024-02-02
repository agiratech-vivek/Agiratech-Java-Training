package org.inheritence;

public class Wolf extends Mammal{
    public Wolf(String type, int eyes, int legs, int hands) {
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
    public void walk() {
        System.out.println(this.getType() + " walks on " + this.getLegs() + " legs.");
    }

    public void hunt(){
        System.out.println(this.getType() + " hunts.");
    }
}
