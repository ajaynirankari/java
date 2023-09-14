package com.gl.Java2023Session64;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        test("one");
        test(123);
        test(12.3);

        print("two");
        print(345);
        print(34.5);

        List<String> stringList = new ArrayList<>();
        stringList.add("Test");
        //stringList.add(234);

        List<Integer> stringIntegers = new ArrayList<>();
        stringIntegers.add(23);
        //stringIntegers.add("test");

        List<Integer> integers = new ArrayList<>();
        List<Long> longs = new ArrayList<>();
        List<Short> shorts = new ArrayList<>();
        List<Byte> bytes = new ArrayList<>();

        integers.add(67);
        //integers.add(670l);

        //longs.add(67);
        longs.add(670l);

        List<Number> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(12L);
        numbers.add(1.2F);
        numbers.add(1.2);

        processUnboundedWildCardCollections(List.of(1, "test", 3.4F, 98L, new MyClass(56)));

        MyClass myClass = new MyClass(1);
        UpperSubClass upperSubClass = new UpperSubClass(2);
        LowerSubClass lowerSubClass = new LowerSubClass(3);
        Lower2SubClass lower2SubClass = new Lower2SubClass(4);

        processUnboundedWildCardCollections(List.of(myClass, upperSubClass, lowerSubClass, lower2SubClass));

        processLowerBoundedWildCardCollections(List.of(lowerSubClass, upperSubClass, myClass));

        processUpperBoundedWildCardCollections(List.of(lowerSubClass, lower2SubClass));


    }

    static void processLowerBoundedWildCardCollections(List<? super LowerSubClass> list) {
        System.out.println("------------------- Called processCollections");
        list.forEach(System.out::println);
    }

    static void processUpperBoundedWildCardCollections(List<? extends LowerSubClass> list) {
        System.out.println("------------------- Called processCollections");
        list.forEach(System.out::println);
    }

    static void processUnboundedWildCardCollections(List<?> list) {
        System.out.println("------------------- Called processCollections");
        list.forEach(System.out::println);
    }

    static void processWildCardInts(List<Integer> list) {
        System.out.println("------------------- Called processCollections");
        list.forEach(System.out::println);
    }


    static <T> void print(T t) {
        System.out.println("t = " + t);
    }

    static void test(String s) {
        System.out.println("s = " + s);
    }

    static void test(int s) {
        System.out.println("s = " + s);
    }

    static void test(double s) {
        System.out.println("s = " + s);
    }
}

class MyClass {
    int x;

    public MyClass(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "x=" + x +
                '}';
    }
}

class UpperSubClass extends MyClass {
    public UpperSubClass(int x) {
        super(x);
    }
}

class LowerSubClass extends UpperSubClass {
    public LowerSubClass(int x) {
        super(x);
    }
}

class Lower2SubClass extends LowerSubClass {
    public Lower2SubClass(int x) {
        super(x);
    }
}