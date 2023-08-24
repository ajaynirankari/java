package com.gl.Java2023Session47;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        List<String> listOfStrings = List.of("one", "two", "three", "four", "five", "six", "seven");

        for (int i = 0; i < listOfStrings.size(); i++) {
            String s = listOfStrings.get(i);
            System.out.println(s);
        }
        System.out.println("-------------------------------------------");

        listOfStrings.stream()
                .forEach(System.out::println);
        System.out.println("-------------------------------------------");

        for (int i = 0; i < listOfStrings.size(); i++) {
            String s = listOfStrings.get(i);
            if (s.length() == 3) {
                System.out.println(s);
            }
        }
        System.out.println("-------------------------------------------");

        listOfStrings.stream()
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
        System.out.println("-------------------------------------------");

        List<String> threeLengthString = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            String s = listOfStrings.get(i);
            if (s.length() == 3) {
                threeLengthString.add(s);
            }
        }
        System.out.println("threeLengthString = " + threeLengthString);
        System.out.println("-------------------------------------------");

        List<String> collect0 = listOfStrings.stream()
                .filter(s -> s.length() == 3)
                .collect(Collectors.toList());
        System.out.println("collect0 = " + collect0);
        System.out.println("-------------------------------------------");

        List<String> threeLengthStringWithUpperCase = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            String s = listOfStrings.get(i);
            if (s.length() == 3) {
                String upperCase = s.toUpperCase();
                threeLengthStringWithUpperCase.add(upperCase);
            }
        }
        System.out.println("threeLengthStringWithUpperCase = " + threeLengthStringWithUpperCase);
        System.out.println("-------------------------------------------");

        List<String> collect = listOfStrings
                .stream()
                .filter(s -> s.length() == 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("-------------------------------------------");

        System.out.println(
                listOfStrings
                        .stream()
                        .filter(s -> s.length() > 3)
                        .collect(Collectors.toList())
        );
        System.out.println("-------------------------------------------");

        System.out.println(
                listOfStrings
                        .stream()
                        .filter(s -> s.length() > 3)
                        .map(s -> s.length())
                        .collect(Collectors.toList())
        );
        System.out.println("-------------------------------------------");

        List<Integer> numbers = List.of(4, 7, 2, 5);
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int v = numbers.get(i);
            sum = sum + v;
        }
        System.out.println("sum = " + sum);
        System.out.println("-------------------------------------------");

        System.out.println(
                numbers.stream()
                        .reduce(0, (carry, v) -> carry + v)
        );
        System.out.println("-------------------------------------------");

        int sum1 = numbers.stream()
                .reduce(0, (carry, v) -> carry + v);

        System.out.println("sum1 = " + sum1);
        System.out.println("-------------------------------------------");

        int sum2 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);
        System.out.println("-------------------------------------------");

        int mul = 1;
        for (int i = 0; i < numbers.size(); i++) {
            int v = numbers.get(i);
            mul = mul * v;
        }
        System.out.println("mul = " + mul);
        System.out.println("-------------------------------------------");

        int mul1 = numbers.stream()
                .reduce(1, (c, v) -> c * v);
        System.out.println("mul1 = " + mul1);
        System.out.println("-------------------------------------------");
    }
}
