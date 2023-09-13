package com.gl.Java2023Session63;

import java.util.ArrayList;

public class Sample {
    public static void main(String[] args) {

        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> intArrayList = new ArrayList<>();


        Box box = new Box();
        box.setX(4.5);
        Object x = box.getX();
        System.out.println("Object x = " + x);

        double dd = (double) box.getX();
        System.out.println("dd = " + dd);

        Box box1 = new Box();
        box1.setX("test");
        Object x1 = box1.getX();
        System.out.println("Object x = " + x1);

        String ss = (String) box1.getX();
        System.out.println("ss = " + ss);

        Box box2 = new Box();
        box2.setX(new MyClass());
        box2.setX(11);
        box2.setX("string");
        box2.setX(56.7);
        Object x2 = box2.getX();
        Double x22 = (Double) box2.getX();

        Box<Integer> box3 = new Box<>();
        box3.setX(34);
        // box3.setX("string"); here compiler not allow to add string
        Integer x3 = box3.getX();
        System.out.println("x3 = " + x3);

        Box<String> box4 = new Box<>();
        //box4.setX(12);
        box4.setX("string");

        String x4 = box4.getX();
        System.out.println("x4 = " + x4);

        Box<MyClass> box5 = new Box<>();
        //box5.setX(123);
        //box5.setX("one");
        box5.setX(new MyClass());
        MyClass x5 = box5.getX();

        Integer op = Util.op(4, 5);
        Double op1 = Util.op(4.5, 68.0);
        String op2 = Util.op("one", "two");
        MyClass op3 = Util.op(new MyClass(), new MyClass());

        Integer op4 = Util.<Integer>op(5, 6);
        Double op5 = Util.<Double>op(51.1, 61.1);
        String op6 = Util.<String>op("one", "two");
        MyClass op7 = Util.<MyClass>op(new MyClass(), new MyClass());

    }
}

class Box<T> {
    private T x;

    public void setX(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }
}

class Util {
    static <T> T op(T x, T y) {
        return x;
    }
}

class MyClass {
}

class Operation<T, R> {
    T one;
    R two;

    public Operation(T one, R two) {
        this.one = one;
        this.two = two;
    }
}

interface Test<T, R> {
    R get(T t);
}