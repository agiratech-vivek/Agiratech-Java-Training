package org.characteriostream.stringreaderwriter;

import java.io.StringWriter;
import java.util.Scanner;

public class StringReaderWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringWriter stringWriter = new StringWriter();
        while (true) {
            System.out.println("Welcome to your logs");
            System.out.println("Press 1: Insert new log, Press 2: Display log, Press 3: Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Please enter logs line by line");
                String message = scanner.nextLine();
                stringWriter.write(message + "\n");
                while (!(message = scanner.nextLine()).equals("exit")) {
                    stringWriter.append(message).append("\n");
                }
            } else if (option == 2) {
                System.out.println(stringWriter);
            } else if (option == 3) {
                break;
            }
        }
    }
}
