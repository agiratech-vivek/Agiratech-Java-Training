package org.miniproject.watercan;

import org.miniproject.watercan.exception.IncorrectInputException;
import org.miniproject.watercan.exception.InvalidOwnerException;

import java.util.Properties;
import java.util.Scanner;

public class WaterCanRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Welcome to Water-can inventory, Please provide new owner details");
                System.out.println("Please provide owner name, address and phone number separated by a comma");
                Owner owner = createNewOwner(scanner);
                if(owner == null){
                    System.out.println("Please provide correct details for owner");
                    System.out.println();
                    continue;
                }
                while(true) {
                    System.out.println("You have " + owner.getWaterCanList().totalWaterCans() + " water-cans.");
                    System.out.println("Enter 1: Show inventory\nEnter 2: Stock Water Cans\nEnter 3: Sell Water Cans\nEnter 4: Exit to main menu");
                    byte option = scanner.nextByte();
                    scanner.nextLine();
                    try {
                        if (option == 1){
                            System.out.println(owner.getWaterCanList().toString());
                        } else if (option == 2) {
                            stockWaterCan(scanner, owner);
                        } else if (option == 3) {
                            sellWaterCan(scanner, owner);
                        } else if (option == 4) {
                            break;
                        } else {
                            throw new IncorrectInputException("You have selected wrong option: " + option);
                        }
                    } catch (Exception exception){
                        System.err.println(exception.getMessage());
                        System.out.println("Please enter correct option to continue");
                    }
                }
                System.out.println("Press 1 to continue\nPress 2 to exit this app");
                byte mainMenuOption = scanner.nextByte();
                scanner.nextLine(); // to clean buffer
                if(mainMenuOption == 2){
                    break;
                } else if(mainMenuOption == 1){
                    continue;
                } else {
                    throw new IncorrectInputException("You have selected wrong option: " + mainMenuOption);
                }
            } catch (IncorrectInputException incorrectInputException) {
                System.err.println(incorrectInputException.getMessage());
                System.out.println();
            } catch (Exception exception){
                System.err.println(exception.getMessage());
                System.out.println();
            }
        }
    }

    private static Owner createNewOwner(Scanner scanner) throws InvalidOwnerException {
        String ownerDetailsInput = scanner.nextLine();
        if(!ownerDetailsInput.contains(", ")){
            return null;
        }
        String[] ownerDetails = ownerDetailsInput.split(", ");
        Owner owner = new Owner(ownerDetails[0], ownerDetails[1], ownerDetails[2]);
        System.out.println("Welcome: " + owner.getName() + ", Kindly select the options as per your requirement");
        return owner;
    }

    private static void stockWaterCan(Scanner scanner, Owner owner) throws RuntimeException{
        System.out.println("Stock Water Cans");
        System.out.println("Please provide the number of cans you want to stock");
        System.out.println("1 Litre Water Can: ");
        int oneLitre = scanner.nextInt();
        System.out.println("5 Litre Water Can: ");
        int fiveLitre = scanner.nextInt();
        System.out.println("10 Litre Water Can: ");
        int tenLitre = scanner.nextInt();
        System.out.println("25 Litre Water Can: ");
        int twentyFiveLitre = scanner.nextInt();
        owner.stockWaterCan(new WaterCan(oneLitre, fiveLitre, tenLitre, twentyFiveLitre));
    }

    public static void sellWaterCan(Scanner scanner, Owner owner){
        System.out.println("Sell Water Cans");
        System.out.println("Please provide the number of cans you want to sell");
        System.out.println("1 Litre Water Can: ");
        int oneLitre = scanner.nextInt();
        System.out.println("5 Litre Water Can: ");
        int fiveLitre = scanner.nextInt();
        System.out.println("10 Litre Water Can: ");
        int tenLitre = scanner.nextInt();
        System.out.println("25 Litre Water Can: ");
        int twentyFiveLitre = scanner.nextInt();
        owner.sellWaterCan(new WaterCan(oneLitre, fiveLitre, tenLitre, twentyFiveLitre));

    }

}
