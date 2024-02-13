package org.java8features.functionalinterface.supplier;

import java.util.function.Supplier;

public class Dice implements Supplier<Integer> {
    @Override
    public Integer get() {
        return (int) (Math.round(Math.random() * 100) % 6) + 1;
    }
}
