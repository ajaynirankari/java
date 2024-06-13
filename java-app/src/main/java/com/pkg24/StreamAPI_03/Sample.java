package com.pkg24.StreamAPI_03;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {
        List<Integer> sourceData = List.of(5, 6, 7);
        System.out.println("sourceData = " + sourceData);

        Function<Integer, Integer> myFunctionObject = new MyFunction();
        var r = myFunctionObject.apply(5);
        System.out.println("r = " + r);

        sourceData.stream()
                .map(myFunctionObject)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer + integer;
                    }
                })
                .map(n -> n + n)
                .map(Sample::doubleIt)
                .forEach(new MyConsumer());

        System.out.println("sourceData = " + sourceData);

        int a = 10;
        int b = 20;
        Stream.of(a, b)
                .map(myFunctionObject)
                .forEach(new MyConsumer());

        Stream.iterate(100, n -> n < 120, n -> n = n + 1)
                .map(n -> n + 1)
                .forEach(System.out::println);
    }

    static int doubleIt(int n) {
        return n + n;
    }
}

class MyFunction implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        //System.out.println("called apply = " + integer);
        return integer * 2;
    }
}

class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        //System.out.println("called accept = " + integer);
        System.out.println(integer + ",");
    }
}

