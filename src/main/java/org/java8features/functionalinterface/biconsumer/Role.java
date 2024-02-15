package org.java8features.functionalinterface.biconsumer;

public enum Role {
    ADMIN(0),
    USER(1),
    GUEST(2);
    private int value;

    Role(int value) {
        this.value = value;
    }
    public static Role getRole(int value) {
        if (value == 0) return ADMIN;
        else if (value == 1) return USER;
        else return GUEST;
    }
}
