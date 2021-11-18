package com.gl.FunctionFunctionalInterface;

import java.util.List;
import java.util.function.Function;

public class FunctionFunctionalInterfaceDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list
                .stream()
                //.map(n-> Double.valueOf(n))
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        Function<Integer, Double> functionObj = new MyFunction();
        list
                .stream()
                .map(functionObj)
                .forEach(System.out::println);

        Function<Integer, Double> functionObj1 = new Function<Integer, Double>() {
            @Override
            public Double apply(Integer integer) {
                return Double.valueOf(integer);
            }
        };
        list
                .stream()
                .map(functionObj1)
                .forEach(System.out::println);


        Function<Integer, Double> functionObj2 = (Integer integer) -> {
            return Double.valueOf(integer);
        };
        list
                .stream()
                .map(functionObj2)
                .forEach(System.out::println);

        Function<Integer, Double> functionObj3 = integer -> Double.valueOf(integer);
        list
                .stream()
                .map(functionObj3)
                .forEach(System.out::println);

        list
                .stream()
                .map(integer -> Double.valueOf(integer))
                .forEach(System.out::println);


        list
                .stream()
                .map(FunctionFunctionalInterfaceDemo::convert)
                .forEach(System.out::println);

        list
                .stream()
                .map(n -> n * 2)
                .map(FunctionFunctionalInterfaceDemo::convert)
                .forEach(System.out::println);
    }

    static String convert(int n) {
        return String.valueOf(n) + " str value";
    }
}

class MyFunction implements Function<Integer, Double> {
    @Override
    public Double apply(Integer integer) {
        return Double.valueOf(integer);
    }
}
