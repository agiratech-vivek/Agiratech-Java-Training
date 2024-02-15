package org.java8features.functionalinterface.bifunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class BiFunctionRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiFunction<Class, List<Student>, Topper> getTopperList = (classObject, studentList) -> {
            int maxMarks = Integer.MIN_VALUE;
            Topper topper = new Topper();
            for (Student student : studentList) {
                if (maxMarks < student.getMarks()) {
                    maxMarks = student.getMarks();
                    topper.setStudentName(student.getName());
                    topper.setClassName(classObject.getName());
                    topper.setMarks(student.getMarks());
                }
            }
            return topper;
        };
        List<Student> studentList = new ArrayList<>();
        List<Topper> topperList = new ArrayList<>();
        while(true) {
            System.out.println("Press 1: Insert dummy data\nPress 2: Insert data manually\nPress 3: Get topper student\nPress 4: Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                addDummyStudent(studentList);
            } else if (option == 2) {
                addStudent(studentList, scanner);
            } else if (option == 3) {
                Topper topper = getTopperList.apply(new Class("Xth Class"), studentList);
                System.out.println(topper.toString());
            } else {
                break;
            }
        }
    }

    private static void addDummyStudent(List<Student> studentList){
        studentList.add(new Student("Vivek", 50));
        studentList.add(new Student("Ranjan", 60));
        studentList.add(new Student("Nidhi", 50));
        studentList.add(new Student("Kishore", 80));
        studentList.add(new Student("Deva", 88));
        studentList.add(new Student("Musabbir", 40));
    }
    private static void addStudent(List<Student> studentList, Scanner scanner){
        System.out.println("Please insert the student details");
        System.out.println("Student Name, Marks");
        String[] studentData = scanner.nextLine().split(", ");
        studentList.add(new Student(studentData[0], Integer.parseInt(studentData[1])));
    }
}
