package org.java8features.lambdaexpression;

import java.util.Scanner;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1: Lambda Expression with no args\nPress 2: Lambda Expression with 1 args\nPress 3: Lambda Expression with multi args");
            int option = scanner.nextInt();
            if (option == 1) {
                lambdaWithNoArgs();
            } else if (option == 2) {
                lambdaWithOneArg(scanner);
            } else if (option == 3) {
                lambdaWithMultiArgs(scanner);
            } else if (option == 4) {
                break;
            }
            System.out.println();
        }
    }

    private static void lambdaWithMultiArgs(Scanner scanner) {
        System.out.println("Welcome to Multipurpose Calculator");
        System.out.print("1st Number: ");
        int firstNumberInput = scanner.nextInt();
        System.out.print("2nd Number: ");
        int secondNumberInput = scanner.nextInt();
        // multi args lambda expression using function functional interface
        // Addition
        MultiPurposeCalculator add = (int firstNumber, int secondNumber) -> {
            int addition = firstNumber + secondNumber;
            return addition;
        };
        // Subtraction
        MultiPurposeCalculator subtraction = (firstNumber, secondNumber) -> firstNumber - secondNumber;
        // Multiplication
        MultiPurposeCalculator multiplication = ((firstNumber, secondNumber) -> firstNumber * secondNumber);
        // Division
        try {
            MultiPurposeCalculator divide = (firstNumber, secondNumber) -> firstNumber / secondNumber;
            System.out.printf("%d / %d = %d", firstNumberInput, secondNumberInput, divide.calculate(firstNumberInput, secondNumberInput)).println();
        } catch (ArithmeticException arithmeticException) {
            System.out.println(arithmeticException.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        System.out.printf("%d + %d = %d", firstNumberInput, secondNumberInput, add.calculate(firstNumberInput, secondNumberInput)).println();
        System.out.printf("%d - %d = %d", firstNumberInput, secondNumberInput, subtraction.calculate(firstNumberInput, secondNumberInput)).println();
        System.out.printf("%d * %d = %d", firstNumberInput, secondNumberInput, multiplication.calculate(firstNumberInput, secondNumberInput)).println();
    }

    private static void lambdaWithOneArg(Scanner scanner) {
        // one args lambda expression using function functional interface
        System.out.println("Please give food option for man and tiger respectively");
        scanner.nextLine();
        String manFood = scanner.nextLine();
        String tigerFood = scanner.nextLine();
        Eatable man = food -> "Man eats " + food;
        Eatable tiger = food -> "Tiger eats " + food;
        System.out.println(man.eat(manFood));
        System.out.println(tiger.eat(tigerFood));
    }

    private static void lambdaWithNoArgs() {
        // no args lambda expression with consumer functional interface
        Flyable human = () -> System.out.println("Human flies using jetpack");
        Flyable bird = () -> System.out.println("Bird flies using wings");
        bird.fly();
        human.fly();
    }
}
