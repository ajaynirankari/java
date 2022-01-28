package com.gl.JavaSession03;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {

        List<Integer> list = List.of(2, 3, 4, 5);

        list.stream()
                .forEach(e -> System.out.print(e + ","));
        System.out.println();

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int e = list.get(i);
            sum = sum + e;
        }
        System.out.println("sum = " + sum);

        BinaryOperator<Integer> funSum = (a, b) -> a + b;

        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int e = list.get(i);
            sum = funSum.apply(sum, e);
        }
        System.out.println("sum = " + sum);


        Optional<Integer> reduce = list.stream()
                .reduce((a, b) -> a + b);

        System.out.println("reduce = " + reduce);
        System.out.println("reduce = " + reduce.orElseThrow());

        Optional<Integer> reduce_ = list.stream()
                .reduce(funSum);

        System.out.println("reduce_ = " + reduce_);
        System.out.println("reduce_ = " + reduce_.orElseThrow());


        Optional<Integer> reduce5 = list.stream()
                .reduce((total, e) -> {
                    int s = total + e;
                    System.out.println("total=" + total + ",e=" + e + ",sum = " + s);
                    return s;
                });
        System.out.println("reduce5 = " + reduce5);


        Integer reduce6 = list.stream()
                .reduce(0, (total, e) -> {
                    int s = total + e;
                    System.out.println("total=" + total + ",e=" + e + ",sum = " + s);
                    return s;
                });
        System.out.println("reduce6 = " + reduce6);

        Integer reduce7 = list.stream()
                .reduce(1, (total, e) -> {
                    int s = total * e;
                    System.out.println("total=" + total + ",e=" + e + ",mul = " + s);
                    return s;
                });
        System.out.println("reduce7 = " + reduce7);

        Integer reduce8 = list.parallelStream()
                .reduce(1, (total, e) -> {
                    int s = total * e;
                     System.out.println("total=" + total + ",e=" + e + ",mul = " + s);
                    return s;
                });
        System.out.println("reduce8 = " + reduce8);

        Integer reduce1 = list.parallelStream()
                .reduce(0,
                        (total, e) -> {
                            int s = total + e;
                            System.out.println("accumulator total=" + total + ",e=" + e + ",mul = " + s + " " + Thread.currentThread());
                            return s;
                        },
                        (total1, total2) -> {
                            int total = total1 + total2;
                            System.out.println("combiner total1 = " + total1 + ", total2=" + total2 + ",total=" + total + " " + Thread.currentThread());
                            return total;
                        }
                );
        System.out.println("reduce1 = " + reduce1);


        ArrayList<Integer> reduce2 = list.stream()
                .filter(e -> e % 2 == 0)
                .reduce(new ArrayList<Integer>(),
                        (list_, e) -> {
                            list_.add(e);
                            return list_;
                        },
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }
                );
        System.out.println("reduce2 = " + reduce2);


        HashSet<Integer> reduce3 = list.stream()
                .filter(e -> e % 2 == 0)
                .reduce(new HashSet<Integer>(),
                        (hSet, e) -> {
                            hSet.add(e);
                            return hSet;
                        },
                        (hSet1, hSet2) -> {
                            hSet1.addAll(hSet2);
                            return hSet1;
                        }
                );
        System.out.println("reduce3 = " + reduce3);

        HashMap<Integer, Integer> reduce4 = list.stream()
                .filter(e -> e % 2 == 0)
                .reduce(new HashMap<Integer, Integer>(),
                        (mp, e) -> {
                            mp.put(e, e * 2);
                            return mp;
                        },
                        (mp1, mp2) -> {
                            mp1.putAll(mp2);
                            return mp1;
                        }
                );
        System.out.println("reduce4 = " + reduce4);


        List<Integer> collect = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        collect.add(13);
        System.out.println("collect = " + collect);

        List<Integer> collect1 = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("collect1 = " + collect1);

        LinkedList<Integer> collect2 = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("collect2 = " + collect2);


        List<Integer> integers = list.stream()
                .filter(e -> e % 2 == 0)
                .toList();
        System.out.println("integers = " + integers);

        Integer[] integers1 = list.stream()
                .filter(e -> e % 2 == 0)
                .toArray(Integer[]::new);
        System.out.println("integers1 = " + Arrays.toString(integers1));

    }
}
