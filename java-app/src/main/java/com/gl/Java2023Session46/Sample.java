package com.gl.Java2023Session46;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {
        // Stream API
        // Two kind of Operation
        // 1 - Intermediate operation
        // 2 - Terminal operation
        // Stream API support Lazy Evaluation

        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> stream = listOfNumbers.stream();

        //Stream<Integer> afterFilterStream = stream.filter(n -> n % 2 == 0);
        // or
        Stream<Integer> afterFilterStream = stream.filter(Sample::isEven);

        //Stream<Integer> afterMapStream = afterFilterStream.map(n -> n * 10);
        // or
        Stream<Integer> afterMapStream = afterFilterStream.map(Sample::multiplyByTen);

        afterMapStream.forEach(n -> System.out.println(n));
        System.out.println("-------------------------------------------------------------");

        listOfNumbers.stream()
                .filter(Sample::isEven)
                .map(Sample::multiplyByTen)
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");

        List<Integer> collect = listOfNumbers.stream()
                .filter(Sample::isEven)
                .map(Sample::multiplyByTen)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("-------------------------------------------------------------");

        List<Integer> collect1 = listOfNumbers.stream()
                .filter(Sample::isEven)
                //.map(Sample::multiplyByTen)
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);
        System.out.println("-------------------------------------------------------------");

        List<Integer> collect2 = listOfNumbers.stream()
                //.filter(Sample::isEven)
                //.map(Sample::multiplyByTen)
                .collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);
        System.out.println("-------------------------------------------------------------");


        IntStream.range(1, 10)
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");

        int sum = IntStream.range(1, 20)
                .sum();
        System.out.println("sum = " + sum);
        System.out.println("-------------------------------------------------------------");

        System.out.println(
                IntStream.range(1, 20)
                        .max()
        );
        System.out.println("-------------------------------------------------------------");

        System.out.println(
                IntStream.rangeClosed(1, 20)
                        .summaryStatistics()
        );
        System.out.println("-------------------------------------------------------------");

        IntSummaryStatistics stats = IntStream.rangeClosed(1, 20)
                .summaryStatistics();

        int max = stats.getMax();
        System.out.println("max = " + max);

        int min = stats.getMin();
        System.out.println("min = " + min);

        double average = stats.getAverage();
        System.out.println("average = " + average);

        System.out.println("stats = " + stats);

        System.out.println("-------------------------------------------------------------");
        for (int i = 1; i < 20; i++) {
            System.out.print(i + ",");
        }
        System.out.println("\n-------------------------------------------------------------");

        IntStream.range(1, 20)
                .forEach(i -> System.out.print(i + ","));
        System.out.println("\n-------------------------------------------------------------");

        for (int i = 1; i < 20; i = i + 3) {
            System.out.print(i + ",");
        }
        System.out.println("\n-------------------------------------------------------------");

        IntStream.iterate(1, i -> i < 20, i -> i + 3)
                .forEach(i -> System.out.print(i + ","));
        System.out.println("\n-------------------------------------------------------------");

        IntStream.range(1, 100)
                .limit(5)
                .forEach(i -> System.out.print(i + ","));
        System.out.println("\n-------------------------------------------------------------");

        IntStream.range(1, 100)
                .takeWhile(i -> i < 20)
                .forEach(i -> System.out.print(i + ","));
        System.out.println("\n-------------------------------------------------------------");

        IntStream.range(1, 50)
                .dropWhile(i -> i < 20)
                .forEach(i -> System.out.print(i + ","));
        System.out.println("\n-------------------------------------------------------------");

        IntStream.range(1, 5)
                .forEach(i -> System.out.print(i + ","));
        System.out.println("\n-------------------------------------------------------------");

        IntStream.rangeClosed(1, 5)
                .forEach(i -> System.out.print(i + ","));
        System.out.println("\n-------------------------------------------------------------");

        System.out.println(
                IntStream.range(1, 10000)
                        .sum()
        );
        System.out.println("-------------------------------------------------------------");
        System.out.println(
                IntStream.range(1, 10000)
                        .average()
        );
        System.out.println("-------------------------------------------------------------");
    }

    static boolean isEven(int n) {
        System.out.println("isEven = " + n);
        return n % 2 == 0;
    }

    static int multiplyByTen(int n) {
        System.out.println("multiplyByTen = " + n);
        return n * 10;
    }
}
