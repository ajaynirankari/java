package com.gl.CollectorAPI;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorAPIDemo {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        var result = listOfNumbers.stream()
                .filter(CollectorAPIDemo::isEven)
                .map(CollectorAPIDemo::doubleIt)
                .count();
        System.out.println("result = " + result);


        MyCollectorForToList myCollectorForToList = new MyCollectorForToList();
        List<Integer> collect = listOfNumbers.stream()
                .filter(CollectorAPIDemo::isEven)
                .collect(myCollectorForToList);
        System.out.println("collect = " + collect);


        ArrayList<Integer> collect1 = listOfNumbers.stream()
                .filter(CollectorAPIDemo::isEven)
                .collect(() -> new ArrayList<Integer>(), (list, e) -> list.add(e), (list1, list2) -> list1.addAll(list2));
        System.out.println("collect1 = " + collect1);

        List<Integer> collect2 = listOfNumbers.stream()
                .filter(CollectorAPIDemo::isEven)
                .collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);

        Set<Integer> collect3 = listOfNumbers.stream()
                .filter(CollectorAPIDemo::isEven)
                .collect(Collectors.toSet());
        System.out.println("collect3 = " + collect3);

        LinkedList<Integer> collect4 = listOfNumbers.stream()
                .filter(CollectorAPIDemo::isEven)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("collect4 = " + collect4);


        Long collect5 = listOfNumbers.stream()
                .filter(CollectorAPIDemo::isEven)
                .collect(Collectors.counting());
        System.out.println("collect5 = " + collect5);


        List<String> stringList = List.of("one", "two", "three", "four", "five", "six", "seven");

        String collect6 = stringList.stream()
                .collect(Collectors.joining());
        System.out.println("collect6 = " + collect6);

        String collect7 = stringList.stream()
                .collect(Collectors.joining("->"));
        System.out.println("collect7 = " + collect7);

        String collect8 = stringList.stream()
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println("collect8 = " + collect8);

        Map<Boolean, List<Integer>> collect9 = listOfNumbers.stream()
                .collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println("collect9 = " + collect9);

        Map<Boolean, Set<Integer>> collect10 = listOfNumbers.stream()
                .collect(Collectors.partitioningBy(e -> e % 2 == 0, Collectors.toSet()));
        System.out.println("collect10 = " + collect10);

        Map<Integer, List<String>> collect11 = stringList.stream()
                .collect(Collectors.groupingBy(s -> s.length()));
        System.out.println("collect11 = " + collect11);

        Map<Integer, Set<String>> collect12 = stringList.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("collect12 = " + collect12);


        Map<Integer, String> collect13 = stringList.stream()
                .collect(Collectors.toMap(String::length, e -> e, (oldValue, newValue) -> newValue + ":" + oldValue));
        System.out.println("collect13 = " + collect13);


        List<String> collect14 = stringList.stream()
                .collect(Collectors.filtering(s -> s.length() > 3, Collectors.toList()));
        System.out.println("collect14 = " + collect14);

        Set<String> collect15 = stringList.stream()
                .collect(Collectors.filtering(
                        s -> s.length() > 3,
                        Collectors.mapping(s -> s.toUpperCase(), Collectors.toSet())
                ));
        System.out.println("collect15 = " + collect15);
    }

    static boolean isEven(int e) {
        //System.out.println("isEven = " + e);
        return e % 2 == 0;
    }

    static int doubleIt(int e) {
        //System.out.println("doubleIt = " + e);
        return e * 2;
    }
}


class MyCollectorForToList implements Collector<Integer, List<Integer>, List<Integer>> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return () -> new ArrayList<Integer>();
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (list, e) -> list.add(e);
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        return e -> e;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}