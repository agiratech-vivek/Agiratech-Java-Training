package org.characteriostream.inputoutputstream;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IOStreamReaderWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/main/java/org/characteriostream/inputoutputstream/";
        while (true) {
            try {
                System.out.println("Press 1: To add new\nPress 2: Search a file\nPress 3: Append to a file\nPress 4: Exit");
                int option = scanner.nextInt();
                if (option == 1) {
                    addNewFile(filePath, scanner);
                } else if (option == 2) {
                    searchFile(filePath, scanner);
                } else if (option == 3) {
                    appendFile(scanner, filePath);
                } else if (option == 4) {
                    break;
                }
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File not found");
            } catch (IOException ioException) {
                System.out.println(ioException.getLocalizedMessage());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static void addNewFile(String filePath, Scanner scanner) throws IOException {
        scanner.nextLine();
        System.out.println("Please enter a file name");
        String fileName = scanner.nextLine();
        FileOutputStream fileOutputStream = new FileOutputStream(filePath + fileName + ".txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        String userInput = "";
        while (!(userInput = scanner.nextLine()).equals("exit")) {
            outputStreamWriter.write(userInput);
        }
        outputStreamWriter.close();
    }

    private static String searchFile(String filePath, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please enter a file name to search");
        String fileName = scanner.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath + fileName + ".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            int data = 0;
            if (inputStreamReader.ready()) {
                while ((data = inputStreamReader.read()) != -1) {
                    System.out.print((char) data);
                }
                System.out.println();
            }
            fileInputStream.close();
            inputStreamReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException(fileNotFoundException);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    private static void appendFile(Scanner scanner, String filePath) {
        System.out.println("Append to file");
        String fileName = searchFile(filePath, scanner);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath + fileName + ".txt", true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            String appends = "";
            while (!(appends = scanner.nextLine()).equalsIgnoreCase("exit")) {
                outputStreamWriter.append(appends);
                outputStreamWriter.append(System.lineSeparator());
            }
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Some error occurred");
        }
    }
}