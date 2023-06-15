package com.gl.Java2023Session06;

public class Test1 {
    Test test;

    public static void main(String[] args) {
        //System.out.println("test = " + test);
        System.out.println("Test1 main() ");
        say();

        Test3 obj = new Test3();
        obj.say();

        Test1 ojb1 = new Test1();
        ojb1.say1();

        System.out.println(" ------------------------- ");
        Test obj0 = new Test();
        System.out.println(" ------------------------- ");
        obj0 = null;
        System.out.println("obj0 = " + obj0);
        Test obj01 = new Test();
        Test obj02 = new Test();

    }

    static void say() {
        //System.out.println("test = " + test);
        System.out.println("Hello Test1");
    }

    void say1() {
        System.out.println("test = " + test);
        if (test != null) {
            test.say();
        }
        System.out.println("Hello Test11");
    }
}

class Test3 {
    void say() {
        System.out.println("Hello Test3");
    }
}

class Test4 {
    void say() {
        System.out.println("Hello Test4");
    }
}
