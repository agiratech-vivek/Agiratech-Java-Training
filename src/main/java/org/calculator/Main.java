package org.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.calculator.Option.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Please select the type of operation you want to perform");
                System.out.println("Press 1 : Integer Calculator,\nPress 2: Double Calculator,\nPress 3: Float Calculator,\nPress 4: Short Calculator,\nPress 5: Long Calculator,\nPress 6: Exit");
                byte typeOfOperation = scanner.nextByte();
                if (typeOfOperation == QUIT_CALCULATOR.getValue()) {
                    break;
                }
                selection(typeOfOperation, scanner);
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input");
                break;
            } catch (ArithmeticException arithmeticException) {
                System.err.println(arithmeticException.getMessage() + " not allowed");
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
            Long num1 = 25l;
            Long num2 = 30l;
        }
    }

    public static void selection(byte typeOfOperation, Scanner scanner) {
        if (typeOfOperation == INTEGER_CALCULATOR.getValue()) {
            System.out.println("Enter first number");
            int firstNumber = scanner.nextInt();
            System.out.println("Enter second number");
            int secondNumber = scanner.nextInt();
            Calculator<Integer> calculator = new IntegerCalculator(firstNumber, secondNumber);
            calculator.printAll(firstNumber, secondNumber);
        } else if (typeOfOperation == DOUBLE_CALCULATOR.getValue()) {
            System.out.println("Enter first number");
            double firstNumber = scanner.nextDouble();
            System.out.println("Enter second number");
            double secondNumber = scanner.nextDouble();
            Calculator<Double> calculator = new DoubleCalculator();
            calculator.printAll(firstNumber, secondNumber);
        } else if (typeOfOperation == FLOAT_CALCULATOR.getValue()) {
            System.out.println("Enter first number");
            float firstNumber = scanner.nextFloat();
            System.out.println("Enter second number");
            float secondNumber = scanner.nextFloat();
            Calculator<Float> calculator = new FloatCalculator();
            calculator.printAll(firstNumber, secondNumber);
        } else if (typeOfOperation == SHORT_CALCULATOR.getValue()) {
            System.out.println("Enter first number");
            short firstNumber = scanner.nextShort();
            System.out.println("Enter second number");
            short secondNumber = scanner.nextShort();
            Calculator<Short> calculator = new ShortCalculator();
            calculator.printAll(firstNumber, secondNumber);
        } else if (typeOfOperation == LONG_CALCULATOR.getValue()) {
            System.out.println("Enter first number");
            long firstNumber = scanner.nextLong();
            System.out.println("Enter second number");
            long secondNumber = scanner.nextLong();
            Calculator<Long> calculator = new LongCalculator();
            calculator.printAll(firstNumber, secondNumber);
        } else {
            System.out.println("Please enter correct option to continue");
            System.out.println();
        }
    }
}