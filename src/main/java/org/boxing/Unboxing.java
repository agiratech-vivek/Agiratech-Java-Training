package org.boxing;

public class Unboxing {
    public static void main(String[] args) {
        Integer intWrapper = 78;
        Long longWrapper = 89L;
        Float floatWrapper = 2.4f;
        Double doubleWrapper = 2.4443d;
        Short shortWrapper = 2324;
        Byte byteWrapper = 125;
        Character characterWrapper = 'A';

        // Unboxing
        int intPrimitive = intWrapper;
        long longPrimitive = longWrapper;
        float floatPrimitive = floatWrapper;
        double doublePrimitive = doubleWrapper;
        short shortPrimitive = shortWrapper;
        byte bytePrimitive = byteWrapper;
        char charPrimitive = characterWrapper;

        // How compiler does the unboxing behind the scenes
        int intPrimitiveExplicit = intWrapper.intValue();
        long longPrimitiveExplicit = longWrapper.longValue();
        float floatPrimitiveExplicit = floatWrapper.floatValue();
        double doublePrimitiveExplicit = doubleWrapper.doubleValue();
        short shortPrimitiveExplicit = shortWrapper.shortValue();
        byte bytePrimitiveExplicit = byteWrapper.byteValue();
        char charPrimitiveExplicit = characterWrapper.charValue();

        System.out.println("int primitive: " + intPrimitive);
        System.out.println("long primitive: " + longPrimitive);
        System.out.println("float primitive: " + floatPrimitive);
        System.out.println("double primitive: " + doublePrimitive);
        System.out.println("short primitive: " + shortPrimitive);
        System.out.println("byte primitive: " + bytePrimitive);
        System.out.println("char primitive: " + charPrimitive);
    }
}
