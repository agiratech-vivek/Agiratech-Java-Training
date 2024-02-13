package org.characteriostream.bufferedreaderwriter;

import java.io.*;
import java.util.Scanner;

public class BufferedReaderWriterExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String filePath = "src/main/java/org/characteriostream/bufferedreaderwriter/todolist/";
        String extension = ".txt";
        try {
            while(true){
                System.out.println("Press 1: Add new file\nPress 2: Display to do list\nPress 3: Exit");
                int option = scanner.nextInt();
                scanner.nextLine();
                if (option == 1) {
                    addToDoListItems(scanner, fileWriter, bufferedWriter, filePath, extension);
                } else if (option == 2) {
                    displayToDoListItems(scanner, filePath);
                } else if (option == 3) {
                    break;
                }
                bufferedWriter.close();
                fileWriter.close();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    private static void addToDoListItems(Scanner scanner, FileWriter fileWriter, BufferedWriter bufferedWriter, String filePath, String extension) throws IOException {
        System.out.println("Please enter the file name");
        String fileName = scanner.nextLine();
        filePath += fileName + extension;
        fileWriter = new FileWriter(filePath);
        bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println("Please enter the to do list items\nInsert exit keyword to exit the editor");
        String todoListItem = "";
        while (!(todoListItem = scanner.nextLine()).equals("exit")) {
            bufferedWriter.write(sanitizeData(todoListItem));
            bufferedWriter.write(System.lineSeparator());
        }
    }

    private static void displayToDoListItems(Scanner scanner, String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.lines().forEach(System.out::println); // using .lines() to convert the file data to stream
    }

    private static String sanitizeData(String item){
        StringBuilder sanitizedString = new StringBuilder();
        boolean characterCheck = false;
        for(char currentCharacter : item.toCharArray()){
            if(currentCharacter == ' '
                    || currentCharacter == ','
                    || currentCharacter == '.'
                    || (currentCharacter >= 'A' && currentCharacter <= 'Z')
                    || (currentCharacter >= 'a' && currentCharacter <= 'z')){
                sanitizedString.append(currentCharacter);
            } else {
                if(!characterCheck){
                    characterCheck = true;
                    System.out.println("Special characters are not allowed hence being ignored");
                }
            }
        }
        return sanitizedString.toString();
    }
}
