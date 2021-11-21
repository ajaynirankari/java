package com.gl.abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {

        //AbsBase obj = new AbsBase();
        //MyInterface obj1= new MyInterface();

        System.out.println(AbsBase.b);
        System.out.println(MyInterface.MAX);

        AbsBase obj = null;
        MyInterface obj0 = null;

        System.out.println(obj.b);
        System.out.println(AbsBase.b);

        System.out.println(obj0.MAX);
        System.out.println(MyInterface.MAX);

        AbsBase obj1 = new AbsSub();
        System.out.println(obj1.a);
        AbsBase obj2 = new AnotherAbsSub();
        System.out.println(obj2.a);

        MyInterface obj3 = new MyInterfaceImp();
        System.out.println(MyInterface.MAX);
        MyInterface obj4 = new MyInterfaceImp2();
        System.out.println(MyInterface.MAX);
        obj4.methodDefault();

        //MyInterface.methodStatic();
    }
}

class Base0 {
}

class Base {
}

abstract class AbsBase extends Base implements MyInterface0, MyInterface1 {
    int a = 12; // instance variable
    public static final int b = 30; // Manually we can define a class variable
    private int c = 13; // Can define private, protected, public

    AbsBase() {
        System.out.println("AbsBase() = " + a);
    }

    void method1() {
        System.out.println("AbsBase method1()");
    }

    static void method3() {
        System.out.println("AbsBase method1()");
    }

    abstract void method2();
}

class AbsSub extends AbsBase {
    AbsSub() {
        a = 100;
    }

    @Override
    void method2() {
        System.out.println("AbsSub()");
    }
}

class AnotherAbsSub extends AbsBase {
    AnotherAbsSub() {
        a = 200;
    }

    @Override
    void method2() {
        System.out.println("AbsSub()");
    }
}

abstract class AnotherAbsSub1 extends AbsBase {

}

interface MyInterface1 {
}

interface MyInterface0 {
}

interface MyInterface extends MyInterface0, MyInterface1 {
    int MAX = 12; // Default - this is public, static, final
    //private int c =13;

    //MyInterface(){}

    void method1(); // Default - abstract method

    default void methodDefault() {
        System.out.println("Default for all implementation classes");
        methodStatic();
    }

    private static void methodStatic() {
        System.out.println("Static for all implementation classes");
    }
}

class MyInterfaceImp implements MyInterface {
    @Override
    public void method1() {
        System.out.println("MyInterfaceImp");
        //methodStatic();
    }
}

class MyInterfaceImp2 implements MyInterface {
    @Override
    public void method1() {
        System.out.println("MyInterfaceImp2");
    }
}