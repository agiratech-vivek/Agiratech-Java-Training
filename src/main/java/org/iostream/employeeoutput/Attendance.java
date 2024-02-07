package org.iostream.employeeoutput;

public enum Attendance {
    PRESENT((byte)0),
    ABSENT((byte)1);
    private final byte value;

    Attendance(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
