package com.gl.Java2023Session51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {

        // Stream API
        Stream<Integer> integerStream;
        Stream<String> stringStream;
        Stream<Student> studentStream;

        Stream<Object> emptyObject = Stream.empty();

        emptyObject.forEach(System.out::println);


        Stream<String> streamObject1 = Stream.of("one");

        streamObject1
                .filter(s -> s.length() > 1)
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));


        Stream<String> streamObject2 = Stream.of("one", "two", "three", "four", "five", "six");

        List<Integer> list = streamObject2
                .filter(e -> e.length() > 3)
                .map(e -> e.length())
                .toList();

        System.out.println("list = " + list);

        List<String> list1 = List.of("one", "two", "three", "four", "five", "six");
        ArrayList<Integer> list2 = new ArrayList<>();
        for (String e : list1) {
            if (e.length() > 3) {
                int len = e.length();
                list2.add(len);
            }
        }
        System.out.println("list2 = " + list2);


        Stream<String> streamObject3 = Stream.<String>builder()
                .add("one")
                .add("two")
                .add("three")
                .build();

        List<String> list3 = streamObject3
                .map(String::toUpperCase)
                .toList();
        System.out.println("list3 = " + list3);

        for (int i = 10; i < 20; i = i + 3) {
            System.out.println("i = " + i);
        }

        Stream<Integer> streamObject4 = Stream.iterate(1, i -> i < 20, i -> i + 1);
        List<Integer> list4 = streamObject4
                .filter(e -> e % 2 == 0)
                .toList();
        System.out.println("list4 = " + list4);

        List<Integer> list5 = Arrays.asList(100, 20, 30, 50);

        Stream<Integer> streamObject5 = list5.stream();

        System.out.println(
                streamObject5
                        .filter(e -> e > 30)
                        .toList()
        );

        List<Integer> list6 = list5.stream()
                .filter(e -> e > 30)
                .toList();

        System.out.println(

                list6
        );


        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("one");
        stringArrayList.add("two");
        stringArrayList.add("three");
        stringArrayList.add("four");

        Stream<String> streamObject6 = stringArrayList.stream();

        streamObject6
                .map(String::toUpperCase)
                .forEach(System.out::println);

        stringArrayList.stream()
                .filter(e -> e.length() > 0)
                .map(String::toUpperCase)
                .forEach(System.out::println);


        int[] a = {8, 4, 9, 2, 6};

        Arrays.stream(a)
                .filter(e -> e > 4)
                .map(e -> e * 100)
                .forEach(System.out::println);

        Arrays.stream(a)
                .sorted()
                .forEach(System.out::println);

        List<Integer> list7 = Arrays.stream(a)
                .boxed()
                .sorted()
                .toList();
        System.out.println("list7 = " + list7);


        String[] names = {"john", "smith", "tom", "zenith"};

        Arrays.stream(names)
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Collection<Integer> nums = List.of(11, 4, 2, 8);
        Stream<Integer> stream = nums.stream();

    }
}

class Student {
}
