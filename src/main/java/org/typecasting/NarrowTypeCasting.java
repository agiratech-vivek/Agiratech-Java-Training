package org.typecasting;

public class NarrowTypeCasting {
    public static void main(String[] args) {
        double doubleNumber = 12.65513685321d;
        float floatNumber = (float) doubleNumber;
        System.out.println("double number: " + doubleNumber);
        System.out.println("double to float: " + floatNumber);
        System.out.println();
        long longNumber = 25354654601L;
        int integerNumber = (int) longNumber;
        System.out.println("long number: " + longNumber);
        System.out.println("long to int: " + integerNumber);
        System.out.println();
        short shortNumber = 158;
        byte byteNumber = (byte) shortNumber;
        System.out.println("short number: " + shortNumber);
        System.out.println("short to byte: " + byteNumber);
    }
}
