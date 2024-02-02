package org.calculator;

public class LongCalculator implements Calculator<Long>{
    @Override
    public Long sum(Long firstNumber, Long secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public Long subtract(Long firstNumber, Long secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public Long multiply(Long firstNumber, Long secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public Long divide(Long firstNumber, Long secondNumber) {
        if(secondNumber == 0){
            throw new RuntimeException("Cannot divide with zero");
        }
        return firstNumber / secondNumber;
    }

    @Override
    public Long modulus(Long firstNumber, Long secondNumber) {
        return firstNumber % secondNumber;
    }
}
