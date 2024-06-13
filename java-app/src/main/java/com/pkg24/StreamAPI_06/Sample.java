package com.pkg24.StreamAPI_06;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("--------------------");
        Integer reduce1 = integers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, (total, e) -> total + e);
        System.out.println("reduce1 = " + reduce1);

        System.out.println("--------------------");
        Integer reduce2 = integers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, Sample::sum);
        System.out.println("reduce2 = " + reduce2);

        System.out.println("--------------------");
        String reduce3 = integers.stream()
                .map(String::valueOf)
                .reduce("", (c, n) -> c + n);
        System.out.println("reduce3 = " + reduce3);

        System.out.println("--------------------");
        String reduce4 = integers.stream()
                .map(String::valueOf)
                .reduce("", Sample::join);
        System.out.println("reduce4 = " + reduce4);

        System.out.println("--------------------");

        Integer reduce = integers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, (c, n) -> c + n);
        System.out.println("reduce = " + reduce);
        System.out.println("--------------------");

        IntStream.range(0, 10)
                .forEach(System.out::println);
        System.out.println("--------------------");

        for (int i = 10; i <= 20; i = i + 3) {
            if (i % 2 == 0) {
                int m = i * 2;
                System.out.println(m);
            }
        }

        System.out.println("--------------------");

        Stream.iterate(10, i -> i < 20, i -> i + 3)
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .forEach(System.out::println);


    }

    static int sum(int c, int e) {
        int r = c + e;
        return r;
    }

    static String join(String c, String e) {
        String r = c + "_" + e;
        return r;
    }
}
