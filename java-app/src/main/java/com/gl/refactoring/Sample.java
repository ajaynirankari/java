package com.gl.refactoring;

import java.util.List;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");
        IntStream
                .range(0, 5)
                .forEach(i -> System.out.println(i));

        System.out.println("--------------------------------");

        IntStream
                .range(0, 5)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");

        IntStream.rangeClosed(0, 5)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        for (int i = 0; i <= 10; i = i + 3) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");

        IntStream.iterate(0, i -> i <= 10, i -> i + 3)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        for (int i = 0; ; i = i + 3) {
            if (i > 20) break;
            System.out.println(i);
        }
        System.out.println("--------------------------------");

        IntStream.iterate(0, i -> i + 3)
                .takeWhile(i -> i <= 20)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        List<String> names = List.of("James", "Ben", "Tim", "Michael", "John");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("--------------------------------");

        names.forEach(name -> System.out.println(name));

        System.out.println("--------------------------------");

        names.forEach(System.out::println);

        System.out.println("--------------------------------");

        names.stream()
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        for (String name : names) {
            if (name.length()==4) {
                System.out.println(name);
            }
        }

        System.out.println("--------------------------------");

        names.stream()
                .filter(name -> name.length() == 4)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        for (String name : names) {
            System.out.println(name.toUpperCase());
        }

        System.out.println("--------------------------------");

        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        for (String name : names) {
            if (name.length() == 4) {
                System.out.println(name.toUpperCase());
            }
        }

        System.out.println("--------------------------------");

        names.stream()
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
