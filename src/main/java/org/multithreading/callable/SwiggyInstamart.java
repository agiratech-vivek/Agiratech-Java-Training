package org.multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class SwiggyInstamart {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        System.out.println("Current Inventory stock");
        Inventory inventory = new Inventory();
        inventory.getInventoryMap().forEach((item, stock) -> System.out.println(item + ": " + stock));
        List<User> userList = new ArrayList<>();
        userList.add(new User("Vivek"));
        userList.add(new User("Deva"));
        userList.add(new User("Kishore"));
        userList.forEach(user -> user.addCartItems("Soap", 50));
        List<Future> futureList = new ArrayList<>();
        userList.forEach(user -> {
                Order order = new Order(user, inventory);
                Future<OrderConfirmation> submit = executorService.submit(order);
                try {
                    System.out.println(submit.get().getMessage());
                } catch (InterruptedException interruptedException) {
                    System.out.println(interruptedException.getMessage());
                } catch (ExecutionException executionException) {
                    System.out.println(executionException.getMessage());
                } catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
        });
    }
}
