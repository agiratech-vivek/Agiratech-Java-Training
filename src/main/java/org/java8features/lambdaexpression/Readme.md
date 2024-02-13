# Java 8 Features
## Lambda Expression
With Java 8, Lambda Expressions were introduced. Lambda Expression is nothing but a 
concise way to write programs. This also saves time as it reduces the lines of code.
Lambda Expression has one requirement that, it can be achieved using Functional Interface.
Functional interface is an interface with only one abstract method. With functional interface,
we can write lambda expression using (parameter) -> {implementation} symbol. () symbol represents the types of parameter it should
take. -> points to the implementation of the function. {} where the implementation happens.
Before Java 8, to implement any interface with one abstract method. We had to implement the same to a class first.
After we had implemented the interface and provided the definition of the abstract function, then we would have been able
to use the function by creating the object of the class and then call method using the class object.
Now with the help of lambda expression we can do the same in very less line of code.

#### Example: 
    @FunctionalInterface
    public interface MultiPurposeCalculator {
        int calculate(int firstNumber, int secondNumber) throws ArithmeticException;
    }

This is an example of functional interface, and we can see that it is having only one abstract method, which is accepting
2 integer parameter and has a return type of integer only.
Now to use the calculate function using lambda expression, we can do this:

    MultiPurposeCalculator add = (int firstNumber, int secondNumber) -> {
        int addition = firstNumber + secondNumber;
        return addition;
    };

There are few more changes we can do when writing Lambda Expressions.
1. If the abstract function is only accepting one parameter then "()" opening and closing brackets are not required.
2. If the implementation, we can do in one line then curly braces "{}" are also not required.


    private static void lambdaWithOneArg(String tigerFood) {
        Eatable tiger = food -> "Tiger eats " + food;
        System.out.println(tiger.eat(tigerFood));
    }

