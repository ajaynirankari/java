package com.pkg24.StreamAPI_05;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 5);

        Stream<Integer> stream = list.stream();

        Optional<Integer> max = list.stream().max((n1, n2) -> {
            System.out.println("n1 = " + n1 + ", n2 = " + n2);
            return n1 - n2;
        });
        System.out.println("max = " + max);

        Optional<Integer> max2 = list.stream().max(Integer::compare);
        System.out.println("max2 = " + max2);

        System.out.println("-------------------------------------");

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7);

        OptionalInt max3 = intStream
                .filter(n -> n % 2 == 0)
                .map(n -> n * 100)
                .max();

        System.out.println("max3 = " + max3);

        System.out.println("-------------------------------------");

        IntStream intStream1 = IntStream.of(11, 12, 13, 4, 15, 6, 17);

        IntSummaryStatistics intSummaryStatistics = intStream1.summaryStatistics();
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);
        System.out.println("intSummaryStatistics.getSum() = " + intSummaryStatistics.getSum());
        System.out.println("intSummaryStatistics.getMax() = " + intSummaryStatistics.getMax());
        System.out.println("intSummaryStatistics.getMin() = " + intSummaryStatistics.getMin());
        System.out.println("intSummaryStatistics.getCount() = " + intSummaryStatistics.getCount());
        System.out.println("intSummaryStatistics.getAverage() = " + intSummaryStatistics.getAverage());

        System.out.println("-------------------------------------");

        LongStream longStream;
        DoubleStream doubleStream;

        System.out.println("-------------------------------------");
        IntStream.range(10, 20)
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        System.out.println(5);

        PrintStream printObj = System.out;
        System.out.println("printObj = " + printObj);
        printObj.println(8);
        System.out.println(8);
        System.out.println("-------------------------------------");
    }
}
