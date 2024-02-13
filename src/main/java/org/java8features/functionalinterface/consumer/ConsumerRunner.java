package org.java8features.functionalinterface.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<List<Integer>> getSquare = getSquareList();
        Consumer<List<Integer>> displayList = list -> list.forEach(num -> System.out.println(num));

        System.out.println("Please provide the number of elements you want to insert");
        int range = scanner.nextInt();
        List<Integer> numberList = new ArrayList<>();
        System.out.println("Please insert numbers");
        while(range-- > 0){
            numberList.add(scanner.nextInt());
        }
        while(true){
            System.out.println("Press 1: Modify List, Press 2: Display List");
            int option = scanner.nextInt();
            if (option == 1) {
                getSquare.accept(numberList);
            } else if (option == 2) {
                displayList.accept(numberList);
            } else{
                break;
            }
        }
    }

    private static Consumer<List<Integer>> getSquareList() {
        Consumer<List<Integer>> getSquare = (list) -> {
            for(int index = 0; index < list.size(); index++){
                list.set(index, list.get(index) * list.get(index));
            }
        };
        return getSquare;
    }
}
