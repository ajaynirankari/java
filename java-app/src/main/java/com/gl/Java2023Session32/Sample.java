package com.gl.Java2023Session32;

public class Sample {
    public static void main(String[] args) {
        System.out.println("main ok");
        int[] a = new int[5];

        Test obj1 = new Test();
        System.out.println("--------------------------------------------");
        Test obj2 = new Test();
        System.out.println("--------------------------------------------");
        Test obj3 = new Test();
        System.out.println("--------------------------------------------");

        Test.staticHello(); // static method called from class name
        System.out.println("--------------------------------------------");
        //Test.hello(); // non-static method can not called from class name

        Test tesObject = new Test();
        tesObject.instanceMethodHello();

        System.out.println("--------------------------------------------");
        Test tesObject1 = new Test();
        tesObject1.instanceMethodHello();

        int x = 10;
        System.out.println("main x = " + x);

        class Test2 {
            // Local class
        }
    }

    class Test1 {
        // Nested class
        class Test12 {
            class Test13 {
            }
        }
    }

    static class Test11 {
        // static Nested class
    }
}

class Test {

    // Variables, Methods, Blocks, Classes, Constructors               <--------- instance or each object
    // static Variables, static Methods, static Blocks, static Classes <--------- only once / claas level

    // static variable - class variable
    // static initialization block {}

    // initialization block {}
    // variable - instance variable

    // method  - instance method
    // static method -  class level method


    // Constructors

    Test() {
        System.out.println("Constructor() of Test class with x = " + x + ", x1 = " + x1 + " x2 = " + x2);
    }

    void instanceMethodHello() {
        System.out.println("instance method hello() called ....");
    }

    static void staticHello() {
        System.out.println("static method Hello() called ....");
    }

    {
        System.out.println("instance initialization block1{}, it is call for each object/instance");
    }

    static {
        System.out.println("---------------- static initialization block{}, it is call only one time");
    }

    {
        System.out.println("instance initialization block2{}, it is call for each object/instance");
    }

    int x = 1;
    float x1 = 2;
    double x2 = 3;
    static int x3 = 100;
}
