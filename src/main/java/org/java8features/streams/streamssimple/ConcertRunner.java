package org.java8features.streams.streamssimple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConcertRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Concert booking screen");
        System.out.println("Press 1: Insert Dummy Data: Press 2: Insert User Data");
        List<ConcertTicket> ticketRepository = new ArrayList<>();
        int option = scanner.nextInt();
        if (option == 1) {
            insertDummyData(ticketRepository);
        } else if (option == 2) {
            insertRealData(scanner, ticketRepository);
        }
        while (true) {
            System.out.println("Press 1: Set and view Gold Seats\nPress 2: Set and view Platinum Seats" +
                    "\nPress 3: Set All Seats\nPress 4: Display Seats\nPress 5: Fetch VIPs\nPress 6: Cancel Ticket\nPress7: Exit");
            option = scanner.nextInt();
            if (option == 1) {
                setGoldSeats(ticketRepository);
            } else if (option == 2) {
                setPlatinumSeats(ticketRepository);
            } else if (option == 3) {
                setAllSeats(ticketRepository);
            } else if (option == 4) {
                displaySortedTicket(ticketRepository);
            } else if(option == 5){
                fetchVipPeople(ticketRepository);
            } else if(option == 6){
                cancelAndDeleteTicketByName(ticketRepository, scanner);
            }
        }
    }

    private static void cancelAndDeleteTicketByName(List<ConcertTicket> ticketRepository, Scanner scanner) {
        System.out.println("Please enter a user name");
    }

    private static void fetchVipPeople(List<ConcertTicket> ticketRepository) {
        List<ConcertTicket> vipUsers = ticketRepository.stream()
                .filter(concertTicket -> concertTicket.isVip())
                .collect(Collectors.toList());
        vipUsers.stream().forEach(vipUser -> System.out.println(vipUser.getUserName()));
    }

    private static void displaySortedTicket(List<ConcertTicket> ticketRepository) {
        ticketRepository
                .stream()
                .sorted(Comparator.comparing(concertTicket -> concertTicket.getPrice())).forEach(System.out::println);
    }

    private static void setAllSeats(List<ConcertTicket> ticketRepository) {
        List<ConcertTicket> vipList = ticketRepository.stream()
                .map(concertTicket -> {
                    concertTicket.setSeatType(SeatType.GOLD);
                    return concertTicket;
                })
                .filter(concertTicket -> concertTicket.getPrice() > 500)
                .map(concertTicket -> {
                    concertTicket.setSeatType(SeatType.PLATINUM);
                    return concertTicket;
                })
                .filter(concertTicket -> concertTicket.getPrice() > 1000)
                .map(concertTicket -> {
                    concertTicket.setSeatType(SeatType.DIAMOND);
                    return concertTicket;
                })
                .filter(concertTicket -> concertTicket.isVip())
                .peek(concertTicket -> System.out.println("VIP type filtered: " + concertTicket))
                .map(concertTicket -> {
                    concertTicket.setSeatType(SeatType.VIP);
                    return concertTicket;
                })
                .collect(Collectors.toList());
    }

    private static void setPlatinumSeats(List<ConcertTicket> ticketRepository) {
        ticketRepository.stream()
                .filter(concertTicket -> concertTicket.getPrice() <= 1000)
                .map(concertTicket -> {
                    concertTicket.setSeatType(SeatType.PLATINUM);
                    return concertTicket;
                }).forEach(System.out::println);
    }

    private static void setGoldSeats(List<ConcertTicket> ticketRepository) {
        ticketRepository.stream()
                .filter(concertTicket -> concertTicket.getPrice() <= 500)
                .map(concertTicket -> {
                    concertTicket.setSeatType(SeatType.GOLD);
                    return concertTicket;
                }).collect(Collectors.toList());
    }

    private static void insertRealData(Scanner scanner, List<ConcertTicket> ticketRepository) {
        System.out.println("Please provide the number of people attending the concerts");
        int numberOfPeople = scanner.nextInt();
        while (numberOfPeople-- > 0) {
            System.out.println("Name, Price, VIP (Yes/No)");
            String[] ticketData = scanner.nextLine().split(", ");
            ticketRepository.add(new ConcertTicket(ticketData[0], Integer.parseInt(ticketData[1]), ticketData[3]));
        }
    }

    private static void insertDummyData(List<ConcertTicket> ticketRepository) {
        ticketRepository.add(new ConcertTicket("Vivek", 1500, "Yes"));
        ticketRepository.add(new ConcertTicket("Aman", 1700, "No"));
        ticketRepository.add(new ConcertTicket("Kishore", 1800, "Yes"));
        ticketRepository.add(new ConcertTicket("Deva", 600, "No"));
        ticketRepository.add(new ConcertTicket("Arun", 700, "No"));
        ticketRepository.add(new ConcertTicket("Harsha", 400, "No"));
        ticketRepository.add(new ConcertTicket("Harshini", 1100, "No"));
        ticketRepository.add(new ConcertTicket("Pragati", 400, "No"));
        ticketRepository.add(new ConcertTicket("Seema", 800, "No"));
        ticketRepository.add(new ConcertTicket("Ranjan", 300, "No"));
        ticketRepository.add(new ConcertTicket("Nishant", 1000, "No"));
        ticketRepository.add(new ConcertTicket("Saurabh", 400, "No"));
        ticketRepository.add(new ConcertTicket("Danish", 700, "No"));
        ticketRepository.add(new ConcertTicket("Musabbir", 800, "No"));
        ticketRepository.add(new ConcertTicket("Nehal", 1500, "Yes"));
    }
}