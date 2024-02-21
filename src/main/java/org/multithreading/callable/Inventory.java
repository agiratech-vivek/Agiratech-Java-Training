package org.multithreading.callable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
    public Map<String, Integer> inventoryMap = getInventoryMap();

    public Map<String, Integer> getInventoryMap() {
        inventoryMap = new HashMap<>();
        inventoryMap.put("Soap", 100);
        inventoryMap.put("Shampoo", 100);
        inventoryMap.put("Snacks", 100);
        inventoryMap.put("Mango", 100);
        inventoryMap.put("Orange", 100);
        inventoryMap.put("Biscuits", 100);
        inventoryMap.put("Toothpaste", 100);
        inventoryMap.put("Candy", 100);
        inventoryMap.put("Grapes", 100);
        inventoryMap.put("Potato", 100);
        inventoryMap.put("Tomato", 100);
        inventoryMap.put("Oil", 100);
        inventoryMap.put("Rice", 100);
        inventoryMap.put("Flour", 100);
        return inventoryMap;
    }

    public boolean updateInventory(String order, int value, boolean isOrderConfirmed){
        Lock lock = new ReentrantLock();
        lock.lock();
        if (inventoryMap.containsKey(order) && inventoryMap.get(order) >= value) {
            inventoryMap.put(order, inventoryMap.get(order) - value);
        } else if (inventoryMap.containsKey(order) && inventoryMap.get(order) < value) {
            isOrderConfirmed = false;
        }
        lock.unlock();
        return isOrderConfirmed;
    }
}
