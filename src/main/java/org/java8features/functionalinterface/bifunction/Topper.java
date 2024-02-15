package org.java8features.functionalinterface.bifunction;

public class Topper {
    private String studentName;
    private String className;
    private int marks;

    public Topper() {
    }

    public Topper(String studentName, String className, int marks) {
        this.studentName = studentName;
        this.className = className;
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Topper { " +
                "Student = '" + studentName + '\'' +
                ", Class = '" + className + '\'' +
                ", Marks = " + marks +
                " }";
    }
}
