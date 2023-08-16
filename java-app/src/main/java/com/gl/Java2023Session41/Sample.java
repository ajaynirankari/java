package com.gl.Java2023Session41;

public class Sample {
    public static void main(String[] args) {

        //MyInterface myInterfaceObject = new MyInterface(); -----> NOT allowed to create an object of interface
        //myInterfaceObject.test();

        MyInterface myInterfaceImplementationClassObject = new MyInterfaceImplementationClass();
        myInterfaceImplementationClassObject.test(10);
        System.out.println("-------------------------------------------------------------");

        MyInterface myInterfaceAnonymousClassObject = new MyInterface() {
            public void test(int x) {
                System.out.println("test() method is called from Anonymous Class x  * 3 = " + x * 3);
            }
            public void test2(int x, int x2) {
            }
        };
        myInterfaceAnonymousClassObject.test(10);
        System.out.println("-------------------------------------------------------------");

        MyInterface myInterfaceLambdaExpression1 = (int x) -> {
            System.out.println("test() method is called from Lambda expression x * 4 = " + x * 4);
        };
        myInterfaceLambdaExpression1.test(10);
        System.out.println("-------------------------------------------------------------");

        MyInterface myInterfaceLambdaExpression3 = (x) -> {
            System.out.println("test() method is called from Lambda expression x * 6 = " + x * 6);
        };
        myInterfaceLambdaExpression3.test(10);
        System.out.println("-------------------------------------------------------------");

        MyInterface myInterfaceLambdaExpression4 = (x) -> System.out.println("test() method is called from Lambda express x * 101 = " + x * 101);
        myInterfaceLambdaExpression4.test(10);
        System.out.println("-------------------------------------------------------------");

        MyInterface myInterfaceLambdaExpression5 = x -> System.out.println("test() method is called from Lambda express x * 105 = " + x * 105);
        myInterfaceLambdaExpression5.test(10);
        System.out.println("-------------------------------------------------------------");

        callMyInterface(myInterfaceImplementationClassObject, 5);
        callMyInterface(myInterfaceAnonymousClassObject, 3);

        callMyInterface(myInterfaceLambdaExpression1, 4);
        callMyInterface(myInterfaceLambdaExpression4, 5);

        callMyInterface((x) -> System.out.println("x * 10 = " + x * 10), 9);
    }

    static void callMyInterface(MyInterface myInterfaceObject, int value) {
        myInterfaceObject.test(value);
    }
}

@FunctionalInterface
interface MyInterface {
    void test(int x);  // Lambda expression ony work for Single Abstract Method
    //void test2(int x, int y);
}

class MyInterfaceImplementationClass implements MyInterface {
    public void test(int x) {
        System.out.println("test() method is called from MyInterfaceImplementationClass x * 2 = " + x * 2);
    }

    public void test2(int x, int x2) {
    }
}

@FunctionalInterface
interface MyInterface1 {
    //void test(int x);  // Lambda expression ony work for Single Abstract Method
    void test2(int x, int y);
}