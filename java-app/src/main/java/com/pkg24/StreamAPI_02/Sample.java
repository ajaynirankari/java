package com.pkg24.StreamAPI_02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        for (int n : list) {
            int d = doubleIt(n);
            printIt(d);
        }

        Stream<Integer> stream = list.stream();
        //stream.map()

        MyInterface myInterface = new MyInterfaceImp();
        System.out.println("new Class = " + myInterface.method(4));
        take(myInterface);

        MyInterface myInterface1 = new MyInterface() {
            public int method(int x) {
                x = x * 4;
                return x;
            }
        };
        System.out.println("Anonymous = " + myInterface1.method(4));
        take(myInterface1);

        MyInterface myInterface2 = (int x) -> {
            x = x * 5;
            return x;
        };
        System.out.println("Lambda = " + myInterface2.method(4));
        take(myInterface2);

        take((int x) -> {
            x = x * 7;
            return x;
        });

        take((x) -> {
            x = x * 7;
            return x;
        });

        take(x -> {
            x = x * 7;
            return x;
        });

        take(x -> {
            return x * 7;
        });

        take(x -> x * 7);

        take(x -> x * 8);

        take(Sample::doubleIt);
    }

    static void take(MyInterface myInterface) {
        System.out.println(myInterface.method(4));
    }

    static int doubleIt(int n) {
        int d = n + n;
        return d;
    }

    static void printIt(int n) {
        System.out.println("n = " + n);
    }
}

interface MyInterface {
    int method(int x);
}

class MyInterfaceImp implements MyInterface {
    public int method(int x) {
        x = x * 3;
        return x;
    }
}
