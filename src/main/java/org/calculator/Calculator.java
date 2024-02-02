package org.calculator;

public interface Calculator<T> {
    public T sum(T firstNumber, T secondNumber);
    public T subtract(T firstNumber, T secondNumber);
    public T multiply(T firstNumber, T secondNumber);
    public T divide(T firstNumber, T secondNumber);
    public T modulus(T firstNumber, T secondNumber);

    default void printAll(T firstNumber, T secondNumber) {
        System.out.printf("%s + %s = %s%n", firstNumber, secondNumber, sum(firstNumber, secondNumber));
        System.out.printf("%s - %s = %s%n", firstNumber, secondNumber, subtract(firstNumber, secondNumber));
        System.out.printf("%s * %s = %s%n", firstNumber, secondNumber, multiply(firstNumber, secondNumber));
        System.out.printf("%s %% %s = %s%n", firstNumber, secondNumber, modulus(firstNumber, secondNumber));
        System.out.printf("%s / %s = %s%n", firstNumber, secondNumber, divide(firstNumber, secondNumber));
        System.out.println();
    }
}
