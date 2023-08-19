package com.gl.Java2023Session42;

import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {
        // Lambda expression
        // Functional Interface - is interface which have only one Single Abstract Method

        MyInterface obj = new MyInterfaceImplementationClass();
        obj.test();
        System.out.println("-------------------------------------------");

        MyInterface obj1 = new MyInterface() {

            @Override
            public void test() {
                System.out.println("test() method is called from Anonymous class");
            }
        };
        obj1.test();
        System.out.println("-------------------------------------------");

        MyInterface obj2 = () -> {
            System.out.println("test() method is called from Lambda expression");
        };
        obj2.test();
        System.out.println("-------------------------------------------");

        MyInterface obj3 = () -> System.out.println("test() method is called from Lambda expression");
        obj3.test();
        System.out.println("-------------------------------------------");

        // Function      -------->    R apply(T t);
        // Consumer      -------->    void accept(T t);;
        // Supplier      -------->    T get();
        // Runnable      -------->    void run();
        // Predicate     -------->    boolean test(T t)

        // BiFunction      --------->   R apply(T t, U u);
        // BiConsumer      --------->   void accept(T t, U u);
        // BiPredicate     --------->   boolean test(T t, U u);


        Runnable obj4 = () -> System.out.println("test() method is called from Lambda expression");
        obj4.run();

        // Java Collection Framework or API
        // We can use Array to store collection of objects

        // Java Stream API - use Lambda Expression

        // Print all double of prime number between 1 to N
        final int N = 10;
        for (int e = 1; e < N; e++) {
            if (e % 2 == 0) {
                int doubleIt = e * 2;
                System.out.println(doubleIt);
            }
        }
        System.out.println("-------------------------------------------");

        IntStream.range(1, N)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> System.out.println(e));
        System.out.println("-------------------------------------------");

        MyInterface ob = () -> System.out.println("test()");
        call(ob);
        call(() -> System.out.println("test112"));

        TestInterface testInterface1 = new TestInterface() {
            @Override
            public int process(int n) {
                return n * 100;
            }
        };

        TestInterface testInterface2 = (int n) -> {
            return n * 100;
        };

        TestInterface testInterface3 = (int n) -> n * 100;

        TestInterface testInterface4 = (n) -> n * 100;

        TestInterface testInterface5 = n -> n * 100;

        TestInterface testInterface = n -> n * 100;

        callAnother(testInterface, 7);

        callAnother(n -> n * 100, 7);

        callAnother(e -> e * 10, 8);
    }

    static void call(MyInterface obj) {
        obj.test();
    }

    static void callAnother(TestInterface obj, int x) {
        System.out.println(obj.process(x));

    }
}

@FunctionalInterface
interface MyInterface {
    void test();
}

class MyInterfaceImplementationClass implements MyInterface {

    @Override
    public void test() {
        System.out.println("test() method is called from MyInterfaceImplementationClass");
    }
}

@FunctionalInterface
interface TestInterface {
    int process(int n);
}