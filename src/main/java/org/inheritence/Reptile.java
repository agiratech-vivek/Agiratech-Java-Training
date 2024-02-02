package org.inheritence;

public abstract class Reptile extends Animal{
    public Reptile(String type, int eyes, int legs, int hands) {
        super(type, eyes, legs, hands);
    }

    public abstract void hibernate();
}
