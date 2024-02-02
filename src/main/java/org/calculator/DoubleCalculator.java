package org.calculator;

public class DoubleCalculator implements Calculator<Double>{

    public DoubleCalculator() {
    }

    @Override
    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public Double subtract(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public Double divide(Double firstNumber, Double secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public Double modulus(Double firstNumber, Double secondNumber) {
        return firstNumber % secondNumber;
    }
}
