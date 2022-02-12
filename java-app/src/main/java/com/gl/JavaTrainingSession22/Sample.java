package com.gl.JavaTrainingSession22;

public class Sample {
    public static void main(String[] args) {

        //Test obj = new Test() // for abstract class - not allowed to create object
        //obj.show();

        Test obj = new SubClass();
        obj.show();
        obj.calculate(30, 20);

        Test test = new AddClass();
        callme(test);
        test = new SubClass();
        callme(test);

        Simple simple = new Simple();
        //MyInterface myInterface = new MyInterface();
        //Test test1 = new Test();

        MyInterface myInterface;
        Test test1;

        myInterface = new MyImplementationClass2();
        test1 = new SubClass();
    }

    static void callme(Test obj) {
        obj.calculate(50, 20);
    }
}

abstract class Test {

    Test() {
        System.out.println("Test()");
    }

    private int x = 90;
    int b;

    void show() {
        System.out.println(" show() x=" + x);
    }

    abstract int calculate(int x, int y);
}

class AddClass extends Test {

    void show() {
        System.out.println(" SubClass show()=");
    }

    @Override
    int calculate(int x, int y) {
        int r = x + y;
        System.out.println("AddClass r = " + r + "");
        return r;
    }
}

class SubClass extends Test {

    void show() {
        System.out.println(" SubClass show()=");
    }

    @Override
    int calculate(int x, int y) {
        int r = x - y;
        System.out.println("SubClass r = " + r + "");
        return r;
    }
}

interface MyInterface {
    int x = 90;
    public static final int C = 900;

    void m1();

    abstract void m2();

    default void m3() {
        m4();
    }

    private void m4() {
    }

    static void m5() {
    }

    private static void m6() {
    }
}

interface MyInterface2 {
    void m8();
}

interface MyInterface3 {

}

abstract class AnyClass extends Test implements MyInterface, MyInterface2, MyInterface3 {
    @Override
    int calculate(int x, int y) {
        return 0;
    }
}

class SomeOtherClass extends AnyClass implements MyInterface, MyInterface2, MyInterface3 {
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m8() {

    }
}

class Simple {
    Simple() {
    }

    int x = 0;

    void me() {
    }
    //void mr();
}

class SimpleClass implements MyInterface, MyInterface2, MyInterface3 {

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m8() {

    }
}

abstract class MyImplementationClass implements MyInterface {
    @Override
    public void m1() {
        System.out.println("m1()");
    }
}

class MyImplementationClass2 extends MyImplementationClass {

    @Override
    public void m2() {
        System.out.println("m2()");
    }

}
