package org.multithreading.callable;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private Map<String, Integer> cart;

    public User() {
        this.cart = new HashMap<>();
    }

    public User(String name) {
        this.name = name;
        this.cart = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cart = cart;
    }

    public void addCartItems(String item, int count) {
        cart.put(item, count);
    }
}
