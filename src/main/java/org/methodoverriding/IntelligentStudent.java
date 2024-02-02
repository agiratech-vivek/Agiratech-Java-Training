package org.methodoverriding;

public class IntelligentStudent extends Student {

    public IntelligentStudent() {
    }

    public IntelligentStudent(String name, String section, String address) {
        super(name, section, address);
    }

    public IntelligentStudent(String name, String section, String address, int rollNo) {
        super(name, section, address, rollNo);
    }

    @Override
    public void studentDetails(){
        System.out.println("This is an intelligent student");
        System.out.println(super.getName() + " " + super.getAddress() + " " + super.getSection() + " " + super.getRollNo());
    }
}
