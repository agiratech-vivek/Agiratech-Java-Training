package org.multithreading.synchronizationproblem;

public class WithdrawBalance implements Runnable {
    private Amount amount;
    private int limit;

    public WithdrawBalance(Amount amount, int limit) {
        this.amount = amount;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int index = 1; index <= limit; index++) {
            int currentAmount = amount.getAmount();
            currentAmount -= index;
            amount.setAmount(currentAmount);
        }
    }
}
