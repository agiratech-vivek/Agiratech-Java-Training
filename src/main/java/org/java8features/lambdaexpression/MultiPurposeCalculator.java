package org.java8features.lambdaexpression;

@FunctionalInterface
public interface MultiPurposeCalculator {
    int calculate(int firstNumber, int secondNumber) throws ArithmeticException;
}
