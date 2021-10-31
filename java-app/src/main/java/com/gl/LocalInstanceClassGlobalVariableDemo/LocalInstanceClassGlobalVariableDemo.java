package com.gl.LocalInstanceClassGlobalVariableDemo;

public class LocalInstanceClassGlobalVariableDemo {
    public static void main(String[] args) {

        System.out.println(Test.shared);
        Test.shared = 300;

        System.out.println(Test.shared);

        Test ob1 = new Test(100, 200);
        ob1.display();
        ob1.shared = 888;
        System.out.println(ob1.shared);

        Test ob2 = new Test(101, 201);
        ob2.display();
        System.out.println(ob2.shared);

        System.out.println(Test.MAX);
        System.out.println(Test.MIN);

        //Test.MIN=100;   // Not allowed to modify the Global variable
    }
}

class Test {

    public static final int MAX = 9999;     // Global Variable
    public static final int MIN = 1;        // Global Variable

    static int shared;                       // Class Variable

    int field1;                              // Instance Variable

    Test(int a, int b) {
        field1 = a;
        field2 = b;
    }

    void show() {
        int a;                                // Local Variable
        a = 90;
        System.out.println("Value of a = " + a);
        //private int b=10;
        //System.out.println("Value of c = "+c);
        final int c = 100;

    }

    void display() {
        System.out.println("field1=" + field1);
        System.out.println("field2=" + field2);
    }

    private int field2;                        // Instance Variable
}
