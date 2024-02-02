package org.calculator;

public class FloatCalculator implements Calculator<Float>{
    @Override
    public Float sum(Float firstNumber, Float secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public Float subtract(Float firstNumber, Float secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public Float multiply(Float firstNumber, Float secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public Float divide(Float firstNumber, Float secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public Float modulus(Float firstNumber, Float secondNumber) {
        return firstNumber % secondNumber;
    }
}
