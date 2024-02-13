package org.java8features.lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class SchoolRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Please enter the student count");
        int studentCountInput = scanner.nextInt();
        String studentName = "Vivek";
        School xyzSchool = studentCount -> studentName + " is in " + SchoolName.SCHOOL_NAME + " which has " + studentCount + " students.";
        out.println(xyzSchool.studentCountHelper(studentCountInput));

        List<Integer> list = Arrays.asList(1,2,3,5,6);

        List<Integer> collect = list.stream().map(num -> num * 2).collect(Collectors.toList());

    }
}