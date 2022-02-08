package com.gl.JavaTrainingSession21;

public class Sample {
    public static void main(String[] args) {

        Test obj = null;
        obj.method();
        obj.method1(); // NOT prefer way to call static method
        Test.method1();
        //Test.method2(); private static method can not be called here
        //private methods are not allowed to call
        int s = obj.C;
        s = Test.C;
        System.out.println("s = " + s);

        Test obj1 = new Test(20);
        obj1.method();
        obj1.method1(); // should be avoided to call static method from, object reference

        Test obj2 = new Test(30);
        obj2.method();
        obj2.method1(); // should be avoided to call static method from, object reference
        obj1.method1(); // should be avoided to call static method from, object reference

        final int x = 100;
        System.out.println("x = " + x);
        //x=x+1; final variable can not be allowed to modify

        Test obj3 = new Test(5);
        obj3.method();
        obj3.method();
        obj3.method();

        Test obj4 = new Test(7);
        obj4.method();
        obj4.method();
        obj4.method();
    }
}

// final class is NOT support inheritance
final class Test extends AbcClass implements Interface1 {
    private int a; // instance variable // instance == object
    private final int constantVar = 99; // instance variable // instance == object
    private final int constantVar1; // instance variable // instance == object
    private static int b;   // class variable
    public static final int C = 90; // class variable

    public Test(int a) {
        this.a = a;
        constantVar1 = a * 100; // final variable can be initialized in constructor
        b = b + 1;
    }

    // instance method
    // final method are NOT allowed to override
    public final int method() {
        System.out.println("method() a = " + a + " constantVar= " + constantVar + " constantVar1=" + constantVar1);
        a = a + 1;
        //constantVar = constantVar+1;  // final variable can NOT allow to change
        //constantVar1 = constantVar1+1;
        return a;
    }

    // class method
    static int method1() {
        System.out.println("static method() b = " + b);
        method2();
        return b;
    }

    static private int method2() {
        System.out.println("static private method() b = " + b);
        return b;
    }

}

class Test1 {
    final void method() {
        System.out.println("method");
    }
}

class SubClass extends Test1 {
// super class final method can not allow to override
//    void method() {
//        System.out.println("method");
//    }
}

// SubClass can not extends final class Test
//class SubClass extends Test {
//}

interface Interface1 {
}

class AbcClass {
}