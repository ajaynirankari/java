package com.gl.Java2023Session40;

public class Sample {
    public static void main(String[] args) {

        TopLevel.staticMethod();
        System.out.println("TopLevel.staticVariable = " + TopLevel.staticVariable);

        System.out.println("----------------------------------------------------");
        TopLevel topLevel = new TopLevel();
        topLevel.instanceMethod();
        System.out.println("topLevel.instanceVariable = " + topLevel.instanceVariable);
        System.out.println("----------------------------------------------------");
        TopLevel topLevel1 = new TopLevel();
        topLevel1.instanceMethod();
        System.out.println("topLevel1.instanceVariable = " + topLevel1.instanceVariable);
        System.out.println("----------------------------------------------------");

        TopLevel.StaticNestedClass staticNestedClass = new TopLevel.StaticNestedClass();
        TopLevel.StaticNestedClass.staticNestedClassMethod();
        System.out.println("----------------------------------------------------");

        TopLevel topLevelObject = new TopLevel();
        TopLevel.NestedClass nestedClass = topLevelObject.new NestedClass();
        nestedClass.nestedClassInstanceMethod();
        System.out.println("----------------------------------------------------");

        topLevelObject.test2();
        topLevelObject.test(11);
        System.out.println("----------------------------------------------------");

        // Type of Named class
        //      Simple/TopLevel
        //                  NestedClass or Inner class
        //                                  AnotherNestedClass
        //                  StaticNestedClass
        // Local class in side a method
        // All the above classes have no inheritance relation

        // Class without name is known as Anonymous class
        // Anonymous class is inheritance relationship

        SupperClass supperClassObject = new SupperClass();
        supperClassObject.test();

        SupperClass supperClassObject1 = new SubClass();
        supperClassObject1.test();

        SupperClass supperClassObject2 = new AnotherSubClass();
        supperClassObject2.test();


        SupperClass supperClassObject3 = new SupperClass() {
            void test() {
                System.out.println("test of OneMoreAnotherSubClass");
            }
        };
        supperClassObject3.test();

    }
}

class TopLevel {

    NestedClass objNestedClass = new NestedClass(); // ---> class allow to use class before define class

    void test(int x) {
        //System.out.println(y);                    ---> Not allow to use variable before declare it
        int y = x;
        System.out.println("Test() use abc before declare it = " + abc + " use local variable y after declare it = " + y);

        //LocalClassTest obj = new LocalClassTest();  ---> Not allow to use class before define class
        // Local class
        class LocalClassTest {
            void localTest() {
                System.out.println("localTest()");
            }
        }
        LocalClassTest obj = new LocalClassTest();
        obj.localTest();
    }

    // Instance Class - Inner class
    class NestedClass {
        void nestedClassInstanceMethod() {
            System.out.println("nestedClassInstanceMethod");
        }

        class AnotherNestedClass {
        }
    }

    // Static class
    static class StaticNestedClass {
        static void staticNestedClassMethod() {
            System.out.println("staticNestedClassMethod");
        }
    }

    // Constructor
    TopLevel() {
        System.out.println("Constructor()");
    }

    // Instance Variable
    int instanceVariable = 9;

    void instanceMethod() {
        System.out.println("instanceMethod()");
    }

    {
        System.out.println("instance block{}");
    }

    // Static Variable
    static int staticVariable = 10;

    static void staticMethod() {
        System.out.println("instanceMethod()");
    }

    static {
        System.out.println("static instance block{}");
    }

    void test2() {
        System.out.println(abc);
    }
    int abc = 99;
}

class SupperClass {
    void test() {
        System.out.println("test of SupperClass");
    }
}

class SubClass extends SupperClass {
    void test() {
        System.out.println("test of SubClass");
    }
}

class AnotherSubClass extends SupperClass {
    void test() {
        System.out.println("test of AnotherSubClass");
    }
}