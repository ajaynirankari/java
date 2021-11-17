package com.gl.PredicateFunctionalInterface;

import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterfaceDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list
                .stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        Predicate<Integer> predicateObj = new PredicateImpl();
        list.stream()
                .filter(predicateObj)
                .forEach(System.out::println);


        Predicate<Integer> predicateObj1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer input) {
                return input % 2 == 0;
            }
        };
        list.stream()
                .filter(predicateObj1)
                .forEach(System.out::println);


        Predicate<Integer> predicateObj2 = (Integer input) -> {
            return input % 2 == 0;
        };
        list.stream()
                .filter(predicateObj2)
                .forEach(System.out::println);

        Predicate<Integer> predicateObj3 = input -> input % 2 == 0;
        list.stream()
                .filter(predicateObj3)
                .forEach(System.out::println);

        System.out.println(predicateObj3.test(40));

        list.stream()
                .filter(input -> input % 2 == 0)
                .forEach(System.out::println);

        list.stream()
                .filter(PredicateFunctionalInterfaceDemo::isEven)
                .forEach(System.out::println);
    }

    static boolean isEven(int input) {
        return input % 2 == 9;
    }
}

class PredicateImpl implements Predicate<Integer> {
    @Override
    public boolean test(Integer input) {
        return input % 2 == 0;
    }
}