package org.java8features.functionalinterface.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Class implements Consumer<Student> {

    Map<Long, Student> studentMap = new HashMap<>();
    @Override
    public void accept(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Address: "+ student.getAddress());
        System.out.println("Class: "+ student.getClassName());
    }
}
