package com.gl.JavaSession04;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Collector collector = new MyCollector();
        Object collect = integerList.stream()
                .filter(n -> n % 2 == 0)
                .collect(collector);
        System.out.println("collect = " + collect);

        ArrayList<Integer> collect1 = integerList.stream()
                .filter(n -> n % 2 == 0)
                .collect(() -> new ArrayList<Integer>(), (list, e) -> list.add(e), (list1, lis2) -> list1.addAll(lis2));
        System.out.println("collect1 = " + collect1);

        List<Integer> collect2 = integerList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        Set<Integer> collect3 = integerList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println("collect3 = " + collect3);

        LinkedList<Integer> collect4 = integerList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("collect4 = " + collect4);

        Long collect5 = integerList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.counting());
        System.out.println("collect5 = " + collect5);

        Map<Boolean, List<Integer>> collect6 = integerList.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("collect6 = " + collect6);

        List<String> stringList = List.of("one", "two", "three", "four", "five", "six");

        String collect7 = stringList.stream()
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println("collect7 = " + collect7);

        Map<Integer, List<String>> collect8 = stringList.stream()
                .collect(Collectors.groupingBy(s -> s.length()));
        System.out.println("collect8 = " + collect8);

        Map<Integer, Set<String>> collect9 = stringList.stream()
                .collect(Collectors.groupingBy(
                        s -> s.length(),
                        Collectors.toSet()
                ));
        System.out.println("collect9 = " + collect9);

        Map<Integer, String> collect10 = stringList
                .stream()
                .collect(Collectors.toMap(s -> s.length(), s -> s, (o, v) -> o));
        System.out.println("collect10 = " + collect10);

        List<String> collect11 = stringList.stream()
                .collect(
                        Collectors
                                .filtering(s -> s.length() > 3, Collectors.toList())
                );
        System.out.println("collect11 = " + collect11);

    }
}

class MyCollector implements Collector<Integer, List<Integer>, List<Integer>> {
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