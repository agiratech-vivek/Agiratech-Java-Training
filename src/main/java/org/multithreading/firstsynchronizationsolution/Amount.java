package org.multithreading.firstsynchronizationsolution;

public class Amount {
    private int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void modifyAmount(int change){
        amount += change;
    }
}
