package org.prime;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckPrime checkPrime = new CheckPrime();
        System.out.println("Please enter your name");
        String name = scanner.next();
        System.out.println("Hello " + name);
        System.out.println("Kindly enter the number to check if it is prime or not");
        long number = scanner.nextLong();
        System.out.println(checkPrime.isPrime(number));
    }
}
