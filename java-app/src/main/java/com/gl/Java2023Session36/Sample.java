package com.gl.Java2023Session36;

public class Sample {
    public static void main(String[] args) {

        SuperClass superClass = new SuperClass();
        superClass.say();                        // Compile-time polymorphism -> Overloading
        superClass.say("John");                  // Compile-time polymorphism -> Overloading
        superClass.sum(10, 20);             // Compile-time polymorphism -> Overloading
        superClass.sum(10, 20, 30);       // Compile-time polymorphism -> Overloading

        SubClass subClass = new SubClass();
        subClass.sum(1, 2);
        subClass.sum(1, 2, 3);
        subClass.sum(1, 2, 3, 4);        // Compile-time polymorphism -> Overloading

        AnOtherSubClass anOtherSubClassObject = new AnOtherSubClass();
        System.out.println("anOtherSubClassObject.hashCode() = " + anOtherSubClassObject.hashCode());

        Test test = new Test();                  // Object class is the super class of all java classes
        System.out.println("test.hashCode() = " + test.hashCode());

        SubClass subClassObject = new SubClass();
        subClassObject.say();

        SuperClass superClassObject = new SuperClass();
        SubClass subClassObject_ = new SubClass();

        print(subClassObject_);
        print(superClassObject);
    }

    static void print(SuperClass obj) {
        System.out.println("--------------------------------------");
        obj.say();                      // Run-time polymorphism -> Overriding
        System.out.println("--------------------------------------");
    }
}

class SuperClass {
    SuperClass() {
        System.out.println("SuperClass constructor");
    }

    void say() {
        System.out.println("SuperClass Say Hello");
    }

    void say(String message) {
        System.out.println("SuperClass Say Hello," + message);
    }

    void sum(int a, int b) {
        int sum = a + b;
        System.out.println("SuperClass sum = " + sum);
    }

    void sum(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("SuperClass sum = " + sum);
    }
}

class SubClass extends SuperClass {
    SubClass() {
        System.out.println("SubClass constructor");
    }

    @Override
    void say() {                                            // Run-time polymorphism -> Overriding
        System.out.println("SubClass Say Hello");
    }

    void sum(int a, int b, int c, int d) {                  // Compile-time polymorphism -> Overloading
        int sum = a + b + c + d;
        System.out.println("SubClass sum = " + sum);
    }
}

class AnOtherSubClass extends SubClass {
    AnOtherSubClass() {
        System.out.println("AnOtherSubClass constructor");
    }
}

class Test {

    @Override
    public String toString() {
        return "Test{}";
    }
}
