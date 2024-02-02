package org.boxing;

public class AutoBoxing {
    public static void main(String[] args) {
        Integer intWrapper = 78;
        Long longWrapper = 89L;
        Float floatWrapper = 2.4f;
        Double doubleWrapper = 2.4443d;
        Short shortWrapper = 2324;
        Byte byteWrapper = 125;
        Character characterWrapper = 'A';

        //This is how compiler does autoboxing
        Integer intWrapperExplicit = Integer.valueOf(78);
        Long longWrapperExplicit = Long.valueOf(89L);
        Float floatWrapperExplicit = Float.valueOf(2.4f);
        Double doubleWrapperExplicit = Double.valueOf(2.4443d);
        Short shortWrapperExplicit = Short.valueOf((short) 2324);
        Byte byteWrapperExplicit = Byte.valueOf((byte) 125);
        Character characterWrapperExplicit = Character.valueOf('A');

        System.out.println("Implicit AutoBoxing");
        System.out.println("Integer: " + intWrapper);
        System.out.println("Long: " + longWrapper);
        System.out.println("Float: " + floatWrapper);
        System.out.println("Double: " + doubleWrapper);
        System.out.println("Short: " + shortWrapper);
        System.out.println("Byte: " + byteWrapper);
        System.out.println("Character: " + characterWrapper);
        System.out.println();
        System.out.println("Explicit AutoBoxing");
        System.out.println("Integer: " + intWrapperExplicit);
        System.out.println("Long: " + longWrapperExplicit);
        System.out.println("Float: " + floatWrapperExplicit);
        System.out.println("Double: " + doubleWrapperExplicit);
        System.out.println("Short: " + shortWrapperExplicit);
        System.out.println("Byte: " + byteWrapperExplicit);
        System.out.println("Character: " + characterWrapperExplicit);
    }
}
