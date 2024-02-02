package org.typecasting;

public class WideningTypeCasting {
    public static void main(String[] args) {
        byte byteNumber = 125;
        short shortNumber = byteNumber;
        System.out.println("byte number: " + byteNumber);
        System.out.println("byte to short: " + shortNumber);
        System.out.println();
        int integerNumber = 2135498;
        long longNumber = integerNumber;
        System.out.println("integer number: " + integerNumber);
        System.out.println("integer to long: " + longNumber);
        System.out.println();
        float floatNumber = 1.20f;
        double doubleNumber = floatNumber;
        System.out.println("float number: " + floatNumber);
        System.out.println("float to double: " + doubleNumber);
    }
}
