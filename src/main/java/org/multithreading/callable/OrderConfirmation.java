package org.multithreading.callable;

public class OrderConfirmation {
    private static String message;

    public OrderConfirmation(String message) {
        this.message = message;
    }

    public static OrderConfirmation getOrderConfirmation(boolean orderConfirmed){
        if(orderConfirmed){
            message = "Order successfully placed";
        } else{
            message = "One of the item out of stock";
        }
        return new OrderConfirmation(message);
    }

    public String getMessage(){
        return message;
    }
}
