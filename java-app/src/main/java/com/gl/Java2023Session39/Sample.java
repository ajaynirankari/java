package com.gl.Java2023Session39;

public class Sample {
    public static void main(String[] args) {

        // MyInterface obj =  new MyInterface(); // NOT allow to create the object of interface

        MyInterface.staticMethod();
        System.out.println(MyInterface.MAX);
        System.out.println(MyInterface.MIN);
        //MyInterface.defaultMethod();      // NOT allow to call the NON-static method from interface name
        System.out.println("------------------------------------------");

        System.out.println(Test.a);
        //System.out.println(Test.b);    // NOT allow to access the NON-static variable from class name
        Test.test();
        //Test.test1();               // NOT allow to call the NON-static method from class name
        System.out.println("------------------------------------------");

        MyInterface obj1 = new MyInterfaceSumImplementationClass();
        obj1.defaultMethod();
        obj1.calculate(3, 4);
        obj1.calculate(2, 3, 4);
        //obj1 .calculate(2, 3, 4, 5); NOT define in interface
        System.out.println("------------------------------------------");

        MyInterfaceSumImplementationClass obj2 = new MyInterfaceSumImplementationClass();
        obj2.defaultMethod();
        obj2.calculate(3, 4);
        obj2.calculate(2, 3, 4);
        obj2.calculate(2, 3, 4, 5);
        System.out.println("------------------------------------------");

        MyInterfaceSumImplementationClass sumObj = new MyInterfaceSumImplementationClass();
        sumObj.calculate(2, 3, 4, 5);
        System.out.println("------------------------------------------");

        MyInterfaceMultiplicationImplementationClass mulObj = new MyInterfaceMultiplicationImplementationClass();
        mulObj.calculate(2, 3, 4, 5);
        System.out.println("------------------------------------------");

        call(sumObj);
        call(mulObj);

        System.out.println("------------------------------------------");
        int x = 10;
        System.out.println(x);
        x = x + 30;
        System.out.println(x);

        final int a = 10;
        System.out.println("a = " + a);
        //a = a + 30;                    // NOT allow to change the final variable value
        System.out.println("a = " + a);
        System.out.println("------------------------------------------");
    }

    static void call(MyInterface obj) {
        obj.defaultMethod();
        obj.calculate(2, 3);
        obj.calculate(2, 3, 4);
        //obj.calculate(2, 3, 4, 5);   // NOT allow to call the implementation class method
        System.out.println("------------------------------------------");
    }
}

interface MyInterface {
    // Constant variables - public static final
    // Declare method signature - <Return type> methodName(Parameter List);
    // Abstract method
    // Default method
    // static method

    int MAX = 100; // by default - public static final
    public static final int MIN = 1;

    int calculate(int x, int y); // by default - it is public abstract

    public abstract int calculate(int x, int y, int z);

    default void defaultMethod() {
        System.out.println("Default method");
    }

    static void staticMethod() {
        System.out.println("static method");
    }
}

class MyInterfaceSumImplementationClass implements MyInterface {

    @Override
    public int calculate(int x, int y) {
        System.out.println("sum calculate(x,y) call");
        int s = x + y;
        System.out.println("sum calculate(x,y) call, sum = " + s + " MAX= " + MAX);
        return s;
    }

    @Override
    public int calculate(int x, int y, int z) {
        System.out.println("sum calculate(x,y,z) call");
        int s = x + y + z;
        System.out.println("sum calculate(x,y,z) call, sum = " + s);
        return s;
    }

    public int calculate(int x, int y, int z, int p) {
        System.out.println("sum calculate(x,y,z,p) call");
        int s = x + y + z + p;
        System.out.println("sum calculate(x,y,z) call, sum = " + s);
        return s;
    }

}

class MyInterfaceMultiplicationImplementationClass implements MyInterface {

    @Override
    public int calculate(int x, int y) {
        System.out.println("mul calculate(x,y) call");
        int s = x * y;
        System.out.println("mul calculate(x,y) call, sum = " + s + " MIN = " + MIN);
        return s;
    }

    @Override
    public int calculate(int x, int y, int z) {
        System.out.println("mul calculate(x,y,z) call");
        int s = x * y * z;
        System.out.println("mul calculate(x,y,z) call, sum = " + s);
        return s;
    }

    public int calculate(int x, int y, int z, int p) {
        System.out.println("mul calculate(x,y,z,p) call");
        int s = x * y * z * p;
        System.out.println("mul calculate(x,y,z) call, sum = " + s);
        return s;
    }

}

abstract class MyInterfaceImplementationClass1 implements MyInterface {
}

interface MyInterface1 {
    void m1();

}

interface MyInterface2 {
    void m2();
}

abstract class MyImplClass implements MyInterface, MyInterface1, MyInterface2 {

    @Override
    public int calculate(int x, int y) {
        System.out.println("calculate(x,y) of MyInterface");
        return 0;
    }

    @Override
    public int calculate(int x, int y, int z) {
        System.out.println("calculate(x,y,z) of MyInterface");
        return 0;
    }

    @Override
    public void m1() {
        System.out.println("m1() of MyInterface1");
    }

}

class Another extends MyImplClass {
    @Override
    public void m2() {
        System.out.println("m2() of MyInterface2");
    }
}


class Test {
    static int a = 100;
    int b = 100;

    static void test() {
        System.out.println("static test()");
    }

    void test1() {
        System.out.println("test1()");
    }
}
