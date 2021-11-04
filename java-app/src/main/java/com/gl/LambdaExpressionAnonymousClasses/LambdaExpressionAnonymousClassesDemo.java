package com.gl.LambdaExpressionAnonymousClasses;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface MyInterface {
    void calculate(int b);
    //void test();
}

public class LambdaExpressionAnonymousClassesDemo {
    public static void main(String[] args) {

        //MyInterface obj = new MyInterface();
        MyInterface obj = new MyInterfaceImpl();
        callMe(obj);

        MyInterface obj1 = new MyInterface() {
            @Override
            public void calculate(int b) {
                System.out.println("Implemented by Anonymous Class - Called with value = " + b);
            }
        };
        callMe(obj1);

        MyInterface obj2 = (int b) -> {
            System.out.println("Implemented by Lambda Expression - Called with value = " + b);
        };
        callMe(obj2);


        MyInterface obj3 = (b) -> {
            System.out.println("Implemented by Lambda Expression - Called with value = " + b);
        };
        callMe(obj3);

        MyInterface obj4 = (b) -> System.out.println("Implemented by Lambda Expression - Called with value = " + b);
        callMe(obj4);
        callMe(b -> System.out.println("Implemented by Lambda Expression - Called with value = " + b));

        MyInterface obj5 = LambdaExpressionAnonymousClassesDemo::calculateInputValue;
        callMe(obj5);
        callMe(LambdaExpressionAnonymousClassesDemo::calculateInputValue);

        callMeFunction((b) -> System.out.println("Implemented by Consumer interface - Called with value = " + b));

        Predicate<Integer> predicate = b -> b > 5;
        Function<Integer, Integer> function = b -> b * 2;
        Consumer<Integer> consumer = n -> System.out.println(n);

        List<Integer> list = List.of(1, 2, 3, 4, 5, 7, 8, 9, 10);
        list.stream()
                .filter(predicate)
                .map(function)
                .forEach(consumer);

        System.out.println();

        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 7, 8, 9, 10);
        list1.stream()
                .filter(b -> b > 5)
                .map(b -> b * 2)
                .forEach(System.out::println);

    }

    static void calculateInputValue(int x) {
        System.out.println("Implemented by Method Reference - Called with value = " + x);
    }

    static void callMe(MyInterface obj) {
        obj.calculate(100);
    }

    static void callMeFunction(Consumer obj) {
        obj.accept(100);
    }
}

class MyInterfaceImpl implements MyInterface {
    @Override
    public void calculate(int b) {
        System.out.println("Implemented by Class - Called with value = " + b);
    }
}