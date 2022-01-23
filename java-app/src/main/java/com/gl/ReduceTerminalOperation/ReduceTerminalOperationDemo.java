package com.gl.ReduceTerminalOperation;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ReduceTerminalOperationDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        numbers.stream()
                .forEach(e -> System.out.print(e + ","));
        System.out.println();

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + numbers.get(i);
        }
        System.out.println("sum = " + sum);

        BinaryOperator<Integer> sumFunction = (a, b) -> a + b;

        sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum = sumFunction.apply(sum, numbers.get(i));
        }
        System.out.println("sum = " + sum);


        Optional<Integer> reduce = numbers.stream()
                .reduce((total, element) -> {
                            int s = total + element;
                            System.out.println("total=" + total + ", element=" + element + ", sum = " + s);
                            return s;
                        }
                );
        System.out.println("reduce = " + reduce);
        System.out.println("reduce = " + reduce.orElse(0));

        Optional<Integer> reduce1 = numbers.stream()
                .reduce((total, element) -> total + element);
        System.out.println("reduce1 = " + reduce1);

        Integer reduce2 = numbers.stream()
                .reduce(0, (total, element) -> {
                            System.out.println("total = " + total + ",element=" + element + ",sum=" + (total + element));
                            return total + element;
                        }
                );
        System.out.println("reduce2 = " + reduce2);

        Integer reduce3 = numbers.stream()
                .reduce(0, (total, element) -> total + element);
        System.out.println("reduce3 = " + reduce3);

        Integer reduce4 = numbers.parallelStream()
                .reduce(0,
                        (total, element) -> {
                            System.out.println("accumulator total = " + total + ",element=" + element + ",sum=" + (total + element) + " " + Thread.currentThread());
                            return total + element;
                        },
                        (total1, total2) -> {
                            System.out.println("combiner total1 = " + total1 + ",total2=" + total2 + ",sum=" + (total2 + total2) + " " + Thread.currentThread());
                            return total1 + total2;
                        }
                );
        System.out.println("reduce4 = " + reduce4);

        ArrayList<Integer> reduce5 = numbers.stream()
                .filter(e -> e % 2 == 0)
                .reduce(new ArrayList<Integer>(),
                        (list, element) -> {
                            list.add(element);
                            return list;
                        },
                        (listA, listB) -> {
                            listA.addAll(listB);
                            return listA;
                        }
                );
        System.out.println("reduce5 = " + reduce5);

        HashSet<Integer> reduce6 = numbers.stream()
                .filter(e -> e % 2 == 0)
                .reduce(new HashSet<Integer>(),
                        (list, element) -> {
                            list.add(element);
                            return list;
                        },
                        (listA, listB) -> {
                            listA.addAll(listB);
                            return listA;
                        }
                );
        System.out.println("reduce6 = " + reduce6);

        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        HashMap<String, Integer> reduce7 = strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .reduce(
                        new HashMap<String, Integer>(),
                        (map, str) -> {
                            map.put(str, str.length());
                            return map;
                        },
                        (map1, map2) -> {
                            map1.putAll(map2);
                            return map1;
                        }
                );
        System.out.println("reduce7 = " + reduce7);

        List<String> strings1 = strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .toList();
        System.out.println("strings1 = " + strings1);

        String[] strings2 = strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println("strings2 = " + Arrays.toString(strings2));

        List<Integer> collect = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        collect.add(13);
        System.out.println("collect = " + collect);

        List<Integer> collect1 = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("collect1 = " + collect1);
        //collect1.add(13); NOT allowed
        System.out.println("collect1 = " + collect1);

        List<Integer> integers = numbers.stream()
                .filter(e -> e % 2 == 0)
                .toList();
        System.out.println("integers = " + integers);
        //integers.add(13); NOT allowed
        System.out.println("integers = " + integers);

        Set<Integer> collect2 = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println("collect2 = " + collect2);

        LinkedList<Integer> collect3 = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println("collect3 = " + collect3);
    }
}
