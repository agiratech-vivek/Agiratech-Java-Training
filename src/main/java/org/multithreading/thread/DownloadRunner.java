package org.multithreading.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DownloadRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please mention the number of software you want to download");
        int numberOfSoftwares = scanner.nextInt();
        List<Thread> threadList = new ArrayList<>();
        scanner.nextLine();
        while (numberOfSoftwares-- > 0){
            scanner.nextLine();
            System.out.print("Software name: ");
            String softwareName = scanner.nextLine();
            Thread thread = new Thread(new Downloader(softwareName));
            System.out.println("Please mention the priority low: 0, medium: 1, high: 2");
            int priority = scanner.nextInt();
            if(priority == 0){
                thread.setPriority(1);
            } else if(priority == 1){
                thread.setPriority(5);
            } else {
                thread.setPriority(10);
            }
            threadList.add(thread);
        }
        threadList.forEach(thread -> {
            System.out.println(thread.getName() + " current state: " + thread.getState().name());
        });

        threadList.forEach(thread -> {
            thread.start();
            System.out.println(thread.getName() + " current state: " + thread.getState().name());
        });

        threadList.forEach(thread -> {
            System.out.println(thread.getName() + " current state: " + thread.getState().name());
        });
    }
}
