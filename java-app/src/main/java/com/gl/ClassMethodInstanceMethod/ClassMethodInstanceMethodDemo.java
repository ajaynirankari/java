package com.gl.ClassMethodInstanceMethod;

public class ClassMethodInstanceMethodDemo {
    public static void main(String[] args) {

        Test test = null;
        test.staticMethod1();
        System.out.println(test.staticVar);

        Test.staticMethod1();
        System.out.println(Test.staticVar);

        Test test1 = new Test();
        test1.instanceMethod1();
        Test test2 = new Test();
        test2.instanceMethod2();

        System.out.println(test1.instanceVar);
    }
}

class Test {
    static int staticVar = 10; // class variable or static variable
    int instanceVar = 10; // non-static variable or instance variable

    // This is an instance method or non-static method
    void instanceMethod1() {
        System.out.println("instanceMethod1()");
        instanceMethod2();
        staticMethod1();
        System.out.println(staticVar);
        System.out.println(instanceVar);
    }

    void instanceMethod2() {
        System.out.println("instanceMethod2()");
    }

    // This is class method or static method
    static void staticMethod1() {
        System.out.println("staticMethod1()");
        staticMethod2();
        //instanceMethod2();  NOT allowed accessing directly instance method
        Test test = new Test();
        test.instanceMethod2();
        System.out.println(staticVar);
        //System.out.println(instanceVar); NOT allowed accessing directly instance variable
        System.out.println(test.instanceVar);
    }

    static void staticMethod2() {
        System.out.println("staticMethod1()");
    }
}