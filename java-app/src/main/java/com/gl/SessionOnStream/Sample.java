package com.gl.SessionOnStream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9);

        Function<Integer, Integer> doubleIt = e -> e * 2;

        IntSummaryStatistics intSummaryStatistics = list.stream()
                .filter(Sample::isEven)
                .map(doubleIt)
                .map(new MyFunction())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer * 2;
                    }
                })
                .map(integer -> integer * 2)
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        //.reduce(0, (a, b) -> a + b);
        //.mapToInt(Integer::intValue)
        //.sum();
        //System.out.println("sum = " + sum);

        System.out.println("intSummaryStatistics = " + intSummaryStatistics);


        List<Integer> collect = list.stream()
                .map(doubleIt)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        Set<Integer> collect1 = list.stream()
                .map(doubleIt)
                .collect(Collectors.toSet());
        System.out.println("collect1 = " + collect1);

        List<String> strings = List.of("one", "two", "three", "four", "five");
        String collect2 = strings.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.joining(","));
        System.out.println("collect2 = " + collect2);

        List<String> collect3 = strings.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);


        Map<Integer, Long> collect4 = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("collect4 = " + collect4);

        Map<Integer, List<String>> collect5 = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println("collect5 = " + collect5);

    }

    static boolean isEven(int e) {
        System.out.println("filter e = " + e);
        return e % 2 == 0;
    }

}

class MyFunction implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer * 2;
    }
}