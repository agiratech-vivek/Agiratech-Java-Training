package org.inheritence;

import java.text.DecimalFormat;

public class AnimalRunner {
    public static void main(String[] args) {
        Ape ape = new Ape("Male", 2, 2, 2);
        ape.eat();
        ape.sleep();
        ape.walk();

        Human human = new Human("Male", 2, 2, 2);
        human.think();
        human.walk();
        human.goToOffice();

        Reptile reptile = new Crocodile("Crocodile", 2, 2, 2);
        reptile.eat();
        reptile.sleep();
        reptile.hibernate();

        Dog dog = new Dog("Golden Retriever", 2, 4, 0);
        dog.eat();
        dog.hunt();
        dog.sleep();
        dog.walk();
    }
}
