package com.gl.LoopImperativeVsDeclarativeStyle;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LoopImperativeVsDeclarativeStyleDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            if (i != 2) {
                int t = i * 2;
                System.out.print(t + ",");
            }
        }
        System.out.println();

        IntStream.range(0, 10)
                .filter(i -> !(i == 2))
                .map(i -> i * 2)
                .forEach(i -> System.out.print(i + ","));

        System.out.println();

        Stream.iterate(0, i -> i < 10, i -> i + 1)
                //.parallel()
                .filter(i -> !(i == 2))
                .map(i -> i * 2)
                .forEach(i -> System.out.print(i + ","));

        System.out.println();

        Stream.iterate(0, i -> i + 1)
                .filter(i -> !(i == 2))
                .map(i -> i * 2)
                .limit(9)
                .forEach(i -> System.out.print(i + ","));
    }
}
