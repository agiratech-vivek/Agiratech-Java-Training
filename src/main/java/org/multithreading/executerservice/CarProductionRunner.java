package org.multithreading.executerservice;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarProductionRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = null;
        while(true){
            System.out.println("Press 1: Manufacture Cars\nPress 2: Manufacture Tires\nPress 3: Exit");
            int option = scanner.nextInt();
            if(option == 1){
                manufactureCars(scanner, executorService);
            } else if(option == 2){
                manufactureTires(scanner, executorService);
            } else if(option == 3){
                break;
            }
        }
    }

    private static void manufactureTires(Scanner scanner, ExecutorService executorService) {
        executorService = Executors.newSingleThreadExecutor();
        System.out.println("Please mention the number of tires you want to manufacture");
        int numberOfTires = scanner.nextInt();
        while(numberOfTires-- > 0){
            executorService.execute(new TireProduction("MRF Tires"));
        }
    }

    private static void manufactureCars(Scanner scanner, ExecutorService executorService) {
        System.out.println("Please mention the number of production lines for car");
        int productionLines = scanner.nextInt();
        executorService = Executors.newFixedThreadPool(5);
        System.out.println("Please enter the number of cars you want to manufacture");
        int numberOfCars = scanner.nextInt();
        System.out.println("Please mention the name of the car");
        String carName = scanner.nextLine();
        while (numberOfCars-- > 0) {
            executorService.execute(new CarProduction(carName));
        }
    }
}
