package com.gl.MergeCombineJoinList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {

        List<Integer> even = even(10);
        System.out.println("even = " + even);

        List<Integer> odd = odd(10);
        System.out.println("odd = " + odd);

        List<Integer> num = new ArrayList<>();
        for (int n : odd) {
            num.add(n);
        }
        for (int n : even) {
            num.add(n);
        }

        consumeData(num);

        List<Integer> num1 = new ArrayList<>();
        num1.addAll(odd);
        num1.addAll(even);
        consumeData(num1);

        List<Integer> num2 = new ArrayList<>(odd);
        num2.addAll(even);
        consumeData(num2);

        List<Integer> num3 = Stream.concat(odd.stream(), even.stream()).toList();
        consumeData(num3);

        List<Integer> integers = List.of(11, 22, 33, 44, 55);

        List<Integer> num4 = Stream.concat(num3.stream(), integers.stream()).toList();
        consumeData(num4);

        List<Integer> num5 = Stream.of(odd, even, integers).flatMap(Collection::stream).toList();
        consumeData(num5);

    }

    static void consumeData(List<Integer> list) {
        System.out.println("list = " + list);
    }

    static List<Integer> even(int n) {
        return IntStream.range(1, n).filter(e -> e % 2 == 0).boxed().toList();
    }

    static List<Integer> odd(int n) {
        return IntStream.range(1, n).filter(e -> e % 2 != 0).boxed().toList();
    }
}
