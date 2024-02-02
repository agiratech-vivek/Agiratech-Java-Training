package org.calculator;

public class ShortCalculator implements Calculator<Short>{
    @Override
    public Short sum(Short firstNumber, Short secondNumber) {
        return (short) (firstNumber + secondNumber);
    }

    @Override
    public Short subtract(Short firstNumber, Short secondNumber) {
        return (short) (firstNumber - secondNumber);
    }

    @Override
    public Short multiply(Short firstNumber, Short secondNumber) {
        return (short) (firstNumber * secondNumber);
    }

    @Override
    public Short divide(Short firstNumber, Short secondNumber) {
        return (short) (firstNumber / secondNumber);
    }

    @Override
    public Short modulus(Short firstNumber, Short secondNumber) {
        return (short) (firstNumber % secondNumber);
    }

}
