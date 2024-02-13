package org.characteriostream.filereaderwriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/main/java/org/characteriostream/filereaderwriter/";
        String extension = ".txt";
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try {
            while(true){
                System.out.println("Press 1: Write a Journal, Press 2: Append Journal, Press 3: Search Journal, Press 4: Exit");
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option == 1){
                    addNewJournal(scanner, null, filePath, extension);
                } else if(option == 2){
                    appendJournal(scanner, null, null, filePath, extension);
                } else if (option == 3) {
                    displayJournal(scanner, null, filePath, extension);
                } else if (option == 4) {
                    break;
                }
            }
        } catch (IOException ioException) {
            System.out.println(ioException);
        } catch (Exception exception){
            System.out.println(exception);
        } finally{
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ioException) {
                System.out.println(ioException);
            }
        }
    }

    private static void readAndDisplayJournal(FileReader fileReader) throws IOException {
        int index = 0;
        while((index = fileReader.read()) != -1){
            System.out.print((char) index);
        }
    }

    private static void addNewJournal(Scanner scanner, FileWriter fileWriter, String filePath, String extension) throws IOException {
        System.out.println("Please enter the file name");
        String fileName = scanner.nextLine();
        fileWriter = new FileWriter(filePath + fileName + extension);
        System.out.println("Write a new Journal");
        String article = scanner.nextLine();
        fileWriter.write(sanitizeData(article)); // writing new string to the file after sanitizing the data
        fileWriter.close();
    }

    private static void appendJournal(Scanner scanner,
                                      FileReader fileReader,
                                      FileWriter fileWriter,
                                      String filePath, String extension) throws IOException {
        System.out.println("Please enter the file name you want to append to");
        String fileName = scanner.nextLine();
        String updatedFilePath = filePath + fileName + extension;
        fileReader = new FileReader(updatedFilePath);
        readAndDisplayJournal(fileReader);
        String article = scanner.nextLine();
        fileWriter = new FileWriter(updatedFilePath, true); // to fetch the file which is already there and append new data
        fileWriter.append(sanitizeData(article));
        fileWriter.close();
    }

    private static void displayJournal(Scanner scanner, FileReader fileReader, String filePath, String extension) throws IOException {
        System.out.println("Please enter the journal name you want to read");
        String journalName = scanner.nextLine();
        fileReader = new FileReader(filePath + journalName + extension);
        readAndDisplayJournal(fileReader);
        System.out.println();
        System.out.println();
    }

    private static String sanitizeData(String userEnteredData){
        StringBuilder sanitizedString = new StringBuilder();
        for(char currentCharacter : userEnteredData.toCharArray()){
            if(currentCharacter == ' '
                    || currentCharacter == ','
                    || currentCharacter == '.'
                    || (currentCharacter >= 'A' && currentCharacter <= 'Z')
                    || (currentCharacter >= 'a' && currentCharacter <= 'z')){
                sanitizedString.append(currentCharacter);
            }
        }
        return sanitizedString.toString();
    }
}
