package org.test;

interface A{
    default void print(){
        System.out.println("Method of A");
    }
}
interface B extends A  {
    default void print(){
        System.out.println("Method of B");
    }
}

class C implements A,B{
    public void print(){
        //A.super.print();
        B.super.print();
    }
}

public class Main
{
    public static void main(String[] args) {
        C c = new C();
        c.print();
    }
}