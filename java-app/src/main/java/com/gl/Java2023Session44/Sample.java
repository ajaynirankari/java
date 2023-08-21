package com.gl.Java2023Session44;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Sample {
    public static void main(String[] args) {

        // Java Collection Framework

        Iterable<String> strings0 = List.of("one", "two", "three", "four", "five", "six");
        Collection<String> strings1 = List.of("one", "two", "three", "four", "five", "six");
        List<String> strings2 = List.of("one", "two", "three", "four", "five", "six");


        Iterable<String> strings00 = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six"));
        Collection<String> strings11 = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six"));
        List<String> strings22 = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six"));
        ArrayList<String> strings23 = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six"));


        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

        String s = list.get(3);
        System.out.println("s = " + s);
        System.out.println("-----------------------------------------------");

        System.out.println("list.get(4) = " + list.get(4));
        int size = list.size();
        System.out.println("size = " + size);
        System.out.println("-----------------------------------------------");

        System.out.println("list.get(4) = " + list.get(size - 1));
        System.out.println("-----------------------------------------------");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println("-----------------------------------------------");

        list.add("seven");
        for (int i = 0; i <= list.size() - 1; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-----------------------------------------------");

        for (String t : list) {
            System.out.println(t);
        }
        System.out.println("-----------------------------------------------");

        list.forEach(e -> System.out.println(e));
        System.out.println("-----------------------------------------------");

        // FunctionalInterface - Consumer<T> can be implemented via four ways
        // 1 - via Implementation Class
        // 2 - via Anonymous class
        // 3 - via Lambda expression
        // 4 - via Method reference

        class ConsumerImpl implements Consumer<String> {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }
        Consumer<String> consumerObj = new ConsumerImpl();
        list.forEach(consumerObj);
        System.out.println("-----------------------------------------------");

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String e) {
                System.out.println(e);
            }
        };
        list.forEach(consumer1);
        System.out.println("-----------------------------------------------");

        Consumer<String> consumer = (e) -> System.out.println(e);
        list.forEach(consumer);
        System.out.println("-----------------------------------------------");

        list.forEach((e) -> System.out.println(e));
        System.out.println("-----------------------------------------------");

        list.forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        list.forEach(Sample::myPrint);
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < list.size(); i++) {
            String s1 = list.get(i);
            if (s1.length() == 3) {
                System.out.println(s1);
            }
        }
        System.out.println("-----------------------------------------------");

        list.stream()
                .filter(e -> e.length() == 3)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        // FunctionalInterface - Predicate<T> can be implemented via four ways
        // 1 - via Implementation Class
        // 2 - via Anonymous class
        // 3 - via Lambda expression
        // 4 - via Method reference

        class PredicateImpl implements Predicate<String> {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        }
        Predicate<String> predicateObj = new PredicateImpl();
        list.stream()
                .filter(predicateObj)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        };
        list.stream()
                .filter(predicate)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        Predicate<String> predicate1 = (input) -> input.length() == 3;
        list.stream()
                .filter(predicate1)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        list.stream()
                .filter(input -> input.length() == 3)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        list.stream()
                .filter(Sample::checkLengthIf3)
                .forEach(System.out::println);
    }

    static boolean checkLengthIf3(String input) {
        return input.length() == 3;
    }

    static void myPrint(String e) {
        System.out.println(e);
    }
}
