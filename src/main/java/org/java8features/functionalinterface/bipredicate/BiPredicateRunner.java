package org.java8features.functionalinterface.bipredicate;

import javax.swing.text.DateFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiPredicate<Company, Qualifier> checkCompanyRegistered = (company, qualifier) -> {
            if(company == null){
                return false;
            }
            if(!company.getCity().equals(qualifier.getCity())){
                return false;
            }
            if(!company.isCompanyRegistered()){
                return false;
            }
            if(!company.getFounded().isBefore(qualifier.getDate())){
                return false;
            }
            return true;
        };
        List<Company> companyList = new ArrayList<>();
        while(true){
            System.out.println("Press 1: Insert Dummy data\nPress 2: Insert company data manually\n" +
                    "Press 3: Display all company details\nPress 4: Filter companies by registration\n" +
                    "Press 5: Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                companyList.add(new Company("Agira", "Chennai", LocalDate.of(2014, Month.APRIL, 12), "Y"));
                companyList.add(new Company("Nestle", "Mumbai", LocalDate.of(2004, Month.FEBRUARY, 10), "N"));
                companyList.add(new Company("Lalit", "Delhi", LocalDate.of(2020, Month.AUGUST, 11), "N"));
                companyList.add(new Company("Milton", "Bangalore", LocalDate.of(2005, Month.DECEMBER, 9), "N"));
                companyList.add(new Company("Swiggy", "Bangalore", LocalDate.of(2010, Month.JANUARY, 1), "N"));
                companyList.add(new Company("Zomato", "Delhi", LocalDate.of(2013, Month.MARCH, 15), "N"));
                companyList.add(new Company("HP", "Bangalore", LocalDate.of(1993, Month.MAY, 19), "N"));
                companyList.add(new Company("Voltas", "Delhi", LocalDate.of(2003, Month.SEPTEMBER, 15), "N"));
                companyList.add(new Company("CGA", "Chennai", LocalDate.of(2002, Month.OCTOBER, 17), "N"));
                companyList.add(new Company("Fossil", "Chennai", LocalDate.of(2000, Month.APRIL, 11), "N"));
                companyList.add(new Company("Dell", "Ahmedabad", LocalDate.of(2009, Month.JULY, 5), "N"));
                companyList.add(new Company("Samsung", "Mumbao", LocalDate.of(2002, Month.JUNE, 2), "N"));
            } else if (option == 2) {
                System.out.println("Company Name, City, Founded (DD-MM-YYYY), Company register with MCA (Y/N)");
                String[] companyData = scanner.nextLine().split(", ");
                String companyName = companyData[0];
                String city = companyData[1];
                LocalDate dateFounded = LocalDate.parse(companyData[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                String isRegistered = companyData[3];
                companyList.add(new Company(companyName, city, dateFounded, isRegistered));
            } else if (option == 3) {
                companyList.forEach(System.out::println);
            } else if (option == 4) {
                scanner.nextLine();
                System.out.println("Please provide the city and founded date (DD-MM-YYYY) to check if company registered");
                String[] qualifierData = scanner.nextLine().split(", ");
                Qualifier qualifier = new Qualifier(LocalDate.parse(qualifierData[1], DateTimeFormatter.ofPattern("dd-MM-yyyy")), qualifierData[0]);
                companyList.forEach(company -> {
                    if (checkCompanyRegistered.test(company, qualifier)) {
                        System.out.println(company);
                    }
                });
            } else if (option == 5) {
                break;
            }
        }
    }
}
