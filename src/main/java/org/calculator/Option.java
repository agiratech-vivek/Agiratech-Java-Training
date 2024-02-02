package org.calculator;

public enum Option {
    INTEGER_CALCULATOR((byte) 1),
    FLOAT_CALCULATOR((byte) 2),
    DOUBLE_CALCULATOR((byte) 3),
    SHORT_CALCULATOR((byte) 4),
    LONG_CALCULATOR((byte) 5),
    QUIT_CALCULATOR((byte) 6);
    private final byte value;
    Option(byte value) {
        this.value = value;
    }
    public byte getValue(){
        return this.value;
    }
}
