package org.java8features.functionalinterface.function;

public class Address {
    private String area;
    private int pinCode;

    public Address(String area, int pinCode) {
        this.area = area;
        this.pinCode = pinCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
