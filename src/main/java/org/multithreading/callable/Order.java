package org.multithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;


public class Order implements Callable<OrderConfirmation> {
    private User user;
    private Inventory inventory;

    public Order(User user, Inventory inventory) {
        this.user = user;
        this.inventory = inventory;
    }

    @Override
    public OrderConfirmation call() throws RuntimeException {
        boolean isOrderConfirmed = true;
        user.getCart().forEach((order, value) -> {
                inventory.updateInventory(order, value, isOrderConfirmed);
        });
        return OrderConfirmation.getOrderConfirmation(isOrderConfirmed);
    }
}
