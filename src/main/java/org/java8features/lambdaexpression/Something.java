package org.java8features.lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Something implements Supplier<Integer> {

    List<Integer> list = Arrays.asList(1,2,3,5,6);

    @Override
    public Integer get() {
        return list.get(0);
    }

}
