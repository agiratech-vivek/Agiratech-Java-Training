package org.collection;

import org.collection.controller.BookMyShowController;
import org.collection.repository.CityRepository;
import org.collection.repository.MovieRepository;
import org.collection.repository.TheatreRepository;

import java.util.*;

public class CollectionExample{
    private static CityRepository cityRepository;
    private static MovieRepository movieRepository;
    private static TheatreRepository theatreRepository;
    public static void main(String[] args) {
        BookMyShowController bookMyShowController = new BookMyShowController();
        BookMyShow bookMyShow = new BookMyShow();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Book My Show, Kindly select the appropriate option to continue");
        while(true) {
            System.out.println("Press 1: Add\nPress 2: Remove\nPress 3: Display\nPress 4: Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Please enter the number of cities you want to add");
                int cityCount = scanner.nextInt(); // using Vector here
                List<City> cityList = new Vector<>();
                while (cityCount > 0) {
                    cityList.add(bookMyShowController.addCity(scanner));
                    cityCount--;
                    scanner.nextLine();
                }
            } else if (option == 2) {
                System.out.println("Kindly select options to remove respective items");
                System.out.println("Press 1: Remove City\nPress 2: Remove Theatre\nPress 3: Remove Movie");
                int subOption = scanner.nextInt();
                if (subOption == 1) {
                    bookMyShowController.removeCity(scanner);
                } else if (subOption == 2) {
                    bookMyShowController.removeTheatre(scanner);
                } else if (subOption == 3) {
                    bookMyShowController.removeMovie(scanner);
                }
            } else if (option == 3) {
                bookMyShowController.getCity(scanner);
            } else {
                break;
            }
        }
    }
}
