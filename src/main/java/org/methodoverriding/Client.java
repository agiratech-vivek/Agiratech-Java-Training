package org.methodoverriding;

public class Client {
    public static void main(String[] args) {
        Student student = new Student("Vivek", "A", "Bangalore", 132);
        student.studentDetails();
    }
}
