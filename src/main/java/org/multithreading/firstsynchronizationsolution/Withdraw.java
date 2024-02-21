package org.multithreading.firstsynchronizationsolution;

public class Withdraw implements Runnable{
    private Amount amount;
    private int limit;

    public Withdraw(Amount amount, int limit) {
        this.amount = amount;
        this.limit = limit;
    }

    @Override
    public void run() {
        for(int index = 0; index < limit; index++){
            amount.modifyAmount(-index);
        }
    }
}
