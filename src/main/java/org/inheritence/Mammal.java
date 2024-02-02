package org.inheritence;

public abstract class Mammal extends Animal{
    public Mammal(String type, int eyes, int legs, int hands) {
        super(type, eyes, legs, hands);
    }

    public abstract void walk();
}
