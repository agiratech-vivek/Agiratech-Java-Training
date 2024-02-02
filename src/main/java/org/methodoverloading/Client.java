package org.methodoverloading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        Student firstStudent = new Student();
        Student secondStudent = new Student("Vivek", "A", "Bangalore");
        Student thirdStudent = new Student("Nishant", "B", "Delhi", 12);
    }
}
