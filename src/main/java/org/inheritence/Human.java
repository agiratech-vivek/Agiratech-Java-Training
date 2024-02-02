package org.inheritence;

public class Human extends Ape implements LogicalThinking, Work{

    public Human(String type, int eyes, int legs, int hands) {
        super(type, eyes, legs, hands);
    }

    @Override
    public void walk(){
        System.out.println(this.getType() + " walks on " + this.getLegs() + " legs.");
    }

    @Override
    public void think() {
        System.out.println(this.getType() + " can think logically.");
    }

    @Override
    public void goToOffice() {
        System.out.println(this.getType() + " goes to office.");
    }
}
