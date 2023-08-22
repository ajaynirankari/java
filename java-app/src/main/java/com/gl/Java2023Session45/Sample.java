package com.gl.Java2023Session45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {

        ArrayList<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("four");
        collection.add("five");

        System.out.println(collection);
        System.out.println("----------------------------------------------------");

        System.out.println("collection.get(0) = " + collection.get(0));
        collection.add("six");
        System.out.println(collection);
        System.out.println("----------------------------------------------------");

        collection.add(3, "newValue");
        System.out.println(collection);
        System.out.println("----------------------------------------------------");

        collection.add("ten");
        System.out.println(collection);
        System.out.println("----------------------------------------------------");

        collection.add(0, "zero");
        System.out.println(collection);
        System.out.println("----------------------------------------------------");

        System.out.println("collection.get(0) = " + collection.get(0));
        System.out.println("collection.get(3) = " + collection.get(3));

        System.out.println("----------------------------------------------------");
        System.out.println("Before remove -----> " + collection + ", size = " + collection.size());

        collection.remove(4);
        System.out.println("After remove -----> " + collection + ", size = " + collection.size());
        System.out.println("----------------------------------------------------");

        System.out.println("collection.get(0) = " + collection.get(0));
        System.out.println("collection.get(1) = " + collection.get(1));
        System.out.println("collection.get(2) = " + collection.get(2));
        System.out.println("collection.get(3) = " + collection.get(3));
        System.out.println("----------------------------------------------------");

        System.out.println(collection);
        System.out.println("----------------------------------------------------");

        collection.forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        List<Integer> setOfNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("----------------Imperative style coding ----------------------");

        // What I want to do and also How to do it
        for (int i = 0; i < setOfNumbers.size(); i++) {
            int n = setOfNumbers.get(i);
            if (isEven(n)) {
                int doubleIt = doubleIt(n);
                System.out.println(doubleIt);
            }
        }
        System.out.println("----------------Stream API Declarative/functional style coding----------------------");

        // What I want to do, NOT How to do
        setOfNumbers.stream()
                .filter(Sample::isEven)
                .map(Sample::doubleIt)
                .forEach(Sample::printIt);
        System.out.println("----------------------------------------------------");

        Stream<Integer> doubleItStream = setOfNumbers.stream()
                .filter(Sample::isEven)   // Intermediate operation
                .map(Sample::doubleIt);   // Intermediate operation

        System.out.println("----------------------------------------------------");

        doubleItStream.forEach(Sample::printIt);  // Terminal operation - is to start of stream API

        Stream<Integer> doubleItStreamForCollect = setOfNumbers.stream()
                .filter(Sample::isEven)   // Intermediate operation
                .map(Sample::doubleIt);   // Intermediate operation

        List<Integer> evenNumbers = doubleItStreamForCollect.collect(Collectors.toList());// Terminal operation - is start of stream API
        System.out.println("evenNumbers = " + evenNumbers);
        System.out.println("----------------------------------------------------");

        Stream<Integer> doubleItStreamForFindFirst = setOfNumbers.stream()
                .filter(Sample::isEven)   // Intermediate operation
                .map(Sample::doubleIt);  // Intermediate operation

        Integer firstEven = doubleItStreamForFindFirst.findFirst()
                .get(); // Terminal operation - is start of stream API
        System.out.println("firstEven = " + firstEven);
        System.out.println("----------------------------------------------------");

        setOfNumbers.stream()
                .filter(Sample::isEven)
                .map(Sample::doubleIt)
                .forEach(Sample::printIt);
        System.out.println("----------------------------------------------------");

        setOfNumbers.stream()
                .filter(Sample::isEven)
                .map(Sample::doubleIt)
                .collect(Collectors.toList());
        System.out.println("----------------------------------------------------");

        setOfNumbers.stream()
                .filter(Sample::isEven)
                .map(Sample::doubleIt)
                .findFirst()
                .get();
        System.out.println("----------------------------------------------------");

        System.out.println("original collection = " + collection);
        System.out.println(
                collection.stream()
                        .filter(s -> s.length() > 3)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList())
        );
        System.out.println("----------------------------------------------------");

        System.out.println("original collection = " + collection);
        System.out.println("----------------------------------------------------");

        System.out.println(
                collection.stream()
                        .filter(s -> s.length() > 3)
                        .map(String::toLowerCase)
                        .collect(Collectors.toList())
        );
        System.out.println("----------------------------------------------------");

        System.out.println("original collection = " + collection);
        System.out.println("----------------------------------------------------");
    }

    static boolean isEven(int n) {
        System.out.println("isEven = " + n);
        return n % 2 == 0;
    }

    static int doubleIt(int n) {
        System.out.println("doubleIt = " + n);
        return n * 2;
    }

    static void printIt(int n) {
        System.out.println("printIt = " + n);
        System.out.println(n);
    }

}
