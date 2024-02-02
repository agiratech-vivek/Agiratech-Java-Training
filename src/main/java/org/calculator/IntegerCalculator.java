package org.calculator;

public class IntegerCalculator implements Calculator<Integer>{

    private int firstNumber;
    private int secondNumber;

    public IntegerCalculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public Integer sum(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public Integer subtract(Integer firstNumber, Integer secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public Integer multiply(Integer firstNumber, Integer secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public Integer divide(Integer firstNumber, Integer secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public Integer modulus(Integer firstNumber, Integer secondNumber) {
        return firstNumber % secondNumber;
    }

}
