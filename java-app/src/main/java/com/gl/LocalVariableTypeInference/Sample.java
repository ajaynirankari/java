package com.gl.LocalVariableTypeInference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Sample {
    public static void main(String[] args) {
        //String name ="John";
        var name = "John";
        System.out.println(name.length());
        //System.out.println(name.foo());

        var x = 1.1;

        List<String> strings = List.of("one", "two", "three");

        for (String d : strings) {
            System.out.println("d = " + d);
        }
        for (var d : strings) {
            System.out.println("d = " + d);
        }

        for (int i = 0; i < strings.size(); i++) {
            System.out.println("strings = " + strings.get(i));
        }

        for (var i = 0; i < strings.size(); i++) {
            System.out.println("strings = " + strings.get(i));
        }

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.submit(() -> System.out.println("OK"));
        }

        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.submit(() -> System.out.println("OK"));
        }

        Function<Integer, Integer> increment = (Integer a) -> a + 1;
        Function<Integer, Integer> decrement = (var a) -> a - 1;

        BiFunction<Integer, Integer, Integer> fn = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> fn1 = (var a, var b) -> a + b;
        //BiFunction<Integer, Integer, Integer> fn2 = (var a, Integer b) -> a + b;                      Not allowed
        BiFunction<Integer, Integer, Integer> fn3 = (Integer a, Integer b) -> a + b;

        // var f;                                                                              Not allowed

        Runnable runnable = () -> System.out.println("OK");
        //var runnable = () -> System.out.println("OK");                                        Not allowed

        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("OK");
        //var myFunctionalInterface = () -> System.out.println("OK");                           Not allowed


        //var obj = null;                                           Not allowed
        int[] d = {2, 3, 4};
        //var f = {2, 3, 4};                                        Not allowed

        var var = 908;
        System.out.println("var = " + var);

        List<String> stringList1 = new ArrayList<>();
        var stringList2 = new ArrayList<>();

        byte flag = 0;
        //flag = 130;

        var flag_ = 0;
        flag_ = 130;
    }

    static void test(int b) {
        //int x = 9;
        var x = 9;
    }
}

interface MyFunctionalInterface {
    void test();
}
// class var{}                              Not allowed
// interface var{}                          Not allowed

class Emp {
    int age;
    //var salary;                       Not allowed

}