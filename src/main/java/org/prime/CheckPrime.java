package org.prime;

public class CheckPrime {
    public boolean isPrime(long number) {
        int factorCount = 0;
        for (long range = 1; range * range < number; range++) {
            if (number % range == 0) {
                factorCount += 2;
            }
            if(factorCount > 2){
                return false;
            }
        }
        return true;
    }
}
